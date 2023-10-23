package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class ManageMeals implements Initializable {
	
	@FXML
	private ListView<Meal> meals;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//meals.setStyle("-fx-control-inner-background: lightgray;");
		meals.setStyle("-fx-control-inner-background: lightgray; -fx-font-size: 14; -fx-font-weight: bold; -fx-font-style: italic; ");
		
		meals.getItems().addAll(Main.gym.getMeals().values());
		// TODO Auto-generated method stub
		
	}
	
	 public void AddMeal(ActionEvent event) throws IOException{
		   
		 Parent root = FXMLLoader.load(getClass().getResource("addMeal.fxml"));
		 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
			Scene cn = new Scene(root);
			st.setScene(cn);
			st.show();
			
	}
	 
	 
	 public void removemeal(ActionEvent event) throws IOException{
		 
		 
		 
		 int Select = meals.getSelectionModel().getSelectedIndex();
		 if(Main.gym.removemeal((Meal)meals.getItems().get(Select))) {
		    meals.getItems().remove(Select);
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
		    primaryStage.setTitle("manager");
		    primaryStage.show();
	 }

}
