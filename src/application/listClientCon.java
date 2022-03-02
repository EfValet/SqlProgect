package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class listClientCon {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TableView<_CLIENT> table;

    @FXML
    private TableColumn<_CLIENT, String> date;

    @FXML
    private TableColumn<_CLIENT, String> number;

    @FXML
    private TableColumn<_CLIENT, String> town;

    @FXML
    private Button back;

    @FXML
    private TableColumn<_CLIENT, String> numberPassport;

    @FXML
    private TableColumn<_CLIENT, String> place;

    @FXML
    private TableColumn<_CLIENT, String> countDays;

    @FXML
    private TableColumn<_CLIENT, String> FIO;

    @FXML
    void initialize() {

    	back.setOnAction(e->{
    		changeWindow("staticMenu.fxml");
    		
    	});    	
    	DB_Worker db = new DB_Worker();
    	
    	FIO.setCellValueFactory(new PropertyValueFactory<_CLIENT, String>("FIO"));
    	numberPassport.setCellValueFactory(new PropertyValueFactory<_CLIENT, String>("passport"));
    	town.setCellValueFactory(new PropertyValueFactory<_CLIENT, String>("whereFrom"));
    	number.setCellValueFactory(new PropertyValueFactory<_CLIENT, String>("room"));
    	place.setCellValueFactory(new PropertyValueFactory<_CLIENT, String>("place"));
    	date.setCellValueFactory(new PropertyValueFactory<_CLIENT, String>("date"));
    	countDays.setCellValueFactory(new PropertyValueFactory<_CLIENT, String>("countDays"));
    		
    	ObservableList<_CLIENT> list = db.getListClient();
    	
    	table.setItems(list);
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