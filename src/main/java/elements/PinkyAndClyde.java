package elements;


public class PinkyAndClyde extends Ghost {

	private static PinkyAndClyde uniquePinky;
	private static PinkyAndClyde uniqueClyde;
	

	private PinkyAndClyde(Pacman _pacman){
		super(_pacman);
		speed = 1000; // milliseconds
		}

	public static PinkyAndClyde getUniquePinky(Pacman _pacman){
		if (uniquePinky == null) {uniquePinky = new PinkyAndClyde(_pacman);}
		return uniquePinky;
	}

	public static PinkyAndClyde getUniqueClyde(Pacman _pacman){
		if (uniqueClyde == null) {uniqueClyde = new PinkyAndClyde(_pacman);}
		return uniqueClyde;
	}
}
