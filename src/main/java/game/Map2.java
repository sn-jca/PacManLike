package game;


import elements.Blinky;
import elements.Inky;
import elements.PinkyAndClyde;
import map.PCMap;

/**
 * class Map2.
 * Creates the map2 of the game. 
 * @author Julien Candela
 */
public class Map2 extends GameBuilder {

	
	
	/**
	 * Constructor
	 * This map has 20 rows and 20 columns
	 * 1 Wall
	 * 4 Ghosts 
	 * 10 pacdots
	 */
	public Map2 (){
		
		super();
		map=new PCMap(20,20);
		// add Walls
		addWall(3,3, 3, 17);
		
		addWall(6,3, 17, 3);
		
		addWall(6,17, 17, 17);
				
		// add PacDots
			
		for (int i =1; i<20; i++)
			{
			addPacDots(1,i+1);
			
			addPacDots(i+1,1);
			
			addPacDots(20,i+1);
			
			addPacDots(i+1,20);
			}
			
			addPacDots(4,16);
			addPacDots(5,8);
			addPacDots(7,4);
			addPacDots(7,7);
			addPacDots(8,15);
			addPacDots(10,5);
			addPacDots(10,9);
			addPacDots(12,5);
			addPacDots(12,10);
			addPacDots(14,14);
			addPacDots(15,5);
			
						
		// add Ghosts
		addGhostOn(Blinky.getUniqueBlinky(pacman),10,8, GameBuilder.BLINKY);
		addGhostOn(Inky.getUniqueInky(pacman),10,9, GameBuilder.INKY);
		addGhostOn(PinkyAndClyde.getUniquePinky(pacman),10,10, PINKY);
		addGhostOn(PinkyAndClyde.getUniqueClyde(pacman),10,11, CLYDE);
				
	}
	
	/**
	 * Move the ghost to its original position
	 * (does not create a new thread)
	 */
	public void setPositionGhosts(){
		
		ghostSetPosition(Blinky.getUniqueBlinky(pacman),10,8, GameBuilder.BLINKY);
		ghostSetPosition(Inky.getUniqueInky(pacman),10,9, GameBuilder.INKY);
		ghostSetPosition(PinkyAndClyde.getUniquePinky(pacman),10,10, GameBuilder.PINKY);
		ghostSetPosition(PinkyAndClyde.getUniqueClyde(pacman),10,11, GameBuilder.CLYDE);
	
	}
	
}
