package reminderApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Reminder{
	
	private String month;
	private String day;
	private String time;
	private String message;
	private String date;
	private String year;
	private Date compare;
	
	private String full;
	
	@SuppressWarnings("deprecation")
	public Reminder(String year, String month, String day, String time, String message, LocalDate date){
		this.year = year;
		this.month = month;
		this.day = day;
		this.time= time;
		if(message.equals("")){
			this.message = " ";
		}
		else{
			this.message = message;
		}
		this.date = month + " " + day;
		compare = new Date(date.getYear(), date.getMonthValue(), date.getDayOfMonth(), 
				Integer.parseInt(time.substring(0, time.indexOf(":"))), Integer.parseInt(time.substring(time.indexOf(":")+1)));
		full = this.year + this.month + this.day + this.time + this.message;
	}

	@SuppressWarnings("deprecation")
	public Reminder(String year, String month, String day, String time, String message){
		this.year = year;
		this.month = month;
		this.day = day;
		this.time= time;
		if(message.equals("")){
			this.message = " ";
		}
		else{
			this.message = message;
		}
		this.date = month + " " + day;
		Date mon = null;
		try {
			mon = new SimpleDateFormat("MMMM").parse(month);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		if(mon == null)
			cal.setTime(mon);
		compare = new Date(Integer.parseInt(year), cal.get(Calendar.MONTH), Integer.parseInt(day), 
				Integer.parseInt(time.substring(0, time.indexOf(":"))), Integer.parseInt(time.substring(time.indexOf(":")+1, time.indexOf(":")+3)));
		full = this.year + this.month + this.day + this.time + this.message;
	}

	public String getMonth() {
		return month;
	}


	public void setMonth(String month) {
		this.month = month;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}
	
	public String getYear(){
		return year;
	}
	
	public void setYear(String year){
		this.year = year;
	}

	public String getFull(){
		return full;
	}

}
