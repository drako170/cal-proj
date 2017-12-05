package reminderApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Timer extends Thread{
	
	public void run() {
		//check for reminder occurrence every minute
		 try {

			 Date date;
			 Date compareDate;
		     while (true) {
		        date = new Date();
		        compareDate = new Date(date.getYear() + 1900,date.getMonth() , date.getDate(), date.getHours(), date.getMinutes());
		        
		        if(ReminderApplication.list.getHeader() != null && compareDate.compareTo(ReminderApplication.list.getHeader().getInfo().getCompare()) == 0) {
		        	System.out.println("test");
		        }
		        
		        Thread.sleep(3 * 1000);
		        System.out.print(compareDate.getHours()+ " ");
		        System.out.println(ReminderApplication.list.getHeader().getInfo().getCompare().getHours());
		        

		        Thread.sleep(5 * 1000);
		    }
		} catch (InterruptedException e) { 
		    e.printStackTrace();
		}
	}
}
