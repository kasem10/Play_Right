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
	    private ListView<interestedjoin> joinfreindsview;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//joinfreindsview.getItems().addAll(Main.gym.getinterstedCustomers().values());
		joinfreindsview.getItems().addAll(Main.gym.getinterestedjoin().values());
	}
	
	 public void add(MouseEvent event) throws IOException{
		 
		 interestedjoin newcust = new interestedjoin(fullName.getText() , phone.getText() , location.getText());
		 checkid(newcust);
		 Main.gym.addinterestedjoin(newcust);
		 Main.update();
		 joinfreindsview.getItems().add(newcust);
	   
	    }
	 
	 public void checkid (interestedjoin c) {
			int x=0;
			for(int max : Main.gym.getinterestedjoin().keySet()) {
			if(max>x)
				x=max;
				
			}
			c.setId(x+1);
			return ;
		}
	 
	 public void back(ActionEvent event) throws IOException{
		 Stage primaryStage =  (Stage)((Node)event.getSource()).getScene().getWindow();
		    Parent root = FXMLLoader.load(getClass().getResource("CustomerMainPage.fxml"));
		    Scene scene = new Scene(root,800,466);
		    Image icon = new Image("/Images/icon.png");
		    primaryStage.getIcons().add(icon);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("SignUp");
		    primaryStage.show();
	 }

}
