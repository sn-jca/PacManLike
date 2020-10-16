package elements;


import map.PCBox;

import java.util.Observable;

public abstract class PCElement extends Observable{
	
	
	protected String fileImageName;
	public static int nb = 0;

	public int getnb(){
		return nb;
	}

	public PCElement(){
		//fileImageName="/null-element.png";
	}
	

	public String fileImageName(){
		return fileImageName;
	}

	public void setImageFileName(String name){
		fileImageName=name;
	}

	public void moveTo(PCBox box){}

	public void removePacDots(PCBox currentBox) {
		
	}

	public void modifyScorePacman(Pacman pacman){}
		
	
}
