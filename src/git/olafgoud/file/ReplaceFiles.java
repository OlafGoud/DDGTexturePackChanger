package git.olafgoud.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class ReplaceFiles {
	private static ArrayList<String> addonList;
	public static void replaceFile(File dirctory, String vehicleName, ArrayList<String> listOffAddons) {
		File[] folderList = getFiles(dirctory.getAbsolutePath());
		addonList = listOffAddons;
		for(File file : folderList) {
			String fileName = file.getName();
			if (!fileName.startsWith(vehicleName)) continue;
			
			fileName = fileName.replace(vehicleName + "_", "");
			fileName = fileName.replace(".properties", "");
			if (checkForAddon(fileName) == false) continue;
			String activeAddon = "";
			for (String addon : addonList) {
				if (fileName.startsWith(addon)) {
					activeAddon = addon;
					
				}
			}
			fileName = fileName.replace(activeAddon + "_", "");
			for (File file1 : folderList) {
				String fileName1 = file1.getName().replace(".properties", "");
				if (!fileName1.startsWith((vehicleName + "_" + activeAddon))) continue;
				if (fileName1.equals(vehicleName + "_" + activeAddon + "_" + "gray")) {
					fileHandler(file, vehicleName + "_" + activeAddon + "_" + "gray");
					if(!(file.getName().replace(".properties", "")).equals(vehicleName + "_" + activeAddon + "_" + "gray")) {
						fileDeleter(dirctory.getAbsolutePath() + "\\" + file.getName().replace(".properties", ".png"));
						fileDeleter(dirctory.getAbsolutePath() + "\\" + file.getName().replace(".properties", ".json"));
					}
					break;
				}
				if (fileName1.equals(vehicleName + "_" + activeAddon + "_" + "normal")) {
					fileHandler(file, vehicleName + "_" + activeAddon + "_" + "normal");
					if(!(file.getName().replace(".properties", "")).equals(vehicleName + "_" + activeAddon + "_" + "normal")) {
						fileDeleter(dirctory.getAbsolutePath() + "\\" + file.getName().replace(".properties", ".png"));
						fileDeleter(dirctory.getAbsolutePath() + "\\" + file.getName().replace(".properties", ".json"));
					}
					break;
				}
				if (fileName1.replaceAll(" ", "").equals(vehicleName + "_" + activeAddon)) {
					fileHandler(file, vehicleName + "_" + activeAddon);
					if(!(file.getName().replace(".properties", "")).equals(vehicleName + "_" + activeAddon)) {
						fileDeleter(dirctory.getAbsolutePath() + "\\" + file.getName().replace(".properties", ".png"));
						fileDeleter(dirctory.getAbsolutePath() + "\\" + file.getName().replace(".properties", ".json"));
					}
					break;
				}
			}
			
		}
	}
	
	
	public static boolean checkForAddon(String fileName) {
		for (String addon : addonList) {
			if (fileName.startsWith(addon + "_")) {
				return true;
			}
		}
		return false;
		
	}
	
	
	public static File[] getFiles(String folderName) {
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.toLowerCase().endsWith(".properties");
			}
		};
		File folder = new File(folderName);
		File[] folderList = folder.listFiles(filter);
		return folderList;
	}
	
	
	public static void fileHandler(File file, String value) {
		Properties propFile = new Properties();
		try {
			propFile.load(new FileInputStream(file));
			propFile.setProperty("model", value);
			propFile.store(new FileWriter(file), "store to properties file");

		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void fileDeleter(String file) {
	    File deleteFile = new File(file); 
	    if (deleteFile.delete()) { 
	    	System.out.println("file:" + deleteFile);
	    } else {
	      System.out.println("Failed to delete the file.");
	    } 

		
		
	}
}
