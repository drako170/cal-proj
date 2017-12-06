package reminderApplication;
	

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



public class ReminderApplication extends Application{	
	
	//DList that contains reminder objects
	protected static DList<Reminder> list = new DList<Reminder>();
	protected static DList<Reminder> log = new DList<Reminder>();
	protected static Stage primaryStage;
    
	public void start(Stage primaryStage) {
		try {
			
			this.primaryStage = primaryStage;

			//Read file fxml and draw interface
			Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
			
			primaryStage.setTitle("My Application");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	
		
	}
	


	public static void main(String[] args) {
		launch(args);
	}
	
	
	
}
