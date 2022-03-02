package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
        
		//окну даём параметр из FXML файлы
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("startWindow.fxml"));
		
		//наполняем сцену созданными параметрами
		Scene scene = new Scene(root,800,600);
		//подключаем стили
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//сохраняем стандартную сцену
		Def.mainScene = scene;
		//Окну даём информацию для наполнения
		primaryStage.setScene(scene);
		//Окну даём название
		primaryStage.setTitle("Гостиница Свобода");
		//визуализируем окно
		primaryStage.show();
		//stage	
			
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
