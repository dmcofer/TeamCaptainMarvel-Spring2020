import java.io.Serializable;

public class Monster extends Entity implements Serializable {
	
	//instance variablesString monsterDescription
	private int monsterID;
	private String monsterDescription;
	private int chanceOfWinning; //chance out of 100 of doing damage to monster
	private int[] increasedOddsArray; //if player has one item in itemIDArray the use index 0 to replace chanceOfWinning, if player has used both items then use use index
	private int[] itemIDArray; //ID of items that increase odds of winning against monster

	//constructor
	public Monster(String entityName, int health, int monsterID, String monsterDescription, int chanceOfWinning, int[] increasedOddsArray, int[] itemIDArray) {
		
		super(entityName, health);
		this.monsterID = monsterID;
		this.monsterDescription = monsterDescription;
		this.chanceOfWinning = chanceOfWinning;
		this.increasedOddsArray = increasedOddsArray;
		this.itemIDArray = itemIDArray;
		
	}
	
	public Monster(Monster monster)
	{
		super(monster.getEntityName(), monster.getHealth());
		this.monsterID = monster.monsterID;
		this.monsterDescription = monster.monsterDescription;
		this.chanceOfWinning = monster.chanceOfWinning;
		this.increasedOddsArray = monster.increasedOddsArray;
		this.itemIDArray = monster.itemIDArray;
		
	}

	//getter and setter methods
	public int getMonsterID() {
		return monsterID;
	}

	public void setMonsterID(int monsterID) {
		this.monsterID = monsterID;
	}
	
	public String getMonsterDescription() {
		return monsterDescription;
	}

	public void setMonsterDescription(String monsterDescription) {
		this.monsterDescription = monsterDescription;
	}

	public int getChanceOfWinning() {
		return chanceOfWinning;
	}

	public void setChanceOfWinning(int chanceOfWinning) {
		this.chanceOfWinning = chanceOfWinning;
	}

	public int[] getIncreasedOddsArray() {
		return increasedOddsArray;
	}

	public void setIncreasedOddsArray(int[] increasedOddsArray) {
		this.increasedOddsArray = increasedOddsArray;
	}

	public int[] getItemIDArray() {
		return itemIDArray;
	}

	public void setItemIDArray(int[] itemIDArray) {
		this.itemIDArray = itemIDArray;
	}
	
}
