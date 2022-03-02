package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class startWindowCon {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exit;

    @FXML
    private PasswordField pass;

    @FXML
    private TextField login;

    @FXML
    void entry(ActionEvent event) {
        
    	String log = "";
		String pas = "";
		//Сравниваем введенный текст с логином и паролем
		if((log.equals(login.getText())) && (pas.equals(pass.getText())))  {
		
			//Если прошёл проверку, переходит к следующему окну
		Parent root = new Parent() {};
    	FXMLLoader loader = new FXMLLoader();
    	
    	loader.setLocation(getClass().getResource("mainMenu.fxml"));
    	
    	try 
    {
		loader.load();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
    	
    root = loader.getRoot();
    //сохраняем стандартную сцену
    Def.mainScene.setRoot(root);
	}
    }

    @FXML
    void initialize() {
    }
}
