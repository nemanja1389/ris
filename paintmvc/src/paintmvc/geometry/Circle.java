package paintmvc.geometry;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Nemanja
 * @version 1.0
 */
public class Circle extends SurfaceShape {

	private Point centerCircle;
	private int radius;
	
	/**
	 * Prazan konstruktor
	 */
	public Circle(){}
	
	/**
	 * Konstruktor koji prihvata dva parametra
	 * @param centerCircle centar kruga
	 * @param radius preènik kruga
	 */
	public Circle(Point centerCircle, int radius){
		this.centerCircle = centerCircle;
		this.radius = radius;
	}
	
	
	/**
	 * Konstruktor koji prihvata èetri parametra
	 * @param centerCircle centar kruga
	 * @param radius preènik kruga
	 * @param lineColor boja linije kruga
	 * @param areaColor boja površine kruga
	 */
	public Circle(Point centerCircle, int radius, Color lineColor, Color areaColor){
		super(lineColor, areaColor);
		this.centerCircle = centerCircle;
		this.radius = radius;
	}
	
	/**
	 * Konstruktor koji prihvata pet parametara
	 * @param centerCircle centar kruga
	 * @param radisu preènik kruga
	 * @param selected selektovan krug (true or false)
	 * @param lineColor boja linije kruga
	 * @param areaColor boja provršine kruga
	 */
	public Circle(Point centerCircle, int radisu, boolean selected, Color lineColor, Color areaColor){
		super(selected, lineColor, areaColor);
		this.centerCircle = centerCircle;
		this.radius = radisu;
	}
	
	/**
	 * Get metoda vraæa centar kruga
	 * @return centerCircle
	 */
	public Point getCenterCircle() {
		return centerCircle;
	}
	
	/**
	 * Set metoda postavlja centar kruga
	 * @param centerCircle centar kruga
	 */
	public void setCenterCircle(Point centerCircle) {
		this.centerCircle = centerCircle;
	}

	/**
	 * Get metoda vraæa preènik kruga
	 * @return radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * Set metoda postavlja preènik kruga
	 * @param radius preènik kruga
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}

	/**
	 * Preklopljena metoda koja ispisuje informacije o krugu.
	 */
	@Override
	public String toString(){
		return "Circle: " + "Center point: " + "x: " + centerCircle.getX() + ", y: " + centerCircle.getY() + "; Radius: " + radius
				+ "; Line color: " + "R: " + getLineColor().getRed() + ", " + "G: " + getLineColor().getGreen() + ", " + "B: " + getLineColor().getBlue()
				+ "; Area color: " + "R: " + getInternalColor().getRed() + ", " + "G: " + getInternalColor().getGreen() + ", " + "B: " + getInternalColor().getBlue();
	}
	
	/**
	 * Metoda koja za prosleðeni objekat ispituje da li je objekat krug ili nije.
	 * @param o prosleðen objekat koji se ispituje
	 * @return true or false
	 */
	@Override
	public boolean equals(Object o){
		if (o instanceof Circle){
			Circle circle = (Circle)o;
			if (centerCircle.equals(circle.getCenterCircle()) 
			    && radius == circle.getRadius()){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Metoda boji površinu kruga.
	 * @param g grafika
	 */
	@Override
	public void fillArea(Graphics g) {
		g.setColor(getInternalColor());
		g.fillOval(centerCircle.getX()-radius, centerCircle.getY()-radius, 2*radius, 2*radius);
	}

	/**
	 * Metoda izraèunava površinu kruga.
	 * @return površina kruga
	 */
	@Override
	public double surfaceArea() {
		return radius*radius*Math.PI;
	}

	/**
	 * Metoda izraèunava obim kruga.
	 * @return obim kruga
	 */
	@Override
	public double volume() {
		return 2*radius*Math.PI;
	}

	/**
	 * Metoda proverava da li se prosleðene koordinate x i y pripadaju krugu.
	 * @param x koordinata x
	 * @param y koordinata y
	 * @return true or false
	 */
	@Override
	public boolean contains(int x, int y) {
		if(new Point(x,y).distance(centerCircle) <= radius){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metoda koja crta krug.
	 * @param g grafika
	 */
	@Override
	public void draw(Graphics g) {
		fillArea(g);
		g.setColor(getLineColor());
		g.drawOval(centerCircle.getX()-radius, centerCircle.getY()-radius, 2*radius, 2*radius);
		if(isSelected()){
			new Point(centerCircle.getX(), centerCircle.getY()-radius).drawSquare(g);
			new Point(centerCircle.getX(), centerCircle.getY()+radius).drawSquare(g);
			new Point(centerCircle.getX()-radius, centerCircle.getY()).drawSquare(g);
			new Point(centerCircle.getX()+radius, centerCircle.getY()).drawSquare(g);
		}
	}

}
