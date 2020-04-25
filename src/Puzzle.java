
public class Puzzle {

	//instance variables
	private int puzzleID;
	private String puzzleDescription;
	private String answer;
	private String hint;
	private int attempts;
	private int currentRoomID;
	
	//Constructor
	public Puzzle(int puzzleID, String puzzleDescription, String answer, String hint, int attempts, int currentRoomID) {
	
		this.puzzleID = puzzleID;
		this.puzzleDescription = puzzleDescription;
		this.answer = answer;
		this.hint = hint;
		this.attempts = attempts;
		this.currentRoomID = currentRoomID;
	}

	//getter and setter methods
	public int getPuzzleID() {
		return puzzleID;
	}

	public void setPuzzleID(int puzzleID) {
		this.puzzleID = puzzleID;
	}

	public String getPuzzleDescription() {
		return puzzleDescription;
	}

	public void setPuzzleDescription(String puzzleDescription) {
		this.puzzleDescription = puzzleDescription;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public int getCurrentRoomID() {
		return currentRoomID;
	}

	public void setCurrentRoomID(int currentRoomID) {
		this.currentRoomID = currentRoomID;
	}
	

	
}
