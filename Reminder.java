package reminderApplication;

public class Reminder {
	
	private String month;
	private String day;
	private String time;
	private String info;
	
	
	public Reminder(String month, String day, String time, String info){
		this.month = month;
		this.day = day;
		this.time= time;
		this.info = info;
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


	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}
	
	

}
