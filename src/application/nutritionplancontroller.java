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
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class nutritionplancontroller  implements Initializable {
	
	@FXML
    private ListView<Meal> meals;

    @FXML
    private ListView<Meal> AddedMeals;
	

	public void initialize(URL location, ResourceBundle resources) { // set the comps and dishtype to the list and comboBox
	
		meals.getItems().addAll(Main.gym.getMeals().values());
	    
	}
	
	public void addact(MouseEvent Action) {
		try {
		int Select = meals.getSelectionModel().getSelectedIndex();
		AddedMeals.getItems().add(meals.getItems().get(Select));
		}catch(IndexOutOfBoundsException e) {
			Alert aler = new Alert(AlertType.ERROR);
			aler.setHeaderText("no selected thing");
			aler.showAndWait();
		}
	}                                              // choose the comps that we need to create new dish
	 public void remove(MouseEvent Action) {
		 try {
			int Select = AddedMeals.getSelectionModel().getSelectedIndex();
			
			AddedMeals.getItems().remove(Select);
			}catch(IndexOutOfBoundsException e) {
				Alert aler = new Alert(AlertType.ERROR);
				aler.setHeaderText("no selected thing");
				aler.showAndWait();
			}
		}
	
	
	


}
