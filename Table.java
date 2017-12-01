package reminderApplication;

public class Table {
	
	protected String date;
	protected String time;
	protected String message;
	
	public Table(String date, String time, String message) {
		this.date = date;
		this.time = time;
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	
	
}
