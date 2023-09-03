package application;

import java.io.IOException;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ManagerMainPageController implements Initializable {
	
	   public void AddMeals(ActionEvent event) throws IOException{
			 Parent root = FXMLLoader.load(getClass().getResource("AddMeal.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
		}
	   public void Addexercise(ActionEvent event) throws IOException{
			 Parent root = FXMLLoader.load(getClass().getResource("TrainingMainPage.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
		}
	   
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	     
	}
	

}