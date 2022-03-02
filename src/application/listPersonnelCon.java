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

public class listPersonnelCon {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TableView<_STAFF> table;

    @FXML
    private TableColumn<_STAFF, String> listWeekDay;

    @FXML
    private TableColumn<_STAFF, String> listFloor;

    @FXML
    private Button back;

    @FXML
    private TableColumn<_STAFF, String> FIO;

    @FXML
    void initialize() {
    	
    	back.setOnAction(e->{
    		changeWindow("staticMenu.fxml");
    		
    	});
    	
    	
    	DB_Worker db = new DB_Worker();
    	
    	FIO.setCellValueFactory(new PropertyValueFactory<_STAFF, String>("FIO"));
    	listWeekDay.setCellValueFactory(new PropertyValueFactory<_STAFF, String>("floorList"));
    	listFloor.setCellValueFactory(new PropertyValueFactory<_STAFF, String>("dayList"));
    	
    		
    	ObservableList<_STAFF> list = db.getListSTAFF();
    	
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
