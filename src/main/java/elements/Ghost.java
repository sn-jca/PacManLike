package elements;

import map.PCBox;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class Ghost extends PCActor implements Runnable, Observer{

	protected Pacman pacman;
	protected boolean active;
	protected int speed;// milliseconds

	public Ghost(Pacman _pacman){
		active = true;
		pacman = _pacman;

	}

	public Pacman getPacman(){
		return pacman;
	}

	public void moveTo(PCBox box){
		super.moveTo(box);
		checkPosition();
	}

	public void moveToNextCell(){
		checkPosition();
		double random=Math.random();
		if(random<0.25) this.moveDown();
		else if(random <0.5) this.moveLeft();
		else if(random <0.75) this.moveRight();
		else this.moveUp();
	}

	public void disable(){
		active=false;
	}
	

	public void run(){
		while(active){
			try{Thread.sleep(speed);} catch(Exception e){}
			this.moveToNextCell();
			checkIfPacManWon();
		}
	}


	private void checkIfPacManWon() {
		if (pacman.getWinner()==true)
		active=false;
		
	}

	public void update(Observable obs, Object args) {
		checkPosition();
	}

	protected void checkPosition(){
		if(pacman.currentBox == currentBox){
			pacman.decreaseLives();

			if (pacman.lives() == 0) 
				{JOptionPane.showMessageDialog(null,"Game Over");
				System.exit(0);}
			
			else {

				pacman.moveToOrigin();
				pacman.gameBuilder().setPositionGhosts();
				
				}
		}
	}
}
