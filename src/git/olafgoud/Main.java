package git.olafgoud;

import java.io.File;

import git.olafgoud.file.ReplaceFiles;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class Main extends Application{
	private String[] vehicleList = {"canary_nbt"};
	private File folder = null;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start");
		
		launch(args);
		
		
		
		
		//ReplaceFiles.replaceFile("canary");
	}


	@Override
	public void start(Stage stage) throws Exception {
		FlowPane root = new FlowPane(10, 10);
		root.setPadding(new Insets(10));
		Button btn1 = new Button("open");
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				DirectoryChooser  fileChooser = new DirectoryChooser();
				
				fileChooser.setTitle("Open A Folder");
				File selectedFolder = fileChooser.showDialog(stage);
				folder = selectedFolder;
			}
			
		});
		
		Button btn2 = new Button("work");

		btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if (folder != null) {
				
					ReplaceFiles.replaceFile(folder, "canary");
				}
				
				
			}
			
		});
		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(btn1, btn2);
		root.getChildren().add(hbox);
		
		
		
		Scene scene = new Scene(root, 100, 100);
		
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
		stage.setTitle("Choose a folder");
		
	}

}
