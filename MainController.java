package reminderApplication;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.io.*;

import javafx.application.Platform;
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

public class MainController extends Thread implements Initializable{
	
	protected Date date = new Date();
	
	@FXML
    private Button createReminderButton;

    @FXML
    private Button viewReminderButton;
    
    @FXML
    private Button closeButton;
    
    @FXML
    private Button viewLogButton;

	protected Runnable remind;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	closeButton.setCancelButton(true);
    	try {
			Scanner inputStream = new Scanner(new FileInputStream("reminders.txt"));
			while(inputStream.hasNext()){
				String[] rData = inputStream.nextLine().split(",");
				ReminderApplication.list.addToLast(new Reminder(rData[0], rData[1], rData[2], rData[3], rData[4]));
			}
			inputStream.close();
		
			 
		} catch (FileNotFoundException e) {
			
		}
    	
    	try {
			Scanner inputStream = new Scanner(new FileInputStream("log.txt"));
			while(inputStream.hasNext()){
				String[] rData = inputStream.nextLine().split(",");
				ReminderApplication.log.addToLast(new Reminder(rData[0], rData[1], rData[2], rData[3], rData[4]));
			}
			inputStream.close();
		
			 
		} catch (FileNotFoundException e) {
			
		}
    	
    	
    	new Thread() {
    		public void run() {
	    		try {
	
	   			 Date date;
	   			 Date compareDate;
	   		     	while (true) {
		   		    	 //sleep
		   		    	Thread.sleep(10 * 1000);
		   		    	
		   		    	if(ReminderApplication.list.getHeader() != null) {
		   			        date = new Date();
		   			        compareDate = new Date(date.getYear() + 1900,date.getMonth() , date.getDate(), date.getHours(), date.getMinutes());
		   			        
		   			        if(ReminderApplication.list.getHeader() != null && compareDate.compareTo(ReminderApplication.list.getHeader().getInfo().getCompare()) >= 0) {
		   			        	
		   			    		//open Remind.fxml
		   			    		Timer timer = new Timer();
		   			    		Platform.runLater(timer);
		   			        
		   			        }
		   		        
		   		       
		   		    	}
		   		    }
		   		} catch (InterruptedException e) { 
		   		    e.printStackTrace();
		   		}
    		}
    	}.start();
    	
    }

    
    
    @FXML
    //when user click on createReminderButton
    //this method will be called
    //Loads CreateReminder.fxml
    void createReminder(ActionEvent event) {
    	try {
    		Window primaryWindow = ReminderApplication.primaryStage;
    		
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
    
    
    @FXML
    //when user click on viewRemindersButton
    //this method will be called
    //Loads ViewReminders.fxml
    public void viewReminders(ActionEvent event) {
    	try {
    		Window primaryWindow = ReminderApplication.primaryStage;
    		
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
    		System.out.println(e.getMessage());
    	}
    }
    
    @FXML
    //when user click on viewRemindersButton
    //this method will be called
    //Loads ViewReminders.fxml
    public void viewLog(ActionEvent event) {
    	try {
    		Window primaryWindow = ReminderApplication.primaryStage;
    		
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ViewLog.fxml"));
    		Parent root1 = (Parent) fxmlLoader.load();
    		Stage stage = new Stage();
    		stage.setScene(new Scene(root1));  
    		stage.setTitle("Log");
    	
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
    
    public void closeButtonClicked(ActionEvent event){
  	  Stage stage = (Stage) closeButton.getScene().getWindow();
  	  
  	  //write to reminders.txt
  	  try {
		DLLNode<Reminder> root = ReminderApplication.list.header;
		PrintWriter outputStream = new PrintWriter(new FileOutputStream("reminders.txt"), true);
		while(root != null){
			Reminder r = root.getInfo();
			outputStream.println(r.getYear() + "," + r.getMonth() + "," + r.getDay() + "," + r.getTime() + "," + r.getMessage());
			root = (DLLNode<Reminder>) root.getLink();
		}
		outputStream.close();
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
  	
  	  
  	  //write to log.txt
  	try {
		DLLNode<Reminder> root = ReminderApplication.log.header;
		PrintWriter outputStream = new PrintWriter(new FileOutputStream("log.txt"), true);
		while(root != null){
			Reminder r = root.getInfo();
			outputStream.println(r.getYear() + "," + r.getMonth() + "," + r.getDay() + "," + r.getTime() + "," + r.getMessage());
			root = (DLLNode<Reminder>) root.getLink();
		}
		outputStream.close();
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
  	  
  	  stage.close();
    }
    

}
