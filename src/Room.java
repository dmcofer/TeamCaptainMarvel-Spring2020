import java.util.ArrayList;

public class Room {

	//instance variables
	private int roomID;
	private String roomName;
	private String roomDescription;
	private String inspectMessage;
	private int[] connections;//0 = north, 1 = east, 2 = south, 3 = west
	private ArrayList<Item> itemInventory;
	private ArrayList<Monster> monsters;
	private boolean visited;
	private boolean hasItem;
	private Puzzle puzzle;

	//Constructor
	public Room(int roomID, String roomName, String roomDescription, String inspectMessage, int[] connections,
			ArrayList<Item> itemInventory, ArrayList<Monster> monsters, boolean visited) {

		this.roomID = roomID;
		this.roomName = roomName;
		this.roomDescription = roomDescription;
		this.inspectMessage = inspectMessage;
		this.connections = connections;
		this.itemInventory = itemInventory;
		this.monsters = monsters;
		this.visited = visited;
		this.hasItem = !itemInventory.isEmpty();
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomDescription() {
		return roomDescription;
	}

	public void setRoomDescription(String roomDescription) {
		this.roomDescription = roomDescription;
	}
	
	public String getInspectMessage() {
		return inspectMessage;
	}

	public void setInspectMessage(String inspectMessage) {
		this.inspectMessage = inspectMessage;
	}

	public int[] getConnections() {
		return connections;
	}

	public void setConnections(int[] connections) {
		this.connections = connections;
	}

	public ArrayList<Item> getItemInventory() {
		return itemInventory;
	}

	public void setItemInventory(ArrayList<Item> itemInventory) {
		this.itemInventory = itemInventory;
	}
	
	public ArrayList<Monster> getMonsters() {
		return monsters;
	}

	public void setMonsters(ArrayList<Monster> monsters) {
		this.monsters = monsters;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	public boolean isHasItem() {
		return hasItem;
	}

	public void setHasItem(boolean hasItem) {
		this.hasItem = hasItem;
	}
	
	public Puzzle getPuzzle() {
		return puzzle;
	}

	public void setPuzzle(Puzzle puzzle) {
		this.puzzle = puzzle;
	}

	//method to see if item is in player's inventory
	public boolean itemAvailable(String itemName) {

		boolean itemAvailable = false;

		if(this.getItemInventory().isEmpty())
		{
			itemAvailable = false;
		}
		else if (this.getItemInventory().size() > 0)
		{
			for(int i = 0; i < this.getItemInventory().size(); i++)
			{
				if(itemName.equalsIgnoreCase(this.getItemInventory().get(i).getItemName()))
				{
					itemAvailable = true;
					break;
				}
				else
				{
					itemAvailable = false;
				}
			}
		}
		return itemAvailable;
	}




}
