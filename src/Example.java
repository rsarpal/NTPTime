import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.rsarpal.NetworkTime.NetworkTime;


public class Example {

    public static void main(String args[]){

        System.out.println("hello");
        NetworkTime nt=new NetworkTime("time.google.com");
        LocalDateTime ntpdate=nt.getTimeInLocalDateTime();
        DateTimeFormatter creditTimeFormat = DateTimeFormatter.ISO_LOCAL_DATE_TIME; //set date format
        String creditTime = ntpdate.format(creditTimeFormat);

        System.out.println("creditTime" + creditTime);
    }

}
