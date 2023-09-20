package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class weightLose4Controller implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		// TODO Auto-generated method stub
		
	}
	
	
public void goToexercises(ActionEvent event) throws IOException {
		
		
			Parent root = FXMLLoader.load(getClass().getResource("wieghtLose3DaysTrainig.fxml"));
			 Stage st = (Stage)((Node)event.getSource()).getScene().getWindow();
				Scene cn = new Scene(root);
				st.setScene(cn);
				st.show();
			
}

}
