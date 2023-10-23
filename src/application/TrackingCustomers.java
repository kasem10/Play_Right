package application;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TrackingCustomers implements Initializable {
	
	@FXML
	private ListView<Customer> customers;
	
	 @FXML
	    private TextField search;
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//customers.setStyle("-fx-control-inner-background: lightgray;");
		customers.setStyle("-fx-control-inner-background: lightgray; -fx-font-size: 14; -fx-font-weight: bold; -fx-font-style: italic; ");
		
		customers.getItems().addAll(Main.gym.getCustomers().values());
		
		search.textProperty().addListener((observable, oldValue, newValue) -> {
	        filterCustomers(newValue);
	    });
		
	}
	private void filterCustomers(String keyword) {
	    Collection<Customer> allCustomers = Main.gym.getCustomers().values();
	    
	    // Convert the collection to an ObservableList
	    ObservableList<Customer> customerList = FXCollections.observableArrayList(allCustomers);

	    // Create a filtered list based on the keyword
	    ObservableList<Customer> filteredCustomers = customerList.filtered(customer -> {
	        // You can use different conditions to filter by customer name, e.g., using contains() for a case-insensitive search
	        return customer.getFirstName().toLowerCase().contains(keyword.toLowerCase());
	    });

	    // Update the ListView to show the filtered results
	    customers.setItems(filteredCustomers);
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
