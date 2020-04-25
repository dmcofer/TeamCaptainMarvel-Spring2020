import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File itemsFile = new File("items.txt");
		File puzzlesFile = new File("puzzles.txt");
		File monstersFile = new File("monsters.txt");
		File roomsFile = new File("rooms.txt");
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter player name");
		String name = in.nextLine();
		
		Player player = new Player(name, 3, 1, new ArrayList<Item>(), new ArrayList<Item>());
		
		Map map = new Map(player, roomsFile, itemsFile, puzzlesFile, monstersFile);
		
		map.createGame();
		
		
		in.close();
	}

}
