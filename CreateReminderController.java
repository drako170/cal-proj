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
 
public class CreateReminderController implements Initializable {
 
   @FXML
   private TextField monthData;
  
   @FXML
   private TextField dayData;
   
   @FXML
   private TextField timeData;
   
   @FXML
   private TextField infoData;
   
   @FXML
   private Button createButton;
   

  
   @Override
   public void initialize(URL location, ResourceBundle resources) {
 
       // TODO (don't really need to do anything here).
      
   }
 
   // When user click on createButton
   // this method will be called.
   // Creates new reminder object and adds it to static DList variable
   // Prints "Reminder Created!" to console
   public void createReminder(ActionEvent event) {
       System.out.println("Reminder Created!");
      
       Reminder newReminder = new Reminder(monthData.getText(),dayData.getText(),timeData.getText(),infoData.getText());
       
       ReminderApplication.list.addToLast(newReminder);
   }
   
  
}
