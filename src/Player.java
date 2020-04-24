import java.util.ArrayList;

public class Player extends Entity {
	
	//instance variables
	private ArrayList<Item> inventory;

	//constructors
	public Player(String entityName, int health, int attack, int currentRoomId, ArrayList<Item> inventory) {
		
		super(entityName, health, attack, currentRoomId);
		this.inventory = inventory;
	}

	//getters and setters
	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	
	

}
