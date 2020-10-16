package elements;

import game.GameBuilder;
import map.PCBox;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Pacman extends PCActor implements KeyListener{
	
	private static Pacman uniquePacman;
	private GameBuilder gameBuilder;
	private double score=0;
	private int moves=0;
	private int pacdotsEaten;
	private boolean winner=false;
	private int lives = 3;

	private Pacman(GameBuilder gb){gameBuilder = gb;}

	public static Pacman getPacman(GameBuilder gb) {
		if (uniquePacman == null)
			uniquePacman= new Pacman(gb);
		return uniquePacman;
	}
	

	public void moveToOrigin(){
		gameBuilder.movePacmanToOrigin(this);
	
	}

	public void moveTo(PCBox box){
		super.moveTo(box);
		setChanged();
		askAPoint();
		eatPacDot();
		doIWon();
		moves++;
		notifyObservers();
	}
	
	
	private void doIWon() {
		if (currentBox.getPacDot().getnb()==0)
		{
		winner=true;
		double finalScore=score+lives*1000;
		JOptionPane.showMessageDialog(null ,"Congratulations! You Won! - score "+finalScore); 
		System. exit (0);
		}
		
	}

	private void askAPoint() {
		currentBox.getPacDot().modifyScorePacman(this);
	}

	private void eatPacDot() {
		currentBox.getPacDot().removePacDots(currentBox);
	}

	public void incrementPacdotsEaten() {
		pacdotsEaten++;
		if(moves!=0)
			score=score+1000/moves;
	}

	public void keyPressed(KeyEvent event) {
		switch(event.getKeyCode()){
		case KeyEvent.VK_UP : moveUp(); break;
		case KeyEvent.VK_DOWN: moveDown();break;
		case KeyEvent.VK_LEFT: moveLeft(); break;
		case KeyEvent.VK_RIGHT: moveRight();break;
		}
	}
	public void keyReleased(KeyEvent event) {
		
	}

	public void keyTyped(KeyEvent event) {
	
	}

	public int getPacdotsEaten() {
		return pacdotsEaten;
	}

	public boolean getWinner() {
		return winner;
	}

	public int lives() {return lives;}

	public void decreaseLives(){
		lives = lives-1;
		
	}

	public GameBuilder gameBuilder(){return gameBuilder;}

	public double score(){return score;}
	
}
