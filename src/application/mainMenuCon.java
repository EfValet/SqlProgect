package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class mainMenuCon {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button freeMenu;

    @FXML
    private Button staticMenu;

    @FXML
    private Button add;

    @FXML
    private Button queryMenu;

    @FXML
    void initialize() {
    	staticMenu.setOnAction(e->{
    		changeWindow("staticMenu.fxml");
    		
    	});
    	
    	freeMenu.setOnAction(e->{
    		changeWindow("freeMenu.fxml");
    		
    	});
    	
    	queryMenu.setOnAction(e->{
    		changeWindow("queryMenu.fxml");
    		
    	});
    	
    	add.setOnAction(e->{
    		changeWindow("addSTAFF.fxml");
    		
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
