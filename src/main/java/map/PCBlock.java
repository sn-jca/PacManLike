package map;

import java.awt.*;


/**
 * class PCBlock.
 * defines the blocks used to create walls in the map 
 * @author Julien Candela
 */
public class PCBlock extends PCBox {

	/**
	 * serial version to jump eclipse warning
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * defines a color : black
	 * opacity 
	 */
	public PCBlock(){
		super();
		setOpaque(true);
		setBackground(Color.BLACK);
		revalidate();
	}
	
	/**
	 * Tell the status of the block which is a Block
	 * @return true  
	 */
	@Override
	public boolean isBlock() {
		return true;
	}

}
