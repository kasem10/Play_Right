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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

public class data2  implements Initializable  {
	
	
	@FXML
    private BarChart<String,Integer> barchart;
	@FXML
    private Button backs;
	

    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	if(Main.savelangmanager.equals("English")) {
			
            backs.setText("back");
           	
   		}
   		 if(Main.savelangmanager.equals("Hebrew")) {
   		
   			 backs.setText("חזור");
   
   		}
    	 barchart.getData().clear();

    	 int under20 = 0;
         int between20and40 = 0;
         int above40=0;

         // Categorize the data
         for (Customer cust: Main.gym.getCustomers().values()) {
           
             double age = cust.saveAge;

             if (age < 20) {
            	 under20++;
             } else if (age >= 20 && age <= 40) {
            	 between20and40++;
             } else {
            	 above40++;
             }
         }

         // Add series to the bar chart
         // Create a series for the bar chart
         XYChart.Series<String, Integer> series = new XYChart.Series<>();
         series.getData().add(new XYChart.Data<>("<20", under20));
         series.getData().add(new XYChart.Data<>("20-40", between20and40));
         series.getData().add(new XYChart.Data<>("40+", above40));

         // Add the series to the bar chart
         barchart.getData().add(series);
     
		
	}
	
	
	
	
	 public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("reports.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.show();
	 }




	
	

	

}
