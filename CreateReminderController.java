package reminderApplication;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
 
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.stage.Window;
import javafx.stage.Stage;
 
public class CreateReminderController implements Initializable {
 
   @FXML
   private TextField timeData;
   
   @FXML
   private TextField messageData;
   
   @FXML
   private Button createButton;
   
   @FXML
   private Button closeButton;
   
   @FXML
   private DatePicker datePicker;
  
   @Override
   public void initialize(URL location, ResourceBundle resources) {
 
       // TODO (don't really need to do anything here).
      
   }
 
   // When user click on createButton
   // this method will be called.
   // Creates new reminder object and adds it to static DList variable
   // Prints "Reminder Created!" to console
   public void createReminder(ActionEvent event) throws IllegalStateException {
	   try{    
		   if(datePicker.getValue() == null){
	    	   throw (new IllegalStateException("There is no data provided."));
	       }
	       
		   System.out.println("Reminder Created!");
	       
	       Reminder newReminder = new Reminder(datePicker.getValue().getMonth().name(),Integer.toString(datePicker.getValue().getDayOfMonth()),timeData.getText(),messageData.getText());
	       
	       ReminderApplication.list.addToLast(newReminder);
	       
	       timeData.clear();
	       messageData.clear();
	       datePicker.getEditor().clear();
	   }
	   catch(IllegalStateException e){
		   System.out.println(e.getMessage());
	   }
   }
   
  public void closeButtonClicked(ActionEvent event){
	  Stage stage = (Stage) closeButton.getScene().getWindow();
	  stage.close();
  }
   
}
