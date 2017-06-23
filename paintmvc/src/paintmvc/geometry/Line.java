package paintmvc.geometry;

import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 * @author Nemanja
 * @version 1.0
 */

public class Line extends Shape {
	
	private Point startPoint;
	private Point endPoint;
	
	/**
	 * Prazan konstruktor
	 */
	public Line(){}
	
	/**
	 * Konstruktor koji prihvata dva parametra
	 * @param startPoint po�etna ta�ka linije
	 * @param endPoint krajnja ta�ka linije
	 */
	public Line(Point startPoint, Point endPoint){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	/**
	 * Konstruktor koji prihvata tri parametra
	 * @param startPoint po�etna ta�ka linije
	 * @param endPoint krajnja ta�ka linije
	 * @param lineColor boja linije
	 */
	public Line(Point startPoint, Point endPoint, Color lineColor){
		this.lineColor = lineColor;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	/**
	 * Konstruktor koji prihvata �etri parametra
	 * @param startPoint po�etna ta�ka linije
	 * @param endPoint krajnja ta�ka linije
	 * @param selected selektovana linija (true or false)
	 * @param lineColor boja linije
	 */
	public Line(Point startPoint, Point endPoint, boolean selected, Color lineColor){
		super(selected, lineColor);
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	/**
	 * Metoda vra�a po�etnu ta�ku linije.
	 * @return startPoint
	 */
	public Point getStartPoint() {
		return startPoint;
	}

	/**
	 * Metoda postavlja po�etnu ta�ku linije.
	 * @param startPoint po�etna ta�ka linije
	 */
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	/**
	 * Metoad vra�a krajnju ta�ku linije.
	 * @return endPoint
	 */
	public Point getEndPoint() {
		return endPoint;
	}

	/**
	 * Metoda postavlja krajnju ta�ku linije.
	 * @param endPoint krajnja ta�ka linije
	 */
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	/**
	 * Metoda izra�unava du�inu linije.
	 * @return du�ina linije
	 */
	public double length(){
		return startPoint.distance(endPoint);
	}
	
	/**
	 * Metoda odre�uje srednju ta�ku linije.
	 * @return srednja ta�ka linije
	 */
	public Point midfieldLine(){
		return new Point((startPoint.getX()+endPoint.getX())/2, (startPoint.getY()+endPoint.getY())/2);
	}
	
	/**
	 * Preklopljena metoda koja ispisuje informacije o liniji.
	 */
	@Override
	public String toString(){
		return "Line: Start point: " + "x: " + startPoint.getX() + ", y: " + startPoint.getY() +  "--> End point: "
	+ "x: " + endPoint.getX() + ", y: " + endPoint.getY()  
	+ "; Color: " + "R: " + getLineColor().getRed() + ", " + "G: " + getLineColor().getGreen() + ", " + "B: " + getLineColor().getBlue();
	}
	
	/**
	 * Metoda koja za prosle�eni objekat ispituje da li je objekat linija ili nije.
	 * @param o prosle�en objekat koji se ispituje
	 * @return true or false
	 */
	@Override
	public boolean equals(Object o){
		if (o instanceof Line){
			Line line = (Line)o;
			if (startPoint.equals(line.getStartPoint()) 
			    && endPoint.equals(line.getEndPoint())){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * Metoda proverava da li se prosle�ene koordinate x i y pripadaju liniji.
	 * @param x koordinata x
	 * @param y koordinata y
	 * @return true or false
	 */
	@Override
	public boolean contains(int x, int y) {
		if(new Point(x,y).distance(startPoint)+new Point(x,y).distance(endPoint)-this.length() <= 0.05){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metoda koja crta liniju.
	 * @param g grafika
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(getLineColor());
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if(isSelected()){
			startPoint.drawSquare(g);
			endPoint.drawSquare(g);
			midfieldLine().drawSquare(g);
		}
	}

}
