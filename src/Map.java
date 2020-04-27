import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Map implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//instance variables
	private Player player;
	private File roomsFile;
	private File itemsFile;
	private File puzzlesFile;
	private File monstersFile;
	private File endingsFile;
	private ArrayList<Room> roomList = new ArrayList<>();
	private ArrayList<Item> availableItems = new ArrayList<>();
	private ArrayList<Monster> availableMonsters = new ArrayList<>();
	//Constructor
	public Map(Player player, File roomsFile, File itemsFile, File puzzlesFile, File monstersFile, File endingsFile) {

		this.player = player;
		this.roomsFile = roomsFile;
		this.itemsFile = itemsFile;
		this.puzzlesFile = puzzlesFile;
		this.monstersFile = monstersFile;
		this.endingsFile = endingsFile;
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
	
	public ArrayList<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(ArrayList<Room> roomList) {
		this.roomList = roomList;
	}

	public ArrayList<Item> getAvailableItems() {
		return availableItems;
	}

	public void setAvailableItems(ArrayList<Item> availableItems) {
		this.availableItems = availableItems;
	}

	public ArrayList<Monster> getAvailableMonsters() {
		return availableMonsters;
	}

	public void setAvailableMonsters(ArrayList<Monster> availableMonsters) {
		this.availableMonsters = availableMonsters;
	}


	public void createGame() {

		Scanner itemScanner = null;
		Scanner puzzleScanner = null;
		Scanner monsterScanner = null;
		Scanner roomScanner = null;
		Scanner endingScanner = null;

		try {
			itemScanner = new Scanner(itemsFile);
			puzzleScanner = new Scanner(puzzlesFile);
			monsterScanner = new Scanner(monstersFile);
			roomScanner = new Scanner(roomsFile);
			endingScanner = new Scanner(endingsFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		//skip first line before reading
		itemScanner.nextLine();
		puzzleScanner.nextLine();
		monsterScanner.nextLine();
		roomScanner.nextLine();
		endingScanner.nextLine();

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
		
		while (endingScanner.hasNext()) {
			createEndings(endingScanner.nextLine());
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
		String[] roomDescription = roomInfo[2].split("#");
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
		
		String[] specialCommand = roomInfo[7].split(",");

		Room room = new Room(roomID, roomName, roomDescription, inspectMessage, connections, itemList, monsterList, false, specialCommand);

		roomList.add(room);
	}

	private void createPuzzles(String puzzleString) {

		String[] puzzleInfo = puzzleString.split("~");

		int puzzleID = Integer.parseInt(puzzleInfo[0]);
		String[] puzzleDescription = puzzleInfo[1].split("#");
		String[] answer = puzzleInfo[2].split(",");
		String hint = puzzleInfo[3];
		int attempts = Integer.parseInt(puzzleInfo[4]);
		String fail = puzzleInfo[5];
		String success = puzzleInfo[6];
		int location = Integer.parseInt(puzzleInfo[7]);

		Puzzle puzzle = new Puzzle(puzzleID, puzzleDescription, answer, hint, attempts, fail, success, location, false);

		Room room = searchRoomByID(location);
		room.setPuzzle(puzzle);
	}
	
	private void createEndings(String endingString) {
		
		String[] endingInfo = endingString.split("~");
		
		int endingID = Integer.parseInt(endingInfo[0]);
		String[] endingDescription = endingInfo[1].split("#");
		String endingPrompt = endingInfo[2];
		String endingCommand = endingInfo[3];
		String nonEnding = endingInfo[4];
		boolean puzzleConnection = Boolean.parseBoolean(endingInfo[5]);
		boolean multipleEnds = Boolean.parseBoolean(endingInfo[6]);
		boolean monsterConnection = Boolean.parseBoolean(endingInfo[7]);
		int roomID = Integer.parseInt(endingInfo[8]);
		
		Ending e = new Ending(endingID, endingDescription, endingPrompt, endingCommand, nonEnding, puzzleConnection, multipleEnds, monsterConnection);
		Room room = searchRoomByID(roomID);
		room.setEnding(e);
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

	public boolean isADirection(String command){
		if(command.equalsIgnoreCase("n") ||
				command.equalsIgnoreCase("s") ||
				command.equalsIgnoreCase("e") ||
				command.equalsIgnoreCase("w") ||
				command.equalsIgnoreCase("north") ||
				command.equalsIgnoreCase("south") ||
				command.equalsIgnoreCase("east") ||
				command.equalsIgnoreCase("west"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void move(String direction) {
		Room room = searchRoomByID(player.getCurrentRoomID());
		room.setVisited(true);
		int newRoomID = room.canIMove(direction);
		if(newRoomID == -1)
		{
			room.notValidInput();
		}
		else if (newRoomID == 0)
		{
			System.out.println("You cannot move in this direction. There is not a room.");
		}
		else
		{
			this.player.setCurrentRoomID(newRoomID);
		}
	}
	
	public void move(Room room) {
		
		int newRoomID = Integer.parseInt(room.getSpecialCommand()[1]);
		System.out.println(room.getSpecialCommand()[2]);
		
		this.player.setCurrentRoomID(newRoomID);
	}

	public void exit() {
		System.out.println("Thank You for playing Rabloons. Have a Great Day!" );
		System.exit(0);
	}

	public void play() {
		Room room = searchRoomByID(player.getCurrentRoomID());
		Scanner in = new Scanner(System.in);
		
		if (room.getEnding() != null && room.getEnding().isConnectedToMonsters() && room.getMonsters().isEmpty())
		{
			String[] ending = room.getEnding().getEndingDescription();
			for (String s: ending)
				System.out.println(s);
			exit();
		}
		
		if (room.getEnding() != null && room.getEnding().isConnectedToPuzzle() && room.getPuzzle().getAttempts() == 0) {
			String[] ending = room.getEnding().getEndingDescription();
			for (String s: ending)
				System.out.println(s);
			exit();
		}
		
		if (room.isVisited() == true)
		{
			System.out.println(player.getEntityName() + " is in the " + room.getRoomName() + " room.");
			System.out.println("Movement: north, east, south, west (shorthand: n, e, s, w)");
			System.out.println("What would you like to do?");
		}
		else
		{
			System.out.println(player.getEntityName() + " is in the " + room.getRoomName() + " room.");
			System.out.println();
			String[] description = room.getRoomDescription();
			for (String s: description)
			{
				System.out.println(s);
			}
			System.out.println("Movement: north, east, south, west (shorthand: n, e, s, w)");
			System.out.println("What would you like to do?");
		}
		
		if (!room.getMonsters().isEmpty())
		{
			System.out.print("Monsters in this room:");
			for (int i = 0; i < room.getMonsters().size(); i++)
			{
				System.out.print(" " + room.getMonsters().get(i).getEntityName());
			}
			System.out.println();
		}
		if (room.getPuzzle() != null && !room.getPuzzle().isSolved())
		{
			System.out.println("There is a puzzle in this room. Type \"attempt puzzle\" to solve.");
		}
		
		if (room.getEnding() != null)
		{
			System.out.println("You have found a possible ending. Do you wish to continue? (Yes or No)");
			String choice = in.nextLine();
			
			while (!(choice.equalsIgnoreCase("yes") ^ choice.equalsIgnoreCase("no")))
			{
				System.out.println("Must choose whether to continue with this ending. (Yes or N0)");
				choice = in.nextLine();
			}
			
			if (room.getEnding().isHasMultipleOutcomes() && choice.equalsIgnoreCase("yes"))
			{
				room.getEnding().showMultipleEnding(in);
			}
			
			else if (choice.equalsIgnoreCase("yes"))
				room.getEnding().showEnding(in);
				
		}
		
		String[] consoleText = in.nextLine().split(" ");
		String command = consoleText[0];

		if(consoleText.length == 1)
		{
			if(isADirection(command))
			{
				move(command);
				play();
			}
			else if(command.equalsIgnoreCase("attack"))
			{
				player.attack(room, in);
				play();
			}
			else if(command.equalsIgnoreCase("inspect"))
			{
				System.out.println(room.getInspectMessage());
				play();
			}
			else if(command.equalsIgnoreCase("exit"))
			{
				exit();
			}
			else
			{
				System.out.println("That was not a valid command");
				play();
			}
		}
		else if(consoleText.length == 2)
		{
			String input = consoleText[1];
			if(command.equalsIgnoreCase("search") && input.equalsIgnoreCase("room"))
			{
				player.search(room);
				play();
			}
			else if(command.equalsIgnoreCase("check") && input.equalsIgnoreCase("inventory"))
			{
				player.inventory();
				play();
			}
			else if(command.equalsIgnoreCase("pickup"))
			{
				if(room.getItemInventory().isEmpty())
				{
					System.out.println("This room does not have any items!");
					play();
				}
				else
				{
					player.pickupItem(input, room);
					play();
				}
			}
			else if(command.equalsIgnoreCase("drop"))
			{
				if(player.getInventory().isEmpty())
				{
					System.out.println(player.getEntityName() + " does not have any items!");
					play();
				}
				else
				{
					player.dropItem(input, room);
					play();
				}
			}
			else if(command.equalsIgnoreCase("inspect"))
			{
				if(player.getInventory().isEmpty() && room.getItemInventory().isEmpty())
				{
					System.out.println("There are no items available to inspect!");
					play();
				}
				else
				{
					player.inspect(input, room);
					play();
				}
			}
			else if(command.equalsIgnoreCase("consume"))
			{
				if(player.getInventory().isEmpty())
				{
					System.out.println("There are no items in your inventory!");
					play();
				}
				else if(player.itemAvailable(input))
				{
					player.consumeItem(input);
					play();
				}
				else
				{
					System.out.println(input + " is not in your inventory!");
					play();
				}
			}
			else if(command.equalsIgnoreCase("use") && room.getSpecialCommand()[0].equalsIgnoreCase(" "))
			{
				player.useItem(input);
				play();
			}
			else if(command.equalsIgnoreCase("use") && !room.getSpecialCommand()[0].equalsIgnoreCase(" "))
			{
				String[] s = room.getSpecialCommand()[0].split(" ");
				if (s[1].equalsIgnoreCase(input))
				{
					move(room);
					play();
				}
				else
				{
					player.useItem(input);
					play();
				}
			}
			else if(command.equalsIgnoreCase("save") && input.equalsIgnoreCase("game"))
			{
				try {
					Game.saveGame();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(command.equalsIgnoreCase("attempt") && input.equalsIgnoreCase("puzzle") && room.getPuzzle() != null)
			{
				Room hintRoom = searchRoomByID(3);
				room.getPuzzle().solve(in, hintRoom.isVisited());
				play();
			}
			else
			{
				System.out.println("That was not a valid command");
				play();
			}
		}
		else if(consoleText.length > 2)
		{
			String input = consoleText[1];
			for(int i = 2; i < consoleText.length; i++)
			{
				input = input + " " + consoleText[i];
			}
			
			if(command.equalsIgnoreCase("pickup"))
			{
				if(room.getItemInventory().isEmpty())
				{
					System.out.println("This room does not have any items!");
					play();
				}
				else
				{
					player.pickupItem(input, room);
					play();
				}
			}
			else if(command.equalsIgnoreCase("drop"))
			{
				if(player.getInventory().isEmpty())
				{
					System.out.println(player.getEntityName() + " does not have any items!");
					play();
				}
				else
				{
					player.dropItem(input, room);
					play();
				}
			}
			else if(command.equalsIgnoreCase("inspect"))
			{
				if(player.getInventory().isEmpty() && room.getItemInventory().isEmpty())
				{
					System.out.println("There are no items available to inspect!");
					play();
				}
				else
				{
					player.inspect(input, room);
					play();
				}
			}
			else if(command.equalsIgnoreCase("consume"))
			{
				if(player.getInventory().isEmpty())
				{
					System.out.println("There are no items in your inventory!");
					play();
				}
				else if(player.itemAvailable(input))
				{
					player.consumeItem(input);
					play();
				}
				else
				{
					System.out.println(input + " is not in your inventory!");
					play();
				}
			}
			else if(command.equalsIgnoreCase("use") && room.getSpecialCommand()[0].equalsIgnoreCase(" "))
			{
				player.useItem(input);
				play();
			}
			else if (command.equalsIgnoreCase("use") && !room.getSpecialCommand()[0].equalsIgnoreCase(" "))
			{
				String[] s = room.getSpecialCommand()[0].split(" ");
				String str = s[1];
				
				for (int i = 2; i < s.length; i++)
				{
					str = str + " " + s[i];
				}
				
				if (str.equalsIgnoreCase(input))
				{
					move(room);
					play();
				}
				
				else
				{
					player.useItem(input);
					play();
				}
			}
			else
			{
				System.out.println("That was not a valid command");
				play();
			}
		}
	}

}

