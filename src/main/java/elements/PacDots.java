package elements;

import map.PCBox;

public class PacDots extends PCElement {

	private boolean eaten=false;
	
	public boolean getEaten() {return eaten;}

	public PacDots(){
		nb++;
		fileImageName="/pacdot.png";
		
	}

	public void removePacDots(PCBox currentBox) {
		currentBox.remove(this);
		eaten = true;
		nb--;
	}

	public void modifyScorePacman(Pacman pacman){
		pacman.incrementPacdotsEaten();
		
	}
	
	}
	
	


