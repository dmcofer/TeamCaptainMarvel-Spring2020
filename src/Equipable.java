import java.io.Serializable;

public class Equipable extends Item implements Serializable {
	
	//instance variables
	private String pickupMessage;
	private String useMessage;

	//Constructor
	public Equipable(int itemID, String itemName, String itemDescription, String pickupMessage, String useMessage) {
		
		super(itemID, itemName, itemDescription);
		this.pickupMessage = pickupMessage;
		this.useMessage = useMessage;
	}

	//getter and setter methods
	
	public String getPickupMessage() {
		return pickupMessage;
	}

	public void setPickupMessage(String pickupMessage) {
		this.pickupMessage = pickupMessage;
	}

	public String getUseMessage() {
		return useMessage;
	}

	public void setUseMessage(String useMessage) {
		this.useMessage = useMessage;
	}

}
