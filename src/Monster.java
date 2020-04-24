
public class Monster extends Entity {
	
	//instance variablesString monsterDescription
	private String monsterDescription;

	//constructor
	public Monster(String entityName, int health, int attack, int currentRoomId, String monsterDescription) {
		
		super(entityName, health, attack, currentRoomId);
		this.monsterDescription = monsterDescription;
	}

	//getter and setter methods
	public String getMonsterDescription() {
		return monsterDescription;
	}

	public void setMonsterDescription(String monsterDescription) {
		this.monsterDescription = monsterDescription;
	}
	
}
