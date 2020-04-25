import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {
	
	//instance variables
	private Player player;
	private File roomsFile;
	private File itemsFile;
	private File puzzlesFile;
	private File monstersFile;
	private ArrayList<Room> roomList = new ArrayList<>();
	private ArrayList<Item> availableItems = new ArrayList<>();
	private ArrayList<Monster> availableMonsters = new ArrayList<>();
	
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
	
	public void createGame() {
		
		Scanner itemScanner = null;
		Scanner puzzleScanner = null;
		Scanner monsterScanner = null;
		Scanner roomScanner = null;
		
		try {
			itemScanner = new Scanner(itemsFile);
			puzzleScanner = new Scanner(puzzlesFile);
			monsterScanner = new Scanner(monstersFile);
			roomScanner = new Scanner(roomsFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//skip first line before reading
		itemScanner.nextLine();
		puzzleScanner.nextLine();
		monsterScanner.nextLine();
		roomScanner.nextLine();
		
		while (itemScanner.hasNext()) {
			createItems(itemScanner.nextLine());
		}
		
		while (monsterScanner.hasNext()) {
			createMonsters(monsterScanner.nextLine());
		}
		
		while (roomScanner.hasNext()) {
			createRooms(roomScanner.nextLine());
		}
		
		while (puzzleScanner.hasNext()) {
			createPuzzles(puzzleScanner.nextLine());
		}
	}
	
	private void createItems(String itemString) {
		
		String[] itemInfo = itemString.split("~");
		
		if (itemInfo[0].equalsIgnoreCase("equip")) {
			int itemID = Integer.parseInt(itemInfo[1]);
			String itemName = itemInfo[2];
			String itemDescription = itemInfo[3];
			String pickupMessage = itemInfo[4];
			String useMessage = itemInfo[5];
			
			Equipable item = new Equipable(itemID, itemName, itemDescription, pickupMessage, useMessage);
			availableItems.add(item);
		}
		
		else if (itemInfo[0].equalsIgnoreCase("consume")) {
			int itemID = Integer.parseInt(itemInfo[1]);
			String itemName = itemInfo[2];
			String itemDescription = itemInfo[3];
			
			Consumable item = new Consumable(itemID, itemName, itemDescription, 1);
			availableItems.add(item);
		}	
	}
	
	private void createMonsters(String monsterString) {
		
		String[] monsterInfo = monsterString.split("~");
		
		int monsterID = Integer.parseInt(monsterInfo[0]);
		String monsterName = monsterInfo[1];
		String monsterDescription = monsterInfo[2];
		int monsterHealth = Integer.parseInt(monsterInfo[3]);
		int chance = Integer.parseInt(monsterInfo[4]);
		
		String[] oddsArray = monsterInfo[5].split(",");
		int[] odds = new int[oddsArray.length];
		for (int i = 0; i < oddsArray.length; i++) {
			odds[i] = Integer.parseInt(oddsArray[i]);
		}
		
		String[] itemArray = monsterInfo[6].split(",");
		int[] items = new int[itemArray.length];
		for (int i = 0; i < itemArray.length; i++) {
			items[i] = Integer.parseInt(itemArray[i]);
		}
		
		Monster monster = new Monster(monsterName, monsterHealth, monsterID, monsterDescription, chance, odds, items);
		
		availableMonsters.add(monster);
	}
	
	private void createRooms(String roomString) {
		String[] roomInfo = roomString.split("~");
		
		int roomID = Integer.parseInt(roomInfo[0]);
		String roomName = roomInfo[1];
		String roomDescription = roomInfo[2];
		String inspectMessage = roomInfo[3];
		
		String[] roomConnections = roomInfo[4].split(",");
		int[] connections = new int[4];
		
		for (int i = 0; i < 4; i++) {
			connections[i] = Integer.parseInt(roomConnections[i]);
		}
		
		ArrayList<Item> itemList = new ArrayList<>();
		String[] items = roomInfo[5].split(",");
		int check = Integer.parseInt(items[0]);
		
		if (check != 0) {
			for (String s: items) {
				itemList.add(searchItemByID(Integer.parseInt(s)));
			}
		}
		
		ArrayList<Monster> monsterList = new ArrayList<>();
		String[] monsters = roomInfo[6].split(",");
		check = Integer.parseInt(monsters[0]);
		
		if (check != 0) {
			for (String s: monsters) {
				monsterList.add(searchMonsterByID(Integer.parseInt(s)));
			}
		}
		
		Room room = new Room(roomID, roomName, roomDescription, inspectMessage, connections, itemList, monsterList, false);
		
		roomList.add(room);
	}
	
	private void createPuzzles(String puzzleString) {
		
		String[] puzzleInfo = puzzleString.split("~");
		
		int puzzleID = Integer.parseInt(puzzleInfo[0]);
		String puzzleDescription = puzzleInfo[1];
		String answer = puzzleInfo[2];
		String hint = puzzleInfo[3];
		int attempts = Integer.parseInt(puzzleInfo[4]);
		String fail = puzzleInfo[5];
		String success = puzzleInfo[6];
		int location = Integer.parseInt(puzzleInfo[7]);
		
		Puzzle puzzle = new Puzzle(puzzleID, puzzleDescription, answer, hint, attempts, fail, success, location);
		
		Room room = searchRoomByID(location);
		room.setPuzzle(puzzle);
	}
	
	private Room searchRoomByID(int roomID) {
		Room room = null;
		
		for (int i = 0; i < roomList.size(); i++) {
			if (roomID == roomList.get(i).getRoomID()) {
				room = roomList.get(i);
			}
		}
		
		return room;
	}
	
	private Item searchItemByID(int itemID) {
		Item item = null;
		
		for (int i = 0; i < availableItems.size(); i++) {
			if (itemID == availableItems.get(i).getItemID()) {
				item = availableItems.get(i);
			}
		}
		
		return item;
	}
	
	private Monster searchMonsterByID(int monsterID) {
		Monster monster = null;
		
		for (int i = 0; i < availableMonsters.size(); i++) {
			if (monsterID == availableMonsters.get(i).getMonsterID()) {
				monster = availableMonsters.get(i);
			}
		}
		
		return monster;
	}

}

