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
	
	//method to see if item is in player's inventory
		public boolean itemAvailable(String itemName) {

			boolean itemAvailable = false;

			if(this.getInventory().isEmpty())
			{
				itemAvailable = false;
			}
			else if (this.getInventory().size() > 0)
			{
				for(int i = 0; i < this.getInventory().size(); i++)
				{
					if(itemName.equalsIgnoreCase(this.getInventory().get(i).getItemName()))
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
	
	//method to display item description if the examine item command is used and the item is in the player's inventory
		public void examine(String itemName) {
			String itemDescription = "";

			for(int i = 0; i < this.getInventory().size(); i++)
			{
				if(itemName.equalsIgnoreCase(this.getInventory().get(i).getItemName()))
				{
					itemDescription = this.getInventory().get(i).getItemDescription();
					break;
				}
				else
				{
					itemDescription = itemName + " is not available for examination";
				}
			}

			System.out.println(itemDescription);
		}
	

}
