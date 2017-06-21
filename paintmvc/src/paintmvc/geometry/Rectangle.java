package paintmvc.geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Square {
	
	private int height;
	
	public Rectangle(){}
	
	public Rectangle(Point upLeft, int width, int height){
		super(upLeft, width);
		this.height = height;
	}
	
	public Rectangle(Point upLeft, int width, int height, Color lineColor, Color areaColor){
		super(upLeft, width, lineColor, areaColor);
		this.height = height;
	}
	
	public Rectangle(Point upLeft, int width, int height, boolean selected, Color lineColor, Color areaColor){
		super(upLeft, width, selected, lineColor, areaColor);
		this.height = height;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public String toString(){
		return "Rectangle: " + "Up left point: " + "x: " + upLeft.getX() + ", y: " + upLeft.getY() + "; Width: " + width + "; Height: " + height
				+ "; Line color: " + "R: " + getLineColor().getRed() + ", " + "G: " + getLineColor().getGreen() + ", " + "B: " + getLineColor().getBlue()
				+ "; Area color: " + "R: " + getInternalColor().getRed() + ", " + "G: " + getInternalColor().getGreen() + ", " + "B: " + getInternalColor().getBlue();
	}
	
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
	
	@Override
	public void fillArea(Graphics g){
		g.setColor(getInternalColor());
		g.fillRect(upLeft.getX(), upLeft.getY(), width, height);
	}
	
	@Override
	public double surfaceArea() {
		return width*height;
	}

	@Override
	public double volume() {
		return width*2 + height*2;
	}

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
