
public class Ending {
	
	//instance variables
	private int endingID;
	private String endingName;
	private String endingDescription;
	private int currentRoomID;
	
	//Constructor
	public Ending(int endingID, String endingName, String endingDescription, int currentRoomID) {
		
		this.endingID = endingID;
		this.endingName = endingName;
		this.endingDescription = endingDescription;
		this.currentRoomID = currentRoomID;
	}

	//getter and setter methods
	public int getEndingID() {
		return endingID;
	}

	public void setEndingID(int endingID) {
		this.endingID = endingID;
	}

	public String getEndingName() {
		return endingName;
	}

	public void setEndingName(String endingName) {
		this.endingName = endingName;
	}

	public String getEndingDescription() {
		return endingDescription;
	}

	public void setEndingDescription(String endingDescription) {
		this.endingDescription = endingDescription;
	}
	
	public int getCurrentRoomID() {
		return currentRoomID;
	}

	public void setCurrentRoomID(int currentRoomID) {
		this.currentRoomID = currentRoomID;
	}
}
