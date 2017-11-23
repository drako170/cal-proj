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
   
   @FXML
   private Button printButton;
   
   private DList<Reminder> list = new DList<Reminder>();
  
   @Override
   public void initialize(URL location, ResourceBundle resources) {
 
       // TODO (don't really need to do anything here).
      
   }
 
   // When user click on myButton
   // this method will be called.
   public void createReminder(ActionEvent event) {
       System.out.println("Reminder Created!");
      
       Reminder newReminder = new Reminder(monthData.getText(),dayData.getText(),timeData.getText(),infoData.getText());
       
       list.addToLast(newReminder);
   }
   
   public void printReminders(ActionEvent event) {
	   
	   DLLNode<Reminder> node = list.getHeader();
	   
	   for(int i = 0; i < list.getSize(); i++) {
		   
		   Reminder item = (Reminder) node.getInfo();
		   System.out.println(item.getMonth() + " " + item.getDay() + " " + item.getTime()+ ": " + item.getInfo());
		   
		   node = (DLLNode<Reminder>) node.getLink();
	   }
   }
   
   public void openCreateNewReminder() {
	   
   }
  
}
