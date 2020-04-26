import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	
	private static Map map;

<<<<<<< HEAD
	private static Map map;

=======
>>>>>>> 06cfe5876498bfba242d546683aefc186edf3bef
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File itemsFile = new File("items.txt");
		File puzzlesFile = new File("puzzles.txt");
		File monstersFile = new File("monsters.txt");
		File roomsFile = new File("rooms.txt");


		Scanner input = new Scanner(System.in);
		System.out.println("Start New Game or Load Game");
		String gameStart = input.nextLine();
<<<<<<< HEAD

		if (gameStart.equalsIgnoreCase("start new game")) {
			System.out.println("Enter player name");
			String name = input.next();

			Player player = new Player(name, 3, 1, new ArrayList<Item>(), new ArrayList<Item>());

			map = new Map(player, roomsFile, itemsFile, puzzlesFile, monstersFile);

=======
		
		if (gameStart.equalsIgnoreCase("start new game")) {
			System.out.println("Enter player name");
			String name = input.next();
			
			Player player = new Player(name, 3, 1, new ArrayList<Item>(), new ArrayList<Item>());
			
			map = new Map(player, roomsFile, itemsFile, puzzlesFile, monstersFile);
			
>>>>>>> 06cfe5876498bfba242d546683aefc186edf3bef
			map.createGame();
			System.out.println("Hello " + player.getEntityName());
			map.play();
		}
		else if (gameStart.equalsIgnoreCase("load game")) {
<<<<<<< HEAD

=======
			
>>>>>>> 06cfe5876498bfba242d546683aefc186edf3bef
			try {
				ObjectInputStream load = new ObjectInputStream(new FileInputStream("save.dat"));
				map = (Map)load.readObject();
				map.setPlayer((Player)load.readObject());
				map.setRoomList((ArrayList<Room>)load.readObject());
				map.setAvailableItems((ArrayList<Item>)load.readObject());
				map.setAvailableMonsters((ArrayList<Monster>)load.readObject());
				load.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
<<<<<<< HEAD

			map.play();
		}
		input.close();
=======
			
			map.play();
		}
		input.close();
	}
	
	public static void saveGame() throws IOException {
		
		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("save.dat"))){
			output.writeObject(map);
			output.writeObject(map.getPlayer());
			output.writeObject(map.getRoomList());
			output.writeObject(map.getAvailableItems());
			output.writeObject(map.getAvailableMonsters());
			System.out.println("Save Successful");
		}
		map.play();
>>>>>>> 06cfe5876498bfba242d546683aefc186edf3bef
	}


public static void saveGame() throws IOException {

	try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("save.dat"))){
		output.writeObject(map);
		output.writeObject(map.getPlayer());
		output.writeObject(map.getRoomList());
		output.writeObject(map.getAvailableItems());
		output.writeObject(map.getAvailableMonsters());
		System.out.println("Save Successful");
	}
	map.play();
}

}
