package elements;

public class Inky extends Ghost {

	private static Inky uniqueInky;

	private Inky(Pacman _pacman) {
		super(_pacman);
		speed = 500;

	}

	public static Inky getUniqueInky(Pacman _pacman) {
		if (uniqueInky == null) {
			uniqueInky = new Inky(_pacman);
		}
		return uniqueInky;
	}

}
