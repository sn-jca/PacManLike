package map;

import javax.swing.*;
import java.awt.*;

/**
 * class PCMap.
 * Creates the grid of the game which contains the boxes.
 * A PCMap has an Array of PCBox(es)
 * a number of rows and a number of columns
 * 
 * @author Julien Candela
 */
public class PCMap extends JPanel{
	
	/**
	 * serial version to jump eclipse warning
	 */
	private static final long serialVersionUID = 1L;
	
	private PCBox[][] box;
	private int n;
	private int m;
	
	
	/**
	 * Constructor
	 * 
	 */
	public PCMap(int _n,int _m){
		box = new PCBox[_n+2][_m+2];
		for(int i=0;i<_n+2;i++)
			for(int j=0;j<_m+2;j++)
				{box[i][j]=new PCBlock();
				box[i][j].setCoord(i,j);}
		n = _n;
		m = _m;
		setLayout(new GridLayout(n,m));		
		fillMatrix();
		updateNeighbors();
	}
	
	/**
	 * Set a PCbox in a place in the grid.
	 * @param i column
	 * @param j row
	 * @param _box PCBox to set
	 * 
	 */
	public void setBox(int i,int j,PCBox _box){
		box[i][j]=_box;
		updateNeighbors();
		updateUI();
	}
	
	/**
	 * Return the PCBox in a place
	 * @param i column
	 * @param j row
	 * @return the PCBox looked up. 
	 */
	public PCBox getBox(int i,int j){
		return box[i][j];
	}
	
	
	
	/**
	 * fills the grid with PCEmptyBox
	 * and sets the coordinates of the PCBox(es)  
	 */
	private void fillMatrix(){
		for(int i=1; i<=n;i++){
			for(int j=1;j<=m;j++){
				box[i][j]=new PCEmptyBox();
				box[i][j].setCoord(i,j);
			}
		}
	}
	
	/**
	 * load boxes in the map 
	 */
	public void loadBoxes(){
		for(int i=1; i<=n;i++){
			for(int j=1;j<=m;j++){
				add(box[i][j]);
			}
		}
	}
	
	private void updateNeighbors(){
		for(int i=1; i<=n;i++){
			for(int j=1;j<=m;j++){
				box[i][j]
					.updateNeighbors(
							box[i-1][j],
							box[i+1][j],
							box[i][j-1],
							box[i][j+1]);
				box[i][j].updateBox();
			}
		}
	}
}
