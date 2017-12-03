package reminderApplication;

public class Reminder {
	
	private String month;
	private String day;
	private String time;
	private String message;
	private String date;
	
	
	public Reminder(String month, String day, String time, String message){
		this.month = month;
		this.day = day;
		this.time= time;
		if(message.equals("")){
			this.message = " ";
		}
		else{
			this.message = message;
		}
		date = month + " " + day;
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
	
	
	

}
