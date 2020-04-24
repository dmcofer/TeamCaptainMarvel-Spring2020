
public class Equipable extends Item {
	
	//instance variables
	private int attackIncrease;

	//Constructor
	public Equipable(String itemName, String itemDescription, int attackIncrease) {
		
		super(itemName, itemDescription);
		this.attackIncrease = attackIncrease;
	}

	//getter and setter methods
	public int getAttackIncrease() {
		return attackIncrease;
	}

	public void setAttackIncrease(int attackIncrease) {
		this.attackIncrease = attackIncrease;
	}
	
	

}
