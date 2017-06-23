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
	 * @param lineColor boja linije
	 */
	public Shape(Color lineColor){
		this.lineColor = lineColor;
	}
	
	/**
	 * Konstruktor koji prihvata dva parametra
	 * @param selected selektovan (true or false)
	 * @param lineColor boja linije
	 */
	public Shape(boolean selected, Color lineColor){
		this.selected = selected;
		this.lineColor = lineColor;
	}

	/**
	 * Get metoda proverava da li je oblik selektovan ili ne.
	 * @return selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * Set metoda selektuje odnosno deselektuje oblik.
	 * @param selected selektovan (true or false)
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * Get metoda vraæa boju linije
	 * @return lineColor
	 */
	public Color getLineColor() {
		return lineColor;
	}

	/**
	 * Set metoda postavlja boju linije.
	 * @param lineColor boja linije
	 */
	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}
	
	/**
	 * Metoda proverava da li se prosleðene koordinate x i y pripadaju obliku.
	 * @param x koordinata x
	 * @param y koordinata y
	 * @return true or false
	 */
	public abstract boolean contains(int x, int y);
	
	/**
	 * Metoda za iscrtavanje oblika.
	 * @param g grafika
	 */
	public abstract void draw(Graphics g);

}
