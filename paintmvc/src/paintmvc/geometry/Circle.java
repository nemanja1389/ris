package paintmvc.geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends SurfaceShape {

	private Point centerCircle;
	private int radius;
	
	public Circle(Point centerCircle, int radius){
		this.centerCircle = centerCircle;
		this.radius = radius;
	}
	
	public Circle(Point centerCircle, int radius, Color lineColor, Color internalColor){
		super(lineColor, internalColor);
		this.centerCircle=centerCircle;
		this.radius=radius;
	}
	
	public Circle(Point centerCircle, int radisu, boolean selected, Color lineColor, Color internalColor){
		super(selected, lineColor, internalColor);
		this.centerCircle = centerCircle;
		this.radius = radisu;
	}
	
	public Point getCenterCircle() {
		return centerCircle;
	}

	public void setCenterCircle(Point centerCircle) {
		this.centerCircle = centerCircle;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public String toString(){
		return "centar=" + centerCircle.toString() + ", radius=" + radius + ", boja: " + getLineColor();
	}
	
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
	
	@Override
	public void fillInternal(Graphics g) {
		g.setColor(getInternalColor());
		g.fillOval(centerCircle.getX()-radius, centerCircle.getY()-radius, 2*radius, 2*radius);
	}

	@Override
	public double surfaceArea() {
		return radius*radius*Math.PI;
	}

	@Override
	public double volume() {
		return 2*radius*Math.PI;
	}

	@Override
	public boolean contains(int x, int y) {
		if(new Point(x,y).distance(centerCircle) <= radius){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void draw(Graphics g) {
		fillInternal(g);
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
