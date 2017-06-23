package paintmvc.geometry;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Nemanja
 * @version 1.0
 */
public class Square extends SurfaceShape {
	
	protected Point upLeft;
	protected int width;
	
	/**
	 * Prazan konstruktor.
	 */
	public Square(){}
	
	
	/**
	 * Konstruktor koji prihvata dva parametra.
	 * @param upLeft ta�ka gornjeg levo ugla kvadrata
	 * @param width �irina kvadrata
	 */
	public Square (Point upLeft, int width){
		this.upLeft=upLeft;
		this.width=width;
	}
	
	/**
	 * Konstruktor koji prihvata �etri parametra.
	 * @param upLeft ta�ka gornjeg levo ugla kvadrata
	 * @param width �irina kvadrata
	 * @param lineColor boja linije kvadrata
	 * @param areaColor boja povr�ine kvadrata
	 */
	public Square (Point upLeft, int width, Color lineColor, Color areaColor){
		super(lineColor, areaColor);
		this.upLeft=upLeft;
		this.width=width;
	}
	
	/**
	 * Konstruktor koji prihvata pet parametara.
	 * @param upLeft ta�ka gornjeg levo ugla kvadrata
	 * @param width �irina kvadrata
	 * @param selected selektovan kvadrat (true or false)
	 * @param lineColor boja linije kvadrata
	 * @param areaColor boja povr�ine kvadrata
	 */
	public Square (Point upLeft, int width, boolean selected, Color lineColor, Color internalColor){
		super(selected, lineColor, internalColor);
		this.upLeft=upLeft;
		this.width=width;
	}

	/**
	 * Get metoda vra�a ta�ku gornjeg levog ugla kvadrata.
	 * @return upLeft
	 */
	public Point getUpLeft() {
		return upLeft;
	}

	/**
	 * Set metoda postavlja ta�ku za gornji levi ugao kvadrata.
	 * @param upLeft ta�ka gornjeg levog ugla kvadrata
	 */
	public void setUpLeft(Point upLeft) {
		this.upLeft = upLeft;
	}

	/**
	 * Get metoda vra�a �irinu kvadrata.
	 * @return width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Set metoda postavlja �irinu kvadrata.
	 * @param width �irina kvadrata
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Preklopljena metoda koja ispisuje informacije o kvadratu.
	 */
	@Override
	public String toString(){
		return "Square: " + "Up left point: " + "x: " + upLeft.getX() + ", y: " + upLeft.getY() + "; Width: " + width
				+ "; Line color: " + "R: " + getLineColor().getRed() + ", " + "G: " + getLineColor().getGreen() + ", " + "B: " + getLineColor().getBlue()
				+ "; Area color: " + "R: " + getInternalColor().getRed() + ", " + "G: " + getInternalColor().getGreen() + ", " + "B: " + getInternalColor().getBlue();
	}
	
	
	/**
	 * Metoda koja za prosle�eni objekat ispituje da li je objekat kvadrat ili nije.
	 * @param o prosle�en objekat koji se ispituje
	 * @return true or false
	 */
	@Override
	public boolean equals(Object o){
		if (o instanceof Square){
			Square square = (Square)o;
			if (upLeft.equals(square.getUpLeft()) 
			    && width == square.getWidth()){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Metoda boji povr�inu kvadrata.
	 * @param g grafika
	 */
	@Override
	public void fillArea(Graphics g) {
		g.setColor(getInternalColor());
		g.fillRect(upLeft.getX(), upLeft.getY(), width, width);
	}

	/**
	 * Metoda izra�unava povr�inu kvadrata.
	 * @return povr�ina kvadrata
	 */
	@Override
	public double surfaceArea() {
		return width*width;
	}
	
	/**
	 * Metoda izra�unava obim kvadrata.
	 * @return obim kvadrata
	 */
	@Override
	public double volume() {
		return width*4;
	}

	/**
	 * Metoda proverava da li se prosle�ene koordinate x i y pripadaju kvadratu.
	 * @param x koordinata x
	 * @param y koordinata y
	 * @return true or false
	 */
	@Override
	public boolean contains(int x, int y) {
		if(this.getUpLeft().getX()<=x 
				&& x<=(this.getUpLeft().getX() + width)
				&& this.getUpLeft().getY()<=y 
				&& y<=(this.getUpLeft().getY() + width)){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metoda koja crta kvadrat.
	 * @param g grafika
	 */
	@Override
	public void draw(Graphics g) {
		fillArea(g);
		g.setColor(getLineColor());
		g.drawRect(upLeft.getX(), upLeft.getY(), width, width);
		if(isSelected()){
			upLeft.drawSquare(g);
			new Point(upLeft.getX()+width, upLeft.getY()).drawSquare(g);
			new Point(upLeft.getX(), upLeft.getY()+width).drawSquare(g);
			new Point(upLeft.getX()+width, upLeft.getY()+width).drawSquare(g);
			new Point(upLeft.getX()+width/2, upLeft.getY()).drawSquare(g);
			new Point(upLeft.getX()+width/2, upLeft.getY()+width).drawSquare(g);
			new Point(upLeft.getX(), upLeft.getY()+width/2).drawSquare(g);
			new Point(upLeft.getX()+width, upLeft.getY()+width/2).drawSquare(g);
		}
	}

}
