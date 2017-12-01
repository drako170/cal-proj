package reminderApplication;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
	
	private ObservableList<Table> getReminders(){
		
		ObservableList<Table> reminders = FXCollections.observableArrayList();
		
		DLLNode<Reminder> node = ReminderApplication.list.getHeader();
		
		
		for(int i = 0; i < ReminderApplication.list.getSize(); i++) {

	 		   Reminder item = (Reminder) node.getInfo();
	 		   
	 		   String date = item.getDate();
	 		   String time = item.getTime();
	 		   String message = item.getMessage();
	 		   
	 		   System.out.println(date + time + message);
	 		   reminders.add(new Table(date, time, message));
	 		   
	 		   node = (DLLNode<Reminder>) node.getLink();
	 	}
		
		return reminders;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	 
		dateCol.setCellValueFactory(new PropertyValueFactory<Table, String>("date"));
		timeCol.setCellValueFactory(new PropertyValueFactory<Table, String>("time"));
		messageCol.setCellValueFactory(new PropertyValueFactory<Table, String>("message"));
		
		remindersTable.setItems(getReminders());
	      
	}
	
	
}
