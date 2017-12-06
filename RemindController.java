package reminderApplication;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.io.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class RemindController implements Initializable{
	
	@FXML
	private TextField reminderMessage;
	
	@FXML
	private Button delayButton;

	@FXML
	private Button completeButton;
    
	private Reminder reminder;
	
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	//nothing here
    	reminderMessage.setText(ReminderApplication.list.getHeader().getInfo().getMessage());
    	
    	reminder = ReminderApplication.list.header.getInfo();
    	
    	//remove reminder from list
    	DLLNode<Reminder> root = ReminderApplication.list.header;
       	DLLNode<Reminder> next = (DLLNode<Reminder>) root.getLink();
       	
    	if(ReminderApplication.list.size == 1) {
    		ReminderApplication.list.header = null;
    	}
    	else {
	       	root.setLink(null);
	   		next.setBack(null);
	   		ReminderApplication.list.header = next;
	   		ReminderApplication.list.size--;
    	}
    	
    }
    
    @FXML
    //write reminder to log file, close window
    public void completeReminder(ActionEvent event) {
    	
    	Stage stage = (Stage) completeButton.getScene().getWindow();
    	
    	ReminderApplication.log.addToLast(reminder);
    
    	stage.close();
    	
    }

    @FXML
    void delayReminder(ActionEvent event) {
    	
    	Stage stage = (Stage) completeButton.getScene().getWindow();
    	stage.close();
    	
    	

    }

    
    

    

}
