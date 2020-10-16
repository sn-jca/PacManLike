package map;

import elements.Pacman;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;


/**
 * class for the graphical component which shows 
 * the number of lives and the score of pacman
 * It is an observer of Pacman
 * @author Julien Candela
 */
public class PCLivesScorePanel extends JLabel implements Observer {

	private Pacman pacman;
	
	/**
	 * Constructor
	 * @param _text String, text printed first
	 * @param _pacman Pacman observed
	 */
	public PCLivesScorePanel(String _text, Pacman _pacman){
		super(_text);
		pacman = _pacman;
		pacman.addObserver(this);
	}
	
	/**
	 * When Pacman notifies the Label (each move) 
	 * the text printed changes
	 * actualization of the score and of number of lives
	 */
	public void update(Observable o, Object data){
		setText("Pacman has "+pacman.lives()+" lives, Score = "+pacman.score());
	}
	
	
		 
	
}
