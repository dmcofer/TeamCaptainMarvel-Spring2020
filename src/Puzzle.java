import java.io.Serializable;
import java.util.Scanner;

public class Puzzle implements Serializable{

	//instance variables
	private int puzzleID;
	private String[] puzzleDescription;
	private String[] answer;
	private String hint;
	private int attempts;
	private String failMessage;
	private String successMessage;
	private int currentRoomID;
	private boolean isSolved;
	
	//Constructor
	public Puzzle(int puzzleID, String[] puzzleDescription, String[] answer, String hint, int attempts,
			String failMessage, String successMessage, int currentRoomID, boolean isSolved) {
	
		this.puzzleID = puzzleID;
		this.puzzleDescription = puzzleDescription;
		this.answer = answer;
		this.hint = hint;
		this.attempts = attempts;
		this.failMessage = failMessage;
		this.successMessage = successMessage;
		this.currentRoomID = currentRoomID;
		this.isSolved = isSolved;
	}
	
	public void solve(Scanner kb) {
		
		System.out.println();
		for (String s: puzzleDescription) {
			System.out.println(s);
		}
		System.out.println("Type \"solve\" when ready to solve the puzzle");
		String solve = kb.nextLine();
		
		if (solve.equalsIgnoreCase("solve")) {
			for (int i = 0; i < 20; i++) {
				System.out.println();
			}
		}
		int i = 0;
		
		//guess until win/lose
		while (solve.equalsIgnoreCase("solve") && attempts > 0 && !isSolved) {
			String guess = kb.nextLine();
			
			//player enters correct answer
			if (guess.equalsIgnoreCase(answer[i])) {
				System.out.println("Correct!");
				i++;
			}
			
			//incorrect answers decrease the amount of attempts
			else {
				attempts--;
				System.out.println("The answer you provided is wrong, you still have " + attempts + " attempt(s) left.");
				i = 0;
			}
			
			if (i == answer.length) {
				System.out.println(successMessage);
				isSolved = true;
			}
		}
		
		//if the player runs out of attempts and did not get the correct answer
		if (attempts == 0 && !isSolved) {
			System.out.println("Failed to solve");
			System.out.println("The correct answer is " + answer);
		}
	}

	//getter and setter methods
	public int getPuzzleID() {
		return puzzleID;
	}

	public void setPuzzleID(int puzzleID) {
		this.puzzleID = puzzleID;
	}

	public String[] getPuzzleDescription() {
		return puzzleDescription;
	}

	public void setPuzzleDescription(String[] puzzleDescription) {
		this.puzzleDescription = puzzleDescription;
	}

	public String[] getAnswer() {
		return answer;
	}

	public void setAnswer(String[] answer) {
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
	
	public String getFailMessage() {
		return failMessage;
	}

	public void setFailMessage(String failMessage) {
		this.failMessage = failMessage;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public int getCurrentRoomID() {
		return currentRoomID;
	}

	public void setCurrentRoomID(int currentRoomID) {
		this.currentRoomID = currentRoomID;
	}
	
	public boolean isSolved() {
		return isSolved;
	}
	
	public void setSolved(boolean isSolved) {
		this.isSolved = isSolved;
	}
	

	
}
