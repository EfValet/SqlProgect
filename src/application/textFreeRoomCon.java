package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class textFreeRoomCon {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label textFreeRoom;

    @FXML
    private Button back;

    @FXML
    void initialize() {
    	back.setOnAction(e->{
    		changeWindow("freeMenu.fxml");
    		
    	});
    	
    	DB_Worker db = new DB_Worker();
    	
    	textFreeRoom.setText(db.getInfoForFreeRoom());
    	
    }
    
public void changeWindow(String url) {
		
    	Parent root = new Parent() {};
        FXMLLoader loader = new FXMLLoader();
        	
        loader.setLocation(getClass().getResource(url));
        	
       try 
        {
    	   loader.load();
    	} catch (IOException e1) {
    		e1.printStackTrace();
    	}
        	
        root = loader.getRoot();
        
        Def.PrevWindow =Def.mainScene.getRoot();
        Def.mainScene.setRoot(root);
	}
}
