package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class staticMenuCon {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button listHotel;

    @FXML
    private Button listPersonnel;

    @FXML
    private Button listClient;

    @FXML
    private Button back;

    @FXML
    void initialize() {
    	
    	
    	listHotel.setOnAction(e->{
    		changeWindow("listHotel.fxml");
    		
    	});
    	
    	listPersonnel.setOnAction(e->{
    		changeWindow("listPersonnel.fxml");
    		
    	});
    	
    	listClient.setOnAction(e->{
    		changeWindow("listClient.fxml");
    		
    	});
    	
    	back.setOnAction(e->{
    		changeWindow("mainMenu.fxml");
    		
    	});
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
