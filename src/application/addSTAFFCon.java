package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class addSTAFFCon {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button add;

    @FXML
    private TextField firstName;

    @FXML
    private TextField floorList;

    @FXML
    private TextField dayList;

    @FXML
    private TextField threeName;

    @FXML
    private Button back;

    @FXML
    private TextField secondName;

    @FXML
    void initialize() {
    	
    	DB_Worker db = new DB_Worker();
    	
    	back.setOnAction(e->{
    		changeWindow("mainMenu.fxml");
    		
    	});
    	
    	add.setOnAction(e->{
    		db.addSTAFF(firstName.getText(), secondName.getText(), threeName.getText(), floorList.getText(), dayList.getText());
    		
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