package git.olafgoud;

import git.olafgoud.file.ReplaceFiles;

public class Main {
	private String[] vehicleList = {"vortex", "winkelkar", "waterscooter", "vliegtuig", "vlot", "urus", "wing", "ufo", "tank", "tracktor", "symbolica", "gyrados", "slee",  "range", "roadroller", "plane", "quad", "raket",  "phantom", "naboo", "fort_mustang", "hotrod_muel", "muel", "monstertruck", "mirage", "master", "mijnkarretje", "macati", "khamori", "lamboo", "lambo", "liam_car", "limo", "kart", "master_clasic", "hcraft", "cruiser", "dirtbike", "corvette", "canary_clasic", "cannary", "bus","bucket", "bollar", "ferari_255", "ferari_250"};


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("start");
		ReplaceFiles.replaceFile("canary");
	}

}
