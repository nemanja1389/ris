package paintmvc.geometry;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Nemanja
 * 
 */
public class Rectangle extends Square {
	
	private int height;
	
	/**
	 * Prazan konstruktor.
	 */
	public Rectangle(){}
	
	/**
	 * Konstruktor koji prihvata tri parametra.
	 * @param upLeft ta�ka gore levog ugla pravougaonika
	 * @param width �irina pravougaonika
	 * @param height visina pravougaonika
	 */
	public Rectangle(Point upLeft, int width, int height){
		super(upLeft, width);
		this.height = height;
	}
	
	/**
	 * Konstruktor koji privhvata pet parametara.
	 * @param upLeft ta�ka gore levog ugla pravougaonika
	 * @param width �irina pravougaonika
	 * @param height visina pravougaonika
	 * @param lineColor boja linije pravougaonika
	 * @param areaColor boja povr�ine pravougaonika
	 */
	public Rectangle(Point upLeft, int width, int height, Color lineColor, Color areaColor){
		super(upLeft, width, lineColor, areaColor);
		this.height = height;
	}
	
	/**
	 * Konstruktor koji privhata �est parametara.
	 * @param upLeft ta�ka gore levog ugla pravougaonika
	 * @param width �irina pravougaonika
	 * @param height visina pravougaonika
	 * @param selected selektovan (true or false)
	 * @param lineColor boja linije pravougaonika
	 * @param areaColor boja povr�ine pravougaonika
	 */
	public Rectangle(Point upLeft, int width, int height, boolean selected, Color lineColor, Color areaColor){
		super(upLeft, width, selected, lineColor, areaColor);
		this.height = height;
	}

	/**
	 * Get metoda vra�a visinu pravougaonika.
	 * @return height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Set metoda postavlja visinu pravougaonika.
	 * @param height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * Preklopljena metoda koja ispisuje informacije o pravougaoniku.
	 */
	@Override
	public String toString(){
		return "Rectangle: " + "Up left point: " + "x: " + upLeft.getX() + ", y: " + upLeft.getY() + "; Width: " + width + "; Height: " + height
				+ "; Line color: " + "R: " + getLineColor().getRed() + ", " + "G: " + getLineColor().getGreen() + ", " + "B: " + getLineColor().getBlue()
				+ "; Area color: " + "R: " + getInternalColor().getRed() + ", " + "G: " + getInternalColor().getGreen() + ", " + "B: " + getInternalColor().getBlue();
	}
	/**
	 * Metoda koja za prosle�eni objekat ispituje da li je objekat pravougaonika ili nije.
	 * @param o prosle�en objekat koji se ispituje
	 * @return true or false
	 */
	@Override
	public boolean equals(Object o){
		if (o instanceof Rectangle){
			Rectangle rectangle = (Rectangle)o;
			if (upLeft.equals(rectangle.getUpLeft()) 
			    && width == rectangle.getWidth()
			    && height == rectangle.getHeight()){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Metoda boji povr�inu pravougaonika.
	 * @param g grafika
	 */
	@Override
	public void fillArea(Graphics g){
		g.setColor(getInternalColor());
		g.fillRect(upLeft.getX(), upLeft.getY(), width, height);
	}
	
	/**
	 * Metoda izra�unava povr�inu pravougaonika.
	 * @return povr�ina pravougaonika
	 */
	@Override
	public double surfaceArea() {
		return width*height;
	}

	/**
	 * Metoda izra�unava obim pravougaonika.
	 * @return obim pravougaonika
	 */
	@Override
	public double volume() {
		return width*2 + height*2;
	}

	/**
	 * Metoda proverava da li se prosle�ene koordinate x i y pripadaju pravougaonika.
	 * @param x koordinata x
	 * @param y koordinata y
	 * @return true or false
	 */
	@Override
	public boolean contains(int x, int y) {
		if(this.getUpLeft().getX()<=x 
				&& x<=(this.getUpLeft().getX() + width)
				&& this.getUpLeft().getY()<=y 
				&& y<=(this.getUpLeft().getY() + height)){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metoda koja crta pravougaonika.
	 * @param g grafika
	 */
	@Override
	public void draw(Graphics g) {
		fillArea(g);
		g.setColor(getLineColor());
		g.drawRect(upLeft.getX(), upLeft.getY(), width, height);
		if(isSelected()){
			upLeft.drawSquare(g);
			new Point(upLeft.getX()+width, upLeft.getY()).drawSquare(g);
			new Point(upLeft.getX(), upLeft.getY()+height).drawSquare(g);
			new Point(upLeft.getX()+width, upLeft.getY()+height).drawSquare(g);
			new Point(upLeft.getX()+width/2, upLeft.getY()).drawSquare(g);
			new Point(upLeft.getX()+width/2, upLeft.getY()+height).drawSquare(g);
			new Point(upLeft.getX(), upLeft.getY()+height/2).drawSquare(g);
			new Point(upLeft.getX()+width, upLeft.getY()+height/2).drawSquare(g);
		}
	}

}
