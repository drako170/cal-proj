package reminderApplication;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ViewRemindersController implements Initializable {
	
	@FXML
	TableView<Table> remindersTable = new TableView<Table>();
	
	// Create column date (Data type of String).
	@FXML
    TableColumn<Table, String> dateCol;

    // Create column time (Data type of String).
	@FXML
    TableColumn<Table, String> timeCol;
	
	// Create column message (Data type of String).
	@FXML
    TableColumn<Table, String> messageCol;
	
	@FXML
	TableColumn<Table, Button> deleteReminder;
	
	private ObservableList<Table> getReminders(){
		
		ObservableList<Table> reminders = FXCollections.observableArrayList();
		
		DLLNode<Reminder> node = ReminderApplication.list.getHeader();
		
		
		for(int i = 0; i < ReminderApplication.list.getSize(); i++) {

	 		   Reminder item = (Reminder) node.getInfo();
	 		   
	 		   String date = item.getDate();
	 		   String time = item.getTime();
	 		   String message = item.getMessage();
	 		   Button button = new Button("X");
	 		   
	 		   button.setOnAction(new EventHandler<ActionEvent>() {
	 			   @Override public void handle(ActionEvent e){
	 				   DLLNode<Reminder> root = ReminderApplication.list.header;
	 				   int index = 0;
	 				   String s = item.getFull();
	 				   while(root != null){
		 				   if(root.getInfo().getFull().equals(s)){
		 					   DLLNode<Reminder> next = (DLLNode<Reminder>) root.getLink();
		 					   DLLNode<Reminder> pre = root.getBack();
		 					   if(next == null && pre == null){
		 						   ReminderApplication.list.header = null;
		 						  ReminderApplication.list.trailer = null;
		 					   }
		 					   else if(next == null){
		 						   ReminderApplication.list.removeLast();
		 					   }
		 					   else if(pre == null){
		 						   root.setLink(null);
		 						   next.setBack(pre);
		 						   ReminderApplication.list.header = next;
		 						   ReminderApplication.list.size--;
		 					   }
		 					   else{
		 						   pre.setLink(next);
		 						   next.setBack(pre);
		 						   root.setBack(null);
		 						   root.setLink(null);
		 						   ReminderApplication.list.size--;
		 					   }
		 					   reminders.remove(index);
		 				   }
		 				   index++;
		 				   root = (DLLNode<Reminder>) root.getLink();
	 				   }
	 			   }
	 		   });
	 		   
	 		   reminders.add(new Table(date, time, message, button));
	 		   
	 		   node = (DLLNode<Reminder>) node.getLink();
	 	}
		
		return reminders;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	 
		dateCol.setCellValueFactory(new PropertyValueFactory<Table, String>("date"));
		timeCol.setCellValueFactory(new PropertyValueFactory<Table, String>("time"));
		messageCol.setCellValueFactory(new PropertyValueFactory<Table, String>("message"));
		deleteReminder.setCellValueFactory(new PropertyValueFactory<Table, Button>("button"));
		
		remindersTable.setItems(getReminders());
	      
	}
	
}
