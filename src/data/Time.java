
/*

 */
package data;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * Time Class
 * Contains methods relating to time and date
 * @author 869298
 */
public class Time {
  
    /**
     * Get the current date and time
     * @return The current date and time in dd/MM/YY HH:mm:ss format.
     * eg: 06/12/17 13:48
     */
    public String getDateTime() {
       DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
       Date date = new Date();
       
       
       return df.format(date);
	   }
}
