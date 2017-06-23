package paintmvc.geometry;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Nemanja
 * @version 1.0
 */

public abstract class SurfaceShape extends Shape {
	
	protected Color areaColor;
	
	/**
	 * Prazan konstruktor
	 */
	public SurfaceShape(){}
	
	/**
	 * Konstruktor koji prihvata dva parametra
	 * @param lineColor boja linije
	 * @param areaColor boja povr�ine oblika
	 */
	public SurfaceShape(Color lineColor, Color areaColor){
		this.areaColor = areaColor;
		this.lineColor = lineColor;
	}
	
	/**
	 * Konstruktor koji prihvata tri parametra
	 * @param selected selektovan (true or false)
	 * @param lineColor boja linije
	 * @param areaColor boja povr�ine oblika
	 */
	public SurfaceShape(boolean selected, Color lineColor, Color areaColor){
		super(selected, lineColor);
		this.areaColor = areaColor;
	}
	
	/**
	 * Get metoda vra�a boju povr�ine oblika.
	 * @return areaColor
	 */
	public Color getInternalColor() {
		return areaColor;
	}
	
	/**
	 * Set metoda postavlja boju povr�ine oblika.
	 * @param areaColor boja povr�ine
	 */
	public void setAreaColor(Color areaColor) {
		this.areaColor = areaColor;
	}
	
	/**
	 * Metoda boji povr�inu oblika.
	 * @param g grafika
	 */
	public abstract void fillArea(Graphics g);
	
	/**
	 * Metoda izra�unava povr�inu oblika.
	 * @return povr�ina oblika
	 */
	public abstract double surfaceArea();
	
	/**
	 * Metoda izra�unava obim oblika.
	 * @return obim oblika
	 */
	public abstract double volume();

}
