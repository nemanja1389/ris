package paintmvc.geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Square extends SurfaceShape {
	
	protected Point upLeft;
	protected int width;
	
	public Square(){}
	
	public Square (Point upLeft, int width){
		this.upLeft=upLeft;
		this.width=width;
	}
	
	public Square (Point upLeft, int width, Color lineColor, Color areaColor){
		super(lineColor, areaColor);
		this.upLeft=upLeft;
		this.width=width;
	}
	
	public Square (Point upLeft, int width, boolean selected, Color lineColor, Color internalColor){
		super(selected, lineColor, internalColor);
		this.upLeft=upLeft;
		this.width=width;
	}

	public Point getUpLeft() {
		return upLeft;
	}

	public void setUpLeft(Point upLeft) {
		this.upLeft = upLeft;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int a) {
		this.width = a;
	}
	
	@Override
	public String toString(){
		return "Square: " + "Up left point: " + "x: " + upLeft.getX() + ", y: " + upLeft.getY() + "; Width: " + width
				+ "; Line color: " + "R: " + getLineColor().getRed() + ", " + "G: " + getLineColor().getGreen() + ", " + "B: " + getLineColor().getBlue()
				+ "; Area color: " + "R: " + getInternalColor().getRed() + ", " + "G: " + getInternalColor().getGreen() + ", " + "B: " + getInternalColor().getBlue();
	}
	
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

	@Override
	public void fillArea(Graphics g) {
		g.setColor(getInternalColor());
		g.fillRect(upLeft.getX(), upLeft.getY(), width, width);
	}

	@Override
	public double surfaceArea() {
		return width*width;
	}

	@Override
	public double volume() {
		return width*4;
	}

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
