package reminderApplication;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
 
public class CreateReminderController implements Initializable {
 
	ObservableList<String> timeList = FXCollections.observableArrayList("AM", "PM");
	ObservableList<Integer> hourList = FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12);
	ObservableList<String> minuteList = FXCollections.observableArrayList("00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21",
			"22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55",
			"56","57","58","59");

   
   @FXML
   private TextField messageData;
   
   @FXML
   private Button createButton;
   
   @FXML
   private Button closeButton;
   
   @FXML
   private DatePicker datePicker;
   
   @FXML
   private ChoiceBox<String> choiceBox;
   
   @FXML
   private ChoiceBox<Integer> hours;
   
   @FXML
   private ChoiceBox<String> minutes;
  
   @Override
   public void initialize(URL location, ResourceBundle resources) {
 
       choiceBox.setValue("PM");
       choiceBox.setItems(timeList);
       hours.setValue(12);
       hours.setItems(hourList);
       minutes.setValue("00");
       minutes.setItems(minuteList);
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
	       
	       Reminder newReminder = new Reminder(Integer.toString(datePicker.getValue().getYear()), datePicker.getValue().getMonth().name(), Integer.toString(datePicker.getValue().getDayOfMonth()), 
	    		   Integer.toString(hours.getValue()) + ":" + minutes.getValue() + " " + choiceBox.getValue(), 
	    		   messageData.getText(), datePicker.getValue());
	       
	       ReminderApplication.list.addToLast(newReminder);
	       
	       hours.setValue(12);
	       minutes.setValue("00");
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
