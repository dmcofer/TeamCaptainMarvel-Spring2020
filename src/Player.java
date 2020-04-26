import java.util.ArrayList;

public class Player extends Entity {

	//instance variables
	private ArrayList<Item> inventory;
	private ArrayList<Item> usedItems; //items used by player, checked for monster fights
	private int currentRoomID;

	//constructors
	public Player(String entityName, int health, int currentRoomID, ArrayList<Item> inventory, ArrayList<Item> usedItems) {

		super(entityName, health);
		this.currentRoomID = currentRoomID;
		this.inventory = inventory;
		this.usedItems = usedItems;
	}

	//getters and setters
	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}
	
	public int getCurrentRoomID() {
		return currentRoomID;
	}

	public void setCurrentRoomID(int currentRoomID) {
		this.currentRoomID = currentRoomID;
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
	
	public void search(Room room)
	{
		if(room.getItemInventory().isEmpty())
		{
			System.out.println("This room is empty. There are no items.");
		}
		else
		{
			for(int i = 0; i < room.getItemInventory().size(); i++)
			{
				System.out.println(room.getItemInventory().get(i).getItemName());
			}
		}
	}

	//method to display item description if the examine item command is used and the item is in the player's inventory
	public void inspect(String itemName) {
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
	
	private Item searchItemByName(String itemName) {
		Item item = null;
		
		for(int i = 0; i < inventory.size(); i++)
		{
			if(inventory.get(i).getItemName().equalsIgnoreCase(itemName))
			{
				item = inventory.get(i);
			}
		}
		
		return item;
	}
	
	public void consumeItem(String itemName) {
		if(itemAvailable(itemName))
		{
			Item item = searchItemByName(itemName);
			
			if(item instanceof Consumable)
			{
				int health = this.getHealth() + ((Consumable) item).getHealthIncrease();
				this.setHealth(health);
				inventory.remove(item);
				usedItems.add(item);
				System.out.println(itemName + " has been consumed and your health is now " + this.getHealth() + " health points.");	
			}
			else
			{
				System.out.println(itemName + " is not a consumable item.");
			}
		}
	}
}
