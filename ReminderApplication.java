package reminderApplication;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;


public class ReminderApplication extends Application{
	
	//DList that contains reminder objects
	protected static DList<Reminder> list = new DList<Reminder>();
    
	public void start(Stage primaryStage) {
		try {

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
