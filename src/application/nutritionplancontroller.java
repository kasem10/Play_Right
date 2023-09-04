package application;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class nutritionplancontroller  implements Initializable {
	
	@FXML
    private ListView<Meal> meals;

    @FXML
    private ListView<Meal> AddedMeals;
    
    @FXML
    private Label cal, carbs, protin;
	
    double updatedCarbs=0, updatedCal=0, updatedProtin=0;
    double NeedsCarbs, NeedsCal, NeedsProtin;

	public void initialize(URL location, ResourceBundle resources) { 
		
		NeedsCarbs = Main.saveCarbs;
		NeedsCal = Main.saveCalories;
		NeedsProtin = Main.saveProtin;
	
		meals.getItems().addAll(Main.gym.getMeals().values());
		cal.setText(updatedCal + "/" + String.valueOf(Main.saveCalories));
		cal.setTextFill(Color.RED);
		carbs.setText(updatedCarbs + "/" + String.valueOf(Main.saveCarbs));
		carbs.setTextFill(Color.RED);
		protin.setText(updatedProtin + "/" + String.valueOf(Main.saveProtin));
		protin.setTextFill(Color.RED);
		
		
	    
	}
	
	public void addact(MouseEvent Action) {
		try {
		int Select = meals.getSelectionModel().getSelectedIndex();
		AddedMeals.getItems().add(meals.getItems().get(Select));
		updatedCarbs=0; 
		updatedCal=0;
		updatedProtin=0;
		for (Meal meal : AddedMeals.getItems()) {
			updatedCarbs = updatedCarbs+ meal.getCarbs();
			updatedCal = updatedCal +meal.getCal();
			updatedProtin = updatedProtin+ meal.getProtin();
		}
		cal.setText(updatedCal + "/" + String.valueOf(Main.saveCalories));
		if(updatedCal - NeedsCal < 10   &&  updatedCal>NeedsCal) {
			cal.setTextFill(Color.GREEN);
		}
		else {
			cal.setTextFill(Color.RED);
		}
		
		
		carbs.setText(updatedCarbs + "/" + String.valueOf(Main.saveCarbs));
		if(updatedCarbs - NeedsCarbs < 10   && updatedCarbs>NeedsCarbs ) {
			carbs.setTextFill(Color.GREEN);
		}
		else {
			carbs.setTextFill(Color.RED);
		}
		
		
		
		protin.setText(updatedProtin + "/" + String.valueOf(Main.saveProtin));
		if(updatedProtin - NeedsProtin < 10 && updatedProtin>NeedsProtin) {
			protin.setTextFill(Color.GREEN);
		}
		else {
			protin.setTextFill(Color.RED);
		}
		
		
		
		}catch(IndexOutOfBoundsException e) {
			Alert aler = new Alert(AlertType.ERROR);
			aler.setHeaderText("no selected thing");
			aler.showAndWait();
		}
	}                                              
	 public void remove(MouseEvent Action) {
		 try {
			int Select = AddedMeals.getSelectionModel().getSelectedIndex();
			AddedMeals.getItems().remove(Select);
			updatedCarbs=0; 
			updatedCal=0;
			updatedProtin=0;
			for (Meal meal : AddedMeals.getItems()) {
				updatedCarbs = updatedCarbs+ meal.getCarbs();
				updatedCal = updatedCal +meal.getCal();
				updatedProtin = updatedProtin+ meal.getProtin();
			}
			cal.setText(updatedCal + "/" + String.valueOf(Main.saveCalories));
			if(updatedCal - NeedsCal < 10  && updatedCal>NeedsCal) {
				cal.setTextFill(Color.GREEN);
			}
			else {
				cal.setTextFill(Color.RED);
			}
			
			
			carbs.setText(updatedCarbs + "/" + String.valueOf(Main.saveCarbs));
			if(updatedCarbs - NeedsCarbs < 10  && updatedCarbs>NeedsCarbs ) {
				carbs.setTextFill(Color.GREEN);
			}
			else {
				carbs.setTextFill(Color.RED);
			}
			
			
			
			protin.setText(updatedProtin + "/" + String.valueOf(Main.saveProtin));
			if(updatedProtin - NeedsProtin < 10 && updatedProtin>NeedsProtin)  {
				protin.setTextFill(Color.GREEN);
			}
			else {
				protin.setTextFill(Color.RED);
			}
			
			
			}catch(IndexOutOfBoundsException e) {
				Alert aler = new Alert(AlertType.ERROR);
				aler.setHeaderText("no selected thing");
				aler.showAndWait();
			}
		}
	 
	 public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("nutritionMainPage.fxml"));
		    Scene scene = new Scene(root,700,620);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("SignUp");
		    primaryStage.show();
	 }
	
	
	


}
