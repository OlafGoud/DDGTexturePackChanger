package git.olafgoud.setup;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SetUpDirectory {
	private static String[] addonList = {"spoiler", "tires", "license_front","license_back", "frontwindow", "frontlights", "front_sportief", "frame", "front_bumper", "engine", "bodykit_back", "backbumper", "back_hotrod", "bodykit_front", "bodykit_offroad", "body"};

	public static void setDirectory() {
		String place = "C:\\Users\\" + System.getProperty("user.name") + "\\TexturePackChanger\\configfiles";
		
		
		File file = new File(place);
		
		file.mkdirs();
		file = new File("C:\\Users\\" + System.getProperty("user.name") + "\\TexturePackChanger\\configfiles\\canary_nbt.txt");
		if(file.exists()) return;
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		file.setWritable(true);
		try {
			FileWriter writer = new FileWriter(place + "\\canary_nbt.txt");
			for (String addon : addonList) {
				writer.write(addon + "\n");
				
			}
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
