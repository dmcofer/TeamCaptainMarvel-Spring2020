import java.util.ArrayList;

public class Item {

	//instance variables
	private int itemID;
	private String itemName;
	private String itemDescription;

	//constructor
	public Item(int itemID, String itemName, String itemDescription) {
		
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemDescription = itemDescription;
	}

	//getter and setter methods
	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

}
