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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class joinFreinds implements Initializable {
	
	
	 @FXML
	    private TextField fullName;

	    @FXML
	    private TextField phone;

	    @FXML
	    private TextField location;

	    @FXML
	    private ListView<InterstedCustomers> joinfreindsview;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println(Main.gym.getinterstedCustomers().values());
		joinfreindsview.getItems().addAll(Main.gym.getinterstedCustomers().values());	
	}
	
	 public void add(MouseEvent event) throws IOException{
		 
		 InterstedCustomers newcust = new InterstedCustomers(fullName.getText() , phone.getText() , location.getText());
		 Main.gym.addinterstedCustomers(newcust);
		 Main.update();
		 joinfreindsview.getItems().add(newcust);
	   
	    }

}
