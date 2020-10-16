package map;

import elements.PCElement;

/**
 * class PCEmptyBox.
 * @author Julien Candela
 */
public class PCEmptyBox extends PCBox{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * Move Up a PCElement
	 */
	public void moveUp(PCElement element){
		element.moveTo(topBox);
	}
	
	/**
	 * Move Down a PCElement
	 */
	public void moveDown(PCElement element){
		element.moveTo(downBox);
	}
	
	/**
	 * Move Left a PCElement
	 */
	public void moveLeft(PCElement element){
		element.moveTo(leftBox);
	}
	
	/**
	 * Move Right a PCElement
	 */
	public void moveRight(PCElement element){
		element.moveTo(rightBox);
	}
	
}
