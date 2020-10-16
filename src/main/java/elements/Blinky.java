package elements;


public class Blinky extends Ghost {

	private static Blinky uniqueBlinky;


	private Blinky(Pacman _pacman) {
		super(_pacman);
		speed = 600;

	}


	public static Blinky getUniqueBlinky(Pacman _pacman) {
		if (uniqueBlinky == null) {
			uniqueBlinky = new Blinky(_pacman);
		}
		return uniqueBlinky;
	}
}
