package git.olafgoud;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import git.olafgoud.file.ReplaceFiles;
import git.olafgoud.setup.SetUpDirectory;
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
		SetUpDirectory.setDirectory();
		
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
				DirectoryChooser fileChooser = new DirectoryChooser();
				
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
					for (String voertuig : vehicleList) {
						if (voertuig.equals(folder.getName())) {
							String voertuigNaam = folder.getName();
							try {
								ArrayList<String> listOffAddons = getListOffAddons(voertuigNaam);
								if (voertuigNaam.endsWith("_nbt")) voertuigNaam = voertuigNaam.replace("_nbt", "");
								ReplaceFiles.replaceFile(folder, voertuigNaam, listOffAddons);
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					}
				}
			}
			
		});
		HBox hbox = new HBox(10);
		hbox.getChildren().addAll(btn1, btn2);
		root.getChildren().add(hbox);
		
		
		
		Scene scene = new Scene(root, 500, 300);
		
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
		stage.setTitle("Choose a folder");
		
	}
	
	private ArrayList<String> getListOffAddons(String fileName) throws FileNotFoundException {
		File file = new File("C:\\Users\\" + System.getProperty("user.name") + "\\TexturePackChanger\\configfiles\\" + fileName + ".txt");
		ArrayList<String> list = new ArrayList<>();
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			list.add(scanner.nextLine());
		}
		
		
		
		
		return list;
		
	}
	
	
	
	
}
