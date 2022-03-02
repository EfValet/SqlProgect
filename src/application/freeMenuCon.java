package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class freeMenuCon {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button listFreeRoom;

    @FXML
    private Button back;

    @FXML
    private Button infoMoney;

    @FXML
    private Button listSoloClient;

    @FXML
    void initialize() {
    	
    	listFreeRoom.setOnAction(e->{
    		changeWindow("textFreeRoom.fxml");
    		
    	});
    	
    	listSoloClient.setOnAction(e->{
    		changeWindow("listSoloClient.fxml");
    		
    	});
    	
    	infoMoney.setOnAction(e->{
    		changeWindow("infoMoney.fxml");
    		
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
