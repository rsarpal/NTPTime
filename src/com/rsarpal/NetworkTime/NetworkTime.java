/*
 

apache.commons.net package for NTPTime
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.NtpV3Packet;
import org.apache.commons.net.ntp.TimeInfo;

http://commons.apache.org/proper/commons-net/download_net.cgi
http://commons.apache.org/proper/commons-net/
http://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/ntp/NTPUDPClient.html
http://commons.apache.org/proper/commons-net/apidocs/org/apache/commons/net/ntp/NtpV3Packet.html


javac NetworkTime.java -cp "commons-codec-1.14.jar;commons-net-3.6.jar"

Run
java -cp "commons-codec-1.14.jar;commons-net-3.6.jar;." NetworkTime

 */




package com.rsarpal.NetworkTime;
import org.apache.commons.net.ntp.NTPUDPClient;
//import org.apache.commons.net.ntp.NtpV3Packet;
import org.apache.commons.net.ntp.TimeInfo;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.Instant;
import java.time.ZoneId;


public class NetworkTime {
	
	private long timeInMillis;
	private String TIME_SERVER;
	
	public NetworkTime( String timeServer ) {
		//TIME_SERVER = "ns.europe.someserve.com";   //some time server
		TIME_SERVER = timeServer;

	}

	public long getTimeInMillis(){


		NTPUDPClient timeClient = new NTPUDPClient();
		try {
			InetAddress inetAddress = InetAddress.getByName(TIME_SERVER);
			TimeInfo timeInfo = timeClient.getTime(inetAddress);
			timeInMillis = timeInfo.getMessage().getTransmitTimeStamp().getTime();
			//lr.output_message("time =" + returnTime);
		}catch (UnknownHostException uhe){
			uhe.printStackTrace();
		}catch (IOException ie){
			ie.printStackTrace();
		}


		return timeInMillis;

	}

	public LocalDateTime getTimeInLocalDateTime(){
		Instant instant = Instant.ofEpochMilli(getTimeInMillis());
		LocalDateTime date = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();

		return date;
	}




}

		