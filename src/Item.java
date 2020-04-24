
public class Item {
	
	//instance variables
	private String itemName;
	private String itemDescription;
	
	//constructor
	public Item(String itemName, String itemDescription) {
		
		this.itemName = itemName;
		this.itemDescription = itemDescription;
	}
	
	//getter and setter methods
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
