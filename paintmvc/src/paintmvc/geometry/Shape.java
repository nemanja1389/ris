package paintmvc.geometry;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Nemanja
 * @version 1.0
 * 
 * 
 * 
 */

public abstract class Shape {
	
	protected boolean selected;
	protected Color lineColor;
	
	/**
	 * Prazan konstruktor
	 */
	public Shape(){}
	
	/**
	 * Konsturktor koji prihvata jedan parametar
	 * @param lineColor
	 */
	public Shape(Color lineColor){
		this.lineColor = lineColor;
	}
	
	/**
	 * Konstruktor koji prihvata sledece parametre:
	 * @param selected
	 * @param lineColor
	 */
	public Shape(boolean selected, Color lineColor){
		this.selected = selected;
		this.lineColor = lineColor;
	}

	/**
	 * Metoda isSelected()
	 * @return
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * Metoda setSelected(boolean selected)
	 * @param selected
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * Metoda getLineColor()
	 * @return
	 */
	public Color getLineColor() {
		return lineColor;
	}

	/**
	 * Metoda setLineColor(Color lineColor)
	 * @param lineColor
	 */
	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}
	
	/**
	 * Metoda koja proverava da li oblik sadrzi x i y
	 * @param x
	 * @param y
	 * @return
	 * 
	 */
	public abstract boolean contains(int x, int y);
	
	/**
	 * Metoda koja iscrtava oblike
	 * @param g
	 */
	public abstract void draw(Graphics g);

}
