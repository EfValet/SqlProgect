package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class queryMenuCon {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button priceInfo;

    @FXML
    private TextField townName;

    @FXML
    private TextField dayRoom;

    @FXML
    private TextField dayName;

    @FXML
    private TextField priceFloor;

    @FXML
    private Button back;

    @FXML
    private Button personnelInfo;

    @FXML
    private Button townInfo;

    @FXML
    private TextField priceRoom;

    @FXML
    void initialize() {
    	
    	priceInfo.setOnAction(e->{
    		Def.searchFloor = priceFloor.getText();
    		Def.searchRroom = priceRoom.getText();
    		changeWindow("priceInfo.fxml");
    	});
    	
    	townInfo.setOnAction(e->{
    		Def.searchTown = townName.getText();
    		changeWindow("townInfo.fxml");
    	});
    	
    	personnelInfo.setOnAction(e->{
    		Def.searchDay = dayName.getText();
    		Def.searchDayRoom = dayRoom.getText();
    		changeWindow("personalInfo.fxml");
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
