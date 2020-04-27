import java.io.Serializable;
import java.util.Scanner;

public class Ending implements Serializable {
	
	//instance variables
	private int endingID;
	private String[] endingDescription;
	private String endingPrompt;
	private String endingCommand;
	private String nonEnding;
	private boolean isConnectedToPuzzle;
	private boolean hasMultipleOutcomes;
	private boolean isConnectedToMonsters;
	private int currentRoomID;
	
	//Constructor
	public Ending(int endingID, String[] endingDescription, String endingPrompt, String endingCommand, String nonEnding, boolean isConnectedToPuzzle,
					boolean hasMultipleOutcomes, boolean isConnectedToMonsters) {
		
		this.endingID = endingID;
		this.endingDescription = endingDescription;
		this.endingPrompt = endingPrompt;
		this.endingCommand = endingCommand;
		this.nonEnding = nonEnding;
		this.isConnectedToPuzzle = isConnectedToPuzzle;
		this.hasMultipleOutcomes = hasMultipleOutcomes;
		this.isConnectedToMonsters = isConnectedToMonsters;
	}

	//getter and setter methods
	public int getEndingID() {
		return endingID;
	}

	public void setEndingID(int endingID) {
		this.endingID = endingID;
	}

	public String[] getEndingDescription() {
		return endingDescription;
	}

	public void setEndingDescription(String[] endingDescription) {
		this.endingDescription = endingDescription;
	}
	
	public String getEndingPrompt() {
		return endingPrompt;
	}

	public void setEndingPrompt(String endingPrompt) {
		this.endingPrompt = endingPrompt;
	}

	public String getEndingCommand() {
		return endingCommand;
	}

	public void setEndingCommand(String endingCommand) {
		this.endingCommand = endingCommand;
	}

	public boolean isConnectedToPuzzle() {
		return isConnectedToPuzzle;
	}

	public void setConnectedToPuzzle(boolean isConnectedToPuzzle) {
		this.isConnectedToPuzzle = isConnectedToPuzzle;
	}

	public boolean isHasMultipleOutcomes() {
		return hasMultipleOutcomes;
	}

	public void setHasMultipleOutcomes(boolean hasMultipleOutcomes) {
		this.hasMultipleOutcomes = hasMultipleOutcomes;
	}

	public boolean isConnectedToMonsters() {
		return isConnectedToMonsters;
	}

	public void setConnectedToMonsters(boolean isConnectedToMonsters) {
		this.isConnectedToMonsters = isConnectedToMonsters;
	}

	public int getCurrentRoomID() {
		return currentRoomID;
	}

	public void setCurrentRoomID(int currentRoomID) {
		this.currentRoomID = currentRoomID;
	}
	
	public void showEnding(Scanner kb) {
		
		System.out.println(endingPrompt);
		String choice = kb.nextLine();
		
		if (choice.equalsIgnoreCase(endingCommand)) {
			for (String s: endingDescription)
				System.out.println(s);
			System.exit(1);
		}
	}
	
	public void showMultipleEnding(Scanner kb) {
		
		String[] choices = endingPrompt.split("#");
		for (String s: choices)
			System.out.println(s);
		String choice = kb.nextLine();
		
		while (!isParseable(choice)) {
			System.out.println("Not a valid choice, must be a number");
		}
		
		int num = Integer.parseInt(choice);
		
		if (num == 1) {
			for (String s: endingDescription)
				System.out.println(s);
			System.exit(1);
		}
		
		else if (num == 5) {
			System.out.println("The ship flew into the sun and you have died. Game over.");
			System.exit(1);
		}
		
		else {
			System.out.println(nonEnding);
			showMultipleEnding(kb);
		}
		
		
	}
	
	public boolean isParseable(String s) {
		
		try {
			Integer.parseInt(s);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}
