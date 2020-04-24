
public class Entity {
	
	//instance variables
	private String entityName;
	private int health;
	private int attack;
	private int currentRoomId;
	
	//constructor
	public Entity(String entityName, int health, int attack, int currentRoomId) {
		super();
		this.entityName = entityName;
		this.health = health;
		this.attack = attack;
		this.currentRoomId = currentRoomId;
	}

	//getters and setters
	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getCurrentRoomId() {
		return currentRoomId;
	}

	public void setCurrentRoomId(int currentRoomId) {
		this.currentRoomId = currentRoomId;
	}
	
	
	
	
	

}
