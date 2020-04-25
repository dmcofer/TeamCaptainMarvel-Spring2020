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

	//method that allows player to pick up method from room and add it to their inventory
	public void pickupItem(String itemName, Room room) {
		String itemPickedUpMessage = "";

		if(!room.isHasItem())
		{
			itemPickedUpMessage = itemPickedUpMessage + "This room does not have any items!";
		}
		else if(room.itemAvailable(itemName))
		{
			for(int i = 0; i < room.getItemInventory().size(); i++)
			{
				if(itemName.equalsIgnoreCase(room.getItemInventory().get(i).getItemName()))
				{
					Item item = room.getItemInventory().get(i);
					this.getInventory().add(item);
					room.getItemInventory().remove(i);
					if(room.getItemInventory().isEmpty())
					{
						room.setHasItem(false);
					}
					itemPickedUpMessage = itemName + " has been added to your inventory.";
					break;
				}
			}
		}
		else
		{
			itemPickedUpMessage = itemName + " is not in the current room.";
		}
		System.out.println(itemPickedUpMessage);
	}

	//method to drop item from the player's inventory into the current room's inventory
	public void dropItem(String itemName, Room room) {
		String itemDroppedMessage = "";

		if(this.inventory.isEmpty())
		{
			itemDroppedMessage = itemDroppedMessage + "You do not have any items in your inventory.";
		}
		else if(this.itemAvailable(itemName))
		{
			for(int i = 0; i < this.inventory.size(); i++)
			{
				if(itemName.equalsIgnoreCase(this.inventory.get(i).getItemName()))
				{
					Item item = this.inventory.get(i);
					room.getItemInventory().add(item);
					inventory.remove(i);
					room.setHasItem(true);
					itemDroppedMessage = itemName + " has been dropped in the current room.";
				}
			}
		}
		else
		{
			itemDroppedMessage = itemDroppedMessage + itemName + " is not in your item inventory.";
		}
		System.out.println(itemDroppedMessage);
	}


}
