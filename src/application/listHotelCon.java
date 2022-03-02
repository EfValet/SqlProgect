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

public class listHotelCon {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TableView<_ROOM> table;


    @FXML
    private TableColumn<_ROOM, String> number;

    @FXML
    private TableColumn<_ROOM, String> listStaff;

    @FXML
    private TableColumn<_ROOM, String> listClient;

    @FXML
    private Button back;

    @FXML
    private TableColumn<_ROOM, Integer> priceDay;

    @FXML
    private TableColumn<_ROOM, String> floor;

    @FXML
    private TableColumn<_ROOM, String> roomType;

    @FXML
    void initialize() {

    	back.setOnAction(e->{
    		changeWindow("staticMenu.fxml");
    		
    	});
    	
    	DB_Worker db = new DB_Worker();
    	
    	number.setCellValueFactory(new PropertyValueFactory<_ROOM, String>("room"));
    	floor.setCellValueFactory(new PropertyValueFactory<_ROOM, String>("floor"));
    	roomType.setCellValueFactory(new PropertyValueFactory<_ROOM, String>("roomType"));
    	priceDay.setCellValueFactory(new PropertyValueFactory<_ROOM, Integer>("priceDay"));
    	listClient.setCellValueFactory(new PropertyValueFactory<_ROOM, String>("clientList"));
    	listStaff.setCellValueFactory(new PropertyValueFactory<_ROOM, String>("personalList"));
    		
    	ObservableList<_ROOM> list = db.getListRoom();
    	
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
