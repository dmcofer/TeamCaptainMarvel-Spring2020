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
	
	//method to print out players inventory
	public void inventory()
	{
		if(!this.getInventory().isEmpty())
		{
			System.out.println("These are the items in your inventory ->");
			for(int i = 0; i < this.getInventory().size(); i++)
			{
				System.out.println(this.getInventory().get(i).getItemName());
			}
		}
		else
		{
			System.out.println("You do not have any items in your inventory.");
		}
	}
	

}
