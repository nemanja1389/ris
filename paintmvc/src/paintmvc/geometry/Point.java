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
	
	
	public Point(int x, int y, Color lineColor){
		super(lineColor);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Konstruktor koji prihvata sledece prosledjene parametre:
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
	 * Konstuktor koji prihvata sledece prosledjene parametre:
	 * @param x
	 * @param y
	 */
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Metoda pristupa getX()
	 * @return
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Metoda pristupa setX()
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * Metoda pristupa getY()
	 * @return 
	 */
	public int getY() {
		return y;
	}

	/**
	 * Metoda pristupa setY()
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Metoda koja prihvata sledeci parametar:
	 * @param point
	 * vraca udaljenost izmedju dve tacke
	 * @return
	 */
	public double distance(Point point) {
		return Math.sqrt(((point.x - this.x)*(point.x - this.x))+((point.y - this.y)*(point.y - this.y)));
	}
	
	/**
	 * Metoda koja prihvata sledeci parametar:
	 * @param g
	 * i iscrtava plave kvadratice ukoliko je objekat selektovan
	 */
	public void drawSquare(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(this.getX()-2, this.getY()-2, 5, 5);
	}
	
	@Override
	public String toString(){
		return "(" + x + "," + y + ")";
	}
	
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

	@Override
	public boolean contains(int x, int y) {
		if(new Point(this.x, this.y).distance(new Point(x,y)) <= 3){
			return true;
		} else {
			return false;
		}
	}

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
