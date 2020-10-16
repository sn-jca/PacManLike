package game;


import elements.Blinky;
import elements.Inky;
import elements.PinkyAndClyde;
import map.PCMap;

/**
 * class Map1.
 * Creates the map1 of the game. 
 * @author Julien Candela
 */
public class Map1 extends GameBuilder {

	
	/**
	 * Constructor
	 * This map has 10 rows and 10 columns
	 * 1 Wall
	 * 4 Ghosts 
	 * 10 pacdots
	 */
	public Map1 (){	
		super();
		map=new PCMap(10,10);
		// add Walls
		addWall(3,3, 3, 5);

		// add PacDots

		addPacDots(1,2);
		addPacDots(1,6);
		addPacDots(4,1);
		addPacDots(4,9);
		addPacDots(5,3);
		addPacDots(7,4);
		addPacDots(7,7);
		addPacDots(8,2);
		addPacDots(10,5);
		addPacDots(10,9);


		// add Ghosts

		addGhostOn(Blinky.getUniqueBlinky(pacman),10,8,GameBuilder.BLINKY);
		addGhostOn(Inky.getUniqueInky(pacman),10,9,GameBuilder.INKY);
		addGhostOn(PinkyAndClyde.getUniqueClyde(pacman),10,7,GameBuilder.CLYDE);
		addGhostOn(PinkyAndClyde.getUniquePinky(pacman),10,10,GameBuilder.PINKY);

	}

	/**
	 * Move the ghost to its original position
	 * (does not create a new thread)
	 */
	public void setPositionGhosts(){
	
		ghostSetPosition(Blinky.getUniqueBlinky(pacman),10,8,GameBuilder.BLINKY);
		ghostSetPosition(Inky.getUniqueInky(pacman),10,9,GameBuilder.INKY);
		ghostSetPosition(PinkyAndClyde.getUniquePinky(pacman),10,10,GameBuilder.PINKY);			
		ghostSetPosition(PinkyAndClyde.getUniqueClyde(pacman),10,11,GameBuilder.CLYDE);
	
	}
	

	
}
