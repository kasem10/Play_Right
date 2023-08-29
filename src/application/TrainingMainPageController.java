package application;

import java.io.IOException;
import javafx.scene.effect.DropShadow;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TrainingMainPageController implements Initializable {
	
	 // set combobox in the genders
 
	
	
	
	 @FXML
	    private ComboBox<String> BudyGoal;
	 @FXML
	    private ComboBox<String> howManyDays;
	
	
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ObservableList<String> list = FXCollections.observableArrayList("Muscle Strengthening","Muscle Building","Muscle Toning","Weight Loss");
		BudyGoal.setItems(list);
		ObservableList<String> list2 = FXCollections.observableArrayList("3 Days","4 Days","5 Days");
		howManyDays.setItems(list2);
	   
	}
	
	
	public void goToPlan(ActionEvent event) throws IOException {
		
		if(BudyGoal.getValue() == "Weight Loss" && howManyDays.getValue() == "3 Days") {
			Parent root = FXMLLoader.load(getClass().getResource("wieghtLose3Days.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
			
		}
		
		
		
		
	}
	}
	
	
	
	


