package game;


import java.util.HashMap;

/**
 * Main Class.
 * @author Julien Candela
 */
public class MainClass {
	
	/**
	* Create a HashMap used to play with the Map Wished
	* 
	* @return HashMap<String, GameBuilder> which contains the 3
	* types of different Maps.
	* 
	*/
	private static HashMap<String, GameBuilder> GenerateHashMap(){
		HashMap<String,GameBuilder> map = new HashMap<String, GameBuilder>();
		map.put("map", new Map2());

		return map;
	}
		
	public static void main(String[] args) throws InterruptedException {		
		
		/*HashMap<String,GameBuilder> HM = GenerateHashMap();
		GameBuilder Map = HM.get(args[0]);
		Game game = Game.getUniqueGame();
		game.setGameBuilder(Map);
		game.playWith();*/

		
		Game game = Game.getUniqueGame();
		game.setGameBuilder(new Map1());
		// Play with the Map2
		game.playWith();			
		
	}
}
