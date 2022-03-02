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

public class townInfoCon {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TableView<_CLIENT_TOWN> table;

    @FXML
    private TableColumn<_CLIENT_TOWN, String> town;

    @FXML
    private Button back;

    @FXML
    private TableColumn<_CLIENT_TOWN, String> FIO;

    @FXML
    void initialize() {
    	back.setOnAction(e->{
    		changeWindow("queryMenu.fxml");
    	});
    	
    	DB_Worker db = new DB_Worker();
    	
    	FIO.setCellValueFactory(new PropertyValueFactory<_CLIENT_TOWN, String>("FIO"));
    	town.setCellValueFactory(new PropertyValueFactory<_CLIENT_TOWN, String>("town"));
    	
    	ObservableList<_CLIENT_TOWN> list = db.getListClientTown();
    	
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
