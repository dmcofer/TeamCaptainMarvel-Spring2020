import java.io.File;

public class Map {
	
	//instance variables
	private Player player;
	private File roomsFile;
	private File itemsFile;
	private File puzzlesFile;
	private File monstersFile;
	
	//Constructor
	public Map(Player player, File roomsFile, File itemsFile, File puzzlesFile, File monstersFile) {
		super();
		this.player = player;
		this.roomsFile = roomsFile;
		this.itemsFile = itemsFile;
		this.puzzlesFile = puzzlesFile;
		this.monstersFile = monstersFile;
	}

	//getter and setter methods
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public File getRoomsFile() {
		return roomsFile;
	}

	public void setRoomsFile(File roomsFile) {
		this.roomsFile = roomsFile;
	}

	public File getItemsFile() {
		return itemsFile;
	}

	public void setItemsFile(File itemsFile) {
		this.itemsFile = itemsFile;
	}

	public File getPuzzlesFile() {
		return puzzlesFile;
	}

	public void setPuzzlesFile(File puzzlesFile) {
		this.puzzlesFile = puzzlesFile;
	}

	public File getMonstersFile() {
		return monstersFile;
	}

	public void setMonstersFile(File monstersFile) {
		this.monstersFile = monstersFile;
	}
	
	
	

}
