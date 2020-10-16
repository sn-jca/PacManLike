package game;

import elements.Ghost;
import elements.PCActor;
import elements.PacDots;
import elements.Pacman;
import map.PCBlock;
import map.PCBox;
import map.PCLivesScorePanel;
import map.PCMap;

import javax.swing.*;
import java.awt.*;


public abstract class GameBuilder {
	
	protected PCMap map;
	protected Pacman pacman;
	public static final String BLINKY="/red-ghost.png";
	public static final String INKY="/blue-ghost.png";
	public static final String PINKY="/pink-ghost.png";
	public static final String CLYDE="/yellow-ghost.png";
	public static final String PACMAN = "/pacman.png";

	public GameBuilder(){
		
		pacman=Pacman.getPacman(this);
	}

	public Pacman getPacman(){
		return pacman; 
	}

	public void addBlockOn(int x,int y){
		PCBlock block =new PCBlock();
		map.setBox(x,y,block);
	}

	public void addPacman(){
		addPacmanOn(1,1);
	}

	public void addPacmanOn(int x,int y){
		addPacmanOn(x,y,PACMAN);
	}

	public void addPacmanOn(int x,int y,String imageFileName){
		addActorOn(pacman,x,y,imageFileName);
	}
	
	private void addActorOn(PCActor actor, int x, int y, String imageFileName){
		actor.setImageFileName(imageFileName);
		actor.moveTo(map.getBox(x,y));
	}

	public void movePacmanToOrigin(Pacman pacman){
		pacman.moveTo(map.getBox(1,1));
	}

	public void addPacDots (int x, int y){
		PCBox box = map.getBox(x,y);
		box.add(new PacDots());
		
	}

	public void ghostSetPosition(Ghost ghost, int x, int y, String imageFileName){
		pacman.addObserver(ghost);
		addActorOn(ghost,x,y,imageFileName);
	}

	public void addGhostOn(Ghost ghost,int x,int y, String imageFileName){
		ghostSetPosition(ghost, x, y, imageFileName);
		(new Thread(ghost)).start();
	}

	public void addWall(int xo, int yo, int xf,int yf){
		for(int x=xo;x<=xf;x++){
			for(int y=yo;y<= yf;y++){
				addBlockOn(x, y);
			}			
		}
	}
	public void buildAndOpen(){
		
		map.loadBoxes();
		// new JFrame (window)
		JFrame frame=new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Definition of the layout : BorderLayout 
		frame.setLayout(new BorderLayout());
		// add the map in the window, centered in the frame			
		frame.add(map, BorderLayout.CENTER);
		map.updateUI();
		// create a new PCLivesScorePanel and add it
		JLabel j = new PCLivesScorePanel("Pacman has 3 lives",pacman);
		frame.add(j, BorderLayout.NORTH);
				
		frame.setFocusable(true);
		frame.setResizable(false);
		frame.setSize(map.getPreferredSize());
		frame.addKeyListener(pacman);
		
		map.updateUI();
		
	}

	public void playWith() {
		addPacman();
		buildAndOpen();

	}

	public abstract void setPositionGhosts();

}
