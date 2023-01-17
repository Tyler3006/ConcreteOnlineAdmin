
package nz.co.concreteOnlineA.admin;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author tscos
 */
public class TimeClock {
    Calendar calendar;
    SimpleDateFormat timeFormat;
    JLabel timeLabel;
    private String time;
    
    public TimeClock(){
  timeFormat = new SimpleDateFormat("hh:mm:ss a");
          time = timeFormat.format(Calendar.getInstance().getTime());
    }

    /**
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
   
        

  
}
