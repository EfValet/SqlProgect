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
        
		//���� ��� �������� �� FXML �����
		AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("startWindow.fxml"));
		
		//��������� ����� ���������� �����������
		Scene scene = new Scene(root,800,600);
		//���������� �����
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		//��������� ����������� �����
		Def.mainScene = scene;
		//���� ��� ���������� ��� ����������
		primaryStage.setScene(scene);
		//���� ��� ��������
		primaryStage.setTitle("��������� �������");
		//������������� ����
		primaryStage.show();
		//stage	
			
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
