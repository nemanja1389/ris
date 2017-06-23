package paintmvc.geometry;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Nemanja
 * @version 1.0
 * 
 *
 */

public class Point extends Shape {
	
	private int x = 0;
	private int y = 0;
	
	/**
	 * Prazan konstruktor
	 */
	public Point(){}
	

	/**
	 * Konstuktor koji prihvata dva parametra
	 * @param x koordinata x
	 * @param y koordinata y
	 */
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Konsturktor koji prihvata tri parametra
	 * @param x koordinata x
	 * @param y koordinata y
	 * @param lineColor boja ta�ke
	 */
	public Point(int x, int y, Color lineColor){
		super(lineColor);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Konstruktor koji prihvata cetri parametra
	 * @param x koordinata x
	 * @param y koordinata y
	 * @param selected selektovana ta�ka (true or false)
	 * @param lineColor boja ta�ke
	 */
	public Point(int x, int y, boolean selected, Color lineColor) {
		super(selected, lineColor);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Get metoda vra�a x koordinatu ta�ke.
	 * @return x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Set metoda postavlja x koordinatu ta�ke.
	 * @param x koordinata x ta�ke
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Get metoda vra�a y koordinatu ta�ke.
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Set metoda postavlja y koordinatu ta�ke.
	 * @param y koordinata y ta�ke
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Metoda proverava udaljenost izmedju dve tacke
	 * @param point prosle�ena ta�ka do koje se meri udaljenost
	 * @return udaljenost izme�u dve ta�ke
	 */
	public double distance(Point point) {
		return Math.sqrt(((point.x - this.x)*(point.x - this.x))+((point.y - this.y)*(point.y - this.y)));
	}
	
	/**
	 * Metoda koja iscrtava plave kvadratice
	 * @param g grafika
	 */
	public void drawSquare(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(this.getX()-2, this.getY()-2, 5, 5);
	}
	
	/**
	 * Preklopljena metoda koja ispisuje informacije o ta�ki
	 */
	@Override
	public String toString(){
		return "Point: " + "x: " + x + ", " + "y: " + y + "; Color: " + "R: " + getLineColor().getRed() + ", " + "G: " + getLineColor().getGreen() + ", " + "B: " + getLineColor().getBlue();
	}
	
	/**
	 * Metoda koja za prosledjeni objekat da li je objekat ta�ka ili nije.
	 * @param o prosle�en objekat koji se ispituje
	 * @return true or false
	 */
	@Override
	public boolean equals(Object o) {
		if (o instanceof Point) {
			Point point = (Point)o;
			if (this.x == point.getX()
				&& this.y == point.getY()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	
	/**
	 * Metoda proverava da li se prosle�ene koordinate x i y pripadaju ta�ki.
	 * @param x koordinata x
	 * @param y koordinata y
	 * @return true or false
	 */
	@Override
	public boolean contains(int x, int y) {
		if(new Point(this.x, this.y).distance(new Point(x,y)) <= 3){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metoda koja crta ta�ku.
	 * @param g grafika
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(getLineColor());
		g.drawLine(x-1, y-1, x+1, y+1);
		g.drawLine(x-1, y+1, x+1, y-1);
		if(isSelected()) {
			this.drawSquare(g);
		}
	}
	
	

}
