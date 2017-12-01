package reminderApplication;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MainController implements Initializable{

	@FXML
    private Button createReminderButton;

    @FXML
    private Button viewReminderButton;
    
    @FXML
    private DList<Reminder> list = new DList<Reminder>();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
  
        // TODO (don't really need to do anything here).
       
    }
    
    @FXML
    //when user click on createReminderButton
    //this method will be called
    //Loads CreateReminder.fxml
    void createReminder(ActionEvent event) {
    	try {
    		Window primaryWindow = ((Node)event.getSource()).getScene().getWindow();
    		
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateReminder.fxml"));
    		Parent root1 = (Parent) fxmlLoader.load();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root1));  
    		stage.setTitle("New Reminder");
    	
    		// Specifies the modality for new window.
    		stage.initModality(Modality.WINDOW_MODAL);
    		
    		// Specifies the owner Window (parent) for new window
    		stage.initOwner(primaryWindow);
    		
    		 // Set position of second window, related to primary window.
            stage.setX(primaryWindow.getX());
            stage.setY(primaryWindow.getY());
            
    		stage.show();
    	} catch(Exception e) {
    		System.out.println("Can't load new window");
    	}
    }
    
    //When user click on viewReminderButton
    //this method will we called
    //Iterates through static DList variable and prints out each reminder object to the console
    public void printReminders(ActionEvent event) {
 	   
    	
 	   DLLNode<Reminder> node = ReminderApplication.list.getHeader();
 	   
 	   for(int i = 0; i < ReminderApplication.list.getSize(); i++) {
 		   
 		   Reminder item = (Reminder) node.getInfo();
 		   System.out.println(item.getMonth() + " " + item.getDay() + " " + item.getTime()+ ": " + item.getMessage());
 		   
 		   node = (DLLNode<Reminder>) node.getLink();
 	   }
    }
    
    @FXML
    //when user click on viewRemindersButton
    //this method will be called
    //Loads ViewReminders.fxml
    public void viewReminders(ActionEvent event) {
    	try {
    		Window primaryWindow = ((Node)event.getSource()).getScene().getWindow();
    		
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewReminders.fxml"));
    		Parent root1 = (Parent) fxmlLoader.load();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root1));  
    		stage.setTitle("Reminders Table");
    	
    		// Specifies the modality for new window.
    		stage.initModality(Modality.WINDOW_MODAL);
    		
    		// Specifies the owner Window (parent) for new window
    		stage.initOwner(primaryWindow);
    		
    		 // Set position of second window, related to primary window.
            stage.setX(primaryWindow.getX());
            stage.setY(primaryWindow.getY());
            
    		stage.show();
    	} catch(Exception e) {
    		System.out.println("Can't load new window");
    	}
    }
    
}
