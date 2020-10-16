package map;

import elements.PCElement;
import elements.PCNullElement;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

/**
 * class PCBox.
 * Defines the boxes used to create maps in the game.
 * They can contain PCElements (actors, pacdots...) (LinkedList) 
 * they have two coordinates coordX y coordY
 * Each PCBox has PCBox neighbors (up, down, left, right) 
 * @author Julien Candela
 */
public class PCBox extends JLabel{
	
	private LinkedList<PCElement> elements;
	
	protected int coordX;
	protected int coordY;
	
	protected PCBox topBox;
	protected PCBox downBox;
	protected PCBox leftBox;
	protected PCBox rightBox;
	
	
	/**
	 * Constructor
	 * Creates the LinkedList f Elements contained in the PCBox
	 * Size of the Box : 24 px
	 * Set the border in black
	 */
	public PCBox(){
		elements = new LinkedList<PCElement>();
		elements.add(new PCNullElement());
		setPreferredSize(new Dimension(24,24));
		setMaximumSize(new Dimension(24,24));
		setMinimumSize(new Dimension(24,24));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		setOpaque(true);
	}
	
	/**
	 * Tell if the PCBox is a Block or not. In that case, no
	 * @return false 
	 */
	public boolean isBlock(){
		return false;
	}
	
	/**
	 * Set the coordinates of the PCBox
	 * @param x coordinate X
	 * @param y coordinate Y
	 */
	public void setCoord(int y, int x)
	{
		coordX=x;
		coordY=y;
	}
	
	/**
	 * Return the coordinate X of the Box
	 * @return coordX coordinate X
	 */
	public int getCoordX()
	{
		return coordX;
	}
	
	/**
	 * Return the coordinate Y of the Box
	 * @return coordY coordinate Y
	 */
	public int getCoordY()
	{
		return coordY;
	}
	
	/**
	 * Return the PCBox at the top of this
	 * @return topBox
	 */
	public PCBox getTopBox() {
		return topBox;
	}
	/**
	 * Return the PCBox at the bottom of this
	 * @return downBox
	 */
	public PCBox getDownBox() {
		return downBox;
	}
	
	/**
	 * Return the PCBox on the left of this
	 * @return leftBox
	 */
	public PCBox getLeftBox() {
		return leftBox;
	}
	
	/**
	 * Return the PCBox on the right of this
	 * @return rightBox
	 */
	public PCBox getRightBox() {
		return rightBox;
	}
	
	/**
	 * Move Up a PCElement
	 * @param element PCElement that moves
	 */
	public void moveUp(PCElement element){}
	
	/**
	 * Move Down a PCElement
	 * @param element PCElement that moves
	 */
	public void moveDown(PCElement element){}
	
	/**
	 * Move Left a PCElement
	 * @param element PCElement that moves
	 */
	public void moveLeft(PCElement element){}
	
	/**
	 * Move Right a PCElement
	 * @param element PCElement that moves
	 */
	public void moveRight(PCElement element){}
	
	
	/**
	 * Change the PCBoxes Neighbor after a move
	 * @param _top PCBox up after move
	 * @param _down PCBox down after move
	 * @param _left PCBox left after move
	 * @param _right PCBox right after move
	 */
	public void updateNeighbors(PCBox _top, PCBox _down, PCBox _left, PCBox _right){
		topBox = _top;
		downBox = _down;
		leftBox = _left;
		rightBox = _right;
	}
	
	/**
	 * add an PCElement in the LinkedList of PCELement
	 * @param newElement the PCElement to add
	 */
	public void add(PCElement newElement){
		elements.addFirst(newElement);
		updateBox();
	}
	
	/**
	 * return an element in the list (the last) 
	 * 
	 */
	public PCElement getPacDot()
	{
		return elements.get(1);
	}
	
	
	/**
	 * remove an PCElement in the LinkedList of PCELement
	 * @param element the PCElement to remove
	 */
	public void remove(PCElement element){
		elements.remove(element);
		updateBox();
	}
	
	public void updateBox() {
		InputStream stream = getClass().getResourceAsStream(elements.get(0).fileImageName());
		try {
			setIcon(new ImageIcon(ImageIO.read(stream)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		repaint();
	}

}
