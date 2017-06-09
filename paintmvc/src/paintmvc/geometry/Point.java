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
	 * @param x
	 * @param y
	 */
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Konsturktor koji prihvata tri parametra
	 * @param x
	 * @param y
	 * @param lineColor
	 */
	public Point(int x, int y, Color lineColor){
		super(lineColor);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Konstruktor koji prihvata cetri parametra
	 * @param x
	 * @param y
	 * @param selected
	 * @param lineColor
	 */
	public Point(int x, int y, boolean selected, Color lineColor) {
		super(selected, lineColor);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Metoda getX()
	 * @return
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Metoda setX()
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Metoda getY()
	 * @return 
	 */
	public int getY() {
		return y;
	}

	/**
	 * Metoda setY()
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Metoda koja proverava udaljenost izmedju dve tacke
	 * @param point
	 * @return
	 */
	public double distance(Point point) {
		return Math.sqrt(((point.x - this.x)*(point.x - this.x))+((point.y - this.y)*(point.y - this.y)));
	}
	
	/**
	 * Metoda koja iscrtava plave kvadratice
	 * @param g
	 */
	public void drawSquare(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(this.getX()-2, this.getY()-2, 5, 5);
	}
	
	/**
	 * Metoda koja ispisuje vrednosti x i y date tacke
	 */
	@Override
	public String toString(){
		return "Point: " + "x: " + x + ", " + "y: " + y + "; Color: " + "R: " + getLineColor().getRed() + ", " + "G: " + getLineColor().getGreen() + ", " + "B: " + getLineColor().getBlue();
	}
	
	/**
	 * Metoda koja za prosledjeni oblik proverava da li su ti oblici jednaki ili nisu
	 * @param o
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
	 * Metoda koja proverava da li tacka sadrzi x i y vrednosti
	 * @param x
	 * @param y
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
	 * Metoda za crtanje tacke
	 * @param g
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
