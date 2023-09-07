package application;

import java.io.IOException;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

public class AddMeal  {
	

	@FXML
	TextField  name , cal , carbs, protin;
	
	
	public void submitaddcomp (ActionEvent event) throws IOException {
		String cals = cal.getText();
		double cal =  Double.parseDouble(cals);
		String carbs1 = carbs.getText();
		double carb =  Double.parseDouble(carbs1);
		String protin1 = protin.getText();
		double protin2 =  Double.parseDouble(protin1);

		
				
		Meal meal = new Meal(name.getText(),cal,carb,protin2);
		
		
		checkcompid(meal);
		if(Main.gym.addnewmeal(meal)) {
			Main.update();
			Alert aler = new Alert(AlertType.CONFIRMATION);
			aler.setHeaderText("seccessfully add");
			aler.showAndWait();	
			
				}
			
		}
    
      

	public void checkcompid(Meal comp) {
		int x=0;
		for(int c : Main.gym.getMeals().keySet()) {
			if(c>x)
				x=c;
		}
		comp.setId(x+1);
		return;
	}
	
	 public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("ManageMeals.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("SignUp");
		    primaryStage.show();
	 }
	
	

	

}
