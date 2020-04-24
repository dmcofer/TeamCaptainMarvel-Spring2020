import java.util.ArrayList;

public class Room {
	
	//instance variables
		private int roomID;
		private String roomName;
		private String roomDescription;
		private ArrayList<Integer> connections;
		private ArrayList<Item> itemInventory;
		private boolean visited;
		private boolean hasItem;
		private boolean hasPuzzle;
		private boolean hasMonster;
		
		//Constructor
		public Room(int roomID, String roomName, String roomDescription, ArrayList<Integer> connections,
				ArrayList<Item> itemInventory, boolean visited, boolean hasItem, boolean hasPuzzle,
				boolean hasMonster) {
			
			this.roomID = roomID;
			this.roomName = roomName;
			this.roomDescription = roomDescription;
			this.connections = connections;
			this.itemInventory = itemInventory;
			this.visited = visited;
			this.hasItem = hasItem;
			this.hasPuzzle = hasPuzzle;
			this.hasMonster = hasMonster;
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

		public ArrayList<Integer> getConnections() {
			return connections;
		}

		public void setConnections(ArrayList<Integer> connections) {
			this.connections = connections;
		}

		public ArrayList<Item> getItemInventory() {
			return itemInventory;
		}

		public void setItemInventory(ArrayList<Item> itemInventory) {
			this.itemInventory = itemInventory;
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

		public boolean isHasPuzzle() {
			return hasPuzzle;
		}

		public void setHasPuzzle(boolean hasPuzzle) {
			this.hasPuzzle = hasPuzzle;
		}

		public boolean isHasMonster() {
			return hasMonster;
		}

		public void setHasMonster(boolean hasMonster) {
			this.hasMonster = hasMonster;
		}
		
		
		

}
