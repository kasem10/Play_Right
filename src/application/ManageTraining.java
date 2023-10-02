package application;

import java.io.IOException;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ManageTraining implements Initializable {
	
	 
 

	 @FXML
	    private ComboBox<String> BudyGoal;
	 @FXML
	    private ComboBox<String> howManyDays;
	 @FXML
	 ListView<exercise> training;
	 @FXML
	 ComboBox<Integer> days;
	
	
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = FXCollections.observableArrayList("Muscle Building","Weight Loss");
		BudyGoal.setItems(list);
		ObservableList<String> list2 = FXCollections.observableArrayList("3 Days","4 Days","5 Days");
		howManyDays.setItems(list2);
		  
	}
	public void fillcombobox (ActionEvent event) throws IOException {
		if(howManyDays.getValue() == "3 Days") {
			days.getItems().clear();
			ObservableList<Integer> list3 = FXCollections.observableArrayList(1,2,3);
			days.setItems(list3);
		}
		if(howManyDays.getValue() == "4 Days") {
			days.getItems().clear();
			ObservableList<Integer> list3 = FXCollections.observableArrayList(1,2,3,4);
			days.setItems(list3);
		}
		if(howManyDays.getValue() == "5 Days") {
			days.getItems().clear();
			ObservableList<Integer> list3 = FXCollections.observableArrayList(1,2,3,4,5);
			days.setItems(list3);
		}
		
		
	}
	
	
	
	
	public void show(ActionEvent event) throws IOException {
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "3 Days" && days.getValue() ==1 ) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb3.get(1));
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "3 Days" && days.getValue() ==2 ) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb3.get(2));
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "3 Days" && days.getValue() ==3 ) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb3.get(3));
		}
		
		
		
		
		
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "4 Days" && days.getValue() ==1) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb4.get(1));	
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "4 Days" && days.getValue() ==2) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb4.get(2));	
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "4 Days" && days.getValue() ==3) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb4.get(3));	
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "4 Days" && days.getValue() ==4) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb4.get(4));	
		}
		
		
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "5 Days" && days.getValue() ==1) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb5.get(1));
				
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "5 Days" && days.getValue() ==2) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb5.get(2));
				
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "5 Days" && days.getValue() ==3) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb5.get(3));
				
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "5 Days" && days.getValue() ==4) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb5.get(4));
				
		}
		if(BudyGoal.getValue() == "Muscle Building" && howManyDays.getValue() == "5 Days" && days.getValue() ==5) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.mb5.get(5));
				
		}
		
		
		
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "3 Days" && days.getValue() ==1) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl3.get(1));	
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "3 Days" && days.getValue() ==2) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl3.get(2));	
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "3 Days" && days.getValue() ==3) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl3.get(3));	
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "4 Days" && days.getValue() ==1) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl4.get(1));
		}	
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "4 Days" && days.getValue() ==2) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl4.get(2));
			
			
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "4 Days" && days.getValue() ==3) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl4.get(3));
			
			
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "4 Days" && days.getValue() ==4) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl4.get(4));
			
			
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "5 Days" && days.getValue() ==1) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl5.get(1));
		
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "5 Days" && days.getValue() ==2) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl5.get(2));
		
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "5 Days" && days.getValue() ==3) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl5.get(3));
		
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "5 Days" && days.getValue() ==4) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl5.get(4));
		
		}
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "5 Days" && days.getValue() ==5) {
			training.getItems().clear();
			training.getItems().addAll(Main.gym.wl5.get(5));
		
		}
	}
	
	public void add(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("addexercise.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.show();
	 }
	public void remove(ActionEvent event) throws IOException{
		int Select = training.getSelectionModel().getSelectedIndex();
		 if(Main.gym.removeex((exercise)training.getItems().get(Select) ,BudyGoal.getValue() ,howManyDays.getValue() , days.getValue())) {
			 training.getItems().remove(Select);
			Main.update();
			Alert aler = new Alert(AlertType.CONFIRMATION);
			aler.setHeaderText("seccessfully remove");
			aler.showAndWait();
			}
	 }
	
	
	public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("manager.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.show();
	 }
	
	
	
	
	
	}
	
	
	
	


