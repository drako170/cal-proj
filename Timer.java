package reminderApplication;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Timer implements Runnable {

	
	public void run(){
		try {
       		Window primaryWindow = ReminderApplication.primaryStage;
       		
       		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Remind.fxml"));
       		Parent root1 = (Parent) fxmlLoader.load();
       		Stage stage = new Stage();
       		stage.setScene(new Scene(root1));  
       		stage.setTitle("Reminder");
       	
       		// Specifies the modality for new window.
       		stage.initModality(Modality.WINDOW_MODAL);
       		
       		// Specifies the owner Window (parent) for new window
       		stage.initOwner(primaryWindow);
       		
       		 // Set position of second window, related to primary window.
               stage.setX(primaryWindow.getX());
               stage.setY(primaryWindow.getY());
               
       		stage.show();
       	} catch(Exception e) {
       		System.out.println(e.getMessage());
       	}
	}
}
