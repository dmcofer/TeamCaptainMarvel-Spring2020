
public class Consumable extends Item {
	
	//instance variables
	private int healthIncrease;

	//Constructor
	public Consumable(int itemID, String itemName, String itemDescription, int healthIncrease) {
		
		super(itemID, itemName, itemDescription);
		this.healthIncrease = healthIncrease;
	}

	//getter and setter methods
	public int getHealthIncrease() {
		return healthIncrease;
	}

	public void setHealthIncrease(int healthIncrease) {
		this.healthIncrease = healthIncrease;
	}
	
	

}
