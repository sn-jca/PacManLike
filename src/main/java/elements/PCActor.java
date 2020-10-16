package elements;

import map.PCBlock;
import map.PCBox;

public abstract class PCActor extends PCElement {

	protected PCBox currentBox;

	public PCActor(){
		currentBox=new PCBlock();
	}

	public void moveTo(PCBox box){
		if(!box.isBlock()){
			currentBox.remove(this);
			currentBox=box;
			currentBox.add(this);
		}
	}

	public void moveUp() { currentBox.moveUp(this);}

	public void moveDown() { currentBox.moveDown(this); }

	public void moveLeft() { currentBox.moveLeft(this); }

	public void moveRight() { currentBox.moveRight(this); }

	public PCBox getCurrentBox()
	{
		return currentBox;
	}
	

}
