package paintmvc.geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Square {
	
	private int height;

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Rectangle(Point upLeft, int width, int height) {
		super(upLeft, width);
		this.height=height;
	}
	
	public Rectangle(Point upLeft, int width, int height, Color lineColor, Color internalColor){
		super(upLeft, width, lineColor, internalColor);
		this.height=height;
	}
	
	public Rectangle(Point upLeft, int width, int height, boolean selected, Color lineColor, Color internalColor){
		super(upLeft, width, selected, lineColor, internalColor);
		this.height=height;
	}
	
	@Override
	public String toString(){
		return "gronji levi ugao=" + getUpLeft().toString() + ", sirina=" + getWidth() + ", visina=" + height;
	}
	
	@Override
	public boolean equals(Object o){
		if (o instanceof Rectangle){
			Rectangle rectangle = (Rectangle)o;
			if (getUpLeft().equals(rectangle.getUpLeft()) 
			    && getWidth() == rectangle.getWidth()){
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
		g.fillRect(getUpLeft().getX(), getUpLeft().getY(), getWidth(), height);
	}

	@Override
	public double surfaceArea() {
		return getWidth()*height;
	}

	@Override
	public double volume() {
		return 2*getWidth()+height*2;
	}

	@Override
	public boolean contains(int x, int y) {
		if(this.getUpLeft().getX()<=x 
				&& x<=(this.getUpLeft().getX() + getWidth())
				&& this.getUpLeft().getY()<=y 
				&& y<=(this.getUpLeft().getY() + height)){
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void draw(Graphics g) {
		fillInternal(g);
		g.setColor(getLineColor());
		g.drawRect(getUpLeft().getX(), getUpLeft().getY(), getWidth(), height);
		if(isSelected()){
			getUpLeft().drawSquare(g);
			new Point(getUpLeft().getX()+getWidth(), getUpLeft().getY()).drawSquare(g);
			new Point(getUpLeft().getX(), getUpLeft().getY()+height).drawSquare(g);
			new Point(getUpLeft().getX()+getWidth(), getUpLeft().getY()+height).drawSquare(g);
			new Point(getUpLeft().getX()+getWidth()/2, getUpLeft().getY()).drawSquare(g);
			new Point(getUpLeft().getX()+getWidth()/2, getUpLeft().getY()+height).drawSquare(g);
			new Point(getUpLeft().getX(), getUpLeft().getY()+height/2).drawSquare(g);
			new Point(getUpLeft().getX()+getWidth(), getUpLeft().getY()+height/2).drawSquare(g);
			
		}
	}

}
