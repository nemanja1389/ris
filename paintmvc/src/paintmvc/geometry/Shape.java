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
	 * Metoda pristupa isSelected()
	 * @return
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * Metoda pristupa setSelected(boolean selected)
	 * @param selected
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * Metoda pristupa getLineColor()
	 * @return
	 */
	public Color getLineColor() {
		return lineColor;
	}

	/**
	 * Metoda pristupa setLineColor(Color lineColor)
	 * @param lineColor
	 */
	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}
	
	/**
	 * Metoda koja prihvata sledece prosledjene parametre:
	 * @param x
	 * @param y
	 * @return
	 * i proverava da li se odredjene kordinate x i y nalaze u datom obliku
	 */
	public abstract boolean contains(int x, int y);
	
	/**
	 * Metoda koja prihvata sledeci parametar:
	 * @param g
	 * i iscrtava oblik
	 */
	public abstract void draw(Graphics g);

}
