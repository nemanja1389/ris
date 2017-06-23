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
	 * @param startPoint poèetna taèka linije
	 * @param endPoint krajnja taèka linije
	 */
	public Line(Point startPoint, Point endPoint){
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	/**
	 * Konstruktor koji prihvata tri parametra
	 * @param startPoint poèetna taèka linije
	 * @param endPoint krajnja taèka linije
	 * @param lineColor boja linije
	 */
	public Line(Point startPoint, Point endPoint, Color lineColor){
		this.lineColor = lineColor;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	/**
	 * Konstruktor koji prihvata èetri parametra
	 * @param startPoint poèetna taèka linije
	 * @param endPoint krajnja taèka linije
	 * @param selected selektovana linija (true or false)
	 * @param lineColor boja linije
	 */
	public Line(Point startPoint, Point endPoint, boolean selected, Color lineColor){
		super(selected, lineColor);
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	/**
	 * Metoda vraæa poèetnu taèku linije.
	 * @return startPoint
	 */
	public Point getStartPoint() {
		return startPoint;
	}

	/**
	 * Metoda postavlja poèetnu taèku linije.
	 * @param startPoint poèetna taèka linije
	 */
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	/**
	 * Metoad vraæa krajnju taèku linije.
	 * @return endPoint
	 */
	public Point getEndPoint() {
		return endPoint;
	}

	/**
	 * Metoda postavlja krajnju taèku linije.
	 * @param endPoint krajnja taèka linije
	 */
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	/**
	 * Metoda izraèunava dužinu linije.
	 * @return dužina linije
	 */
	public double length(){
		return startPoint.distance(endPoint);
	}
	
	/**
	 * Metoda odreðuje srednju taèku linije.
	 * @return srednja taèka linije
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
	 * Metoda koja za prosleðeni objekat ispituje da li je objekat linija ili nije.
	 * @param o prosleðen objekat koji se ispituje
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
	 * Metoda proverava da li se prosleðene koordinate x i y pripadaju liniji.
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
