package paintmvc.geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class SurfaceShape extends Shape {
	
	protected Color internalColor;
	
	public SurfaceShape(){}
	
	public SurfaceShape(Color lineColor, Color internalColor){
		super(lineColor);
		this.internalColor=internalColor;
	}
	
	public SurfaceShape(boolean selected, Color lineColor, Color internalColor){
		super(selected, lineColor);
		this.internalColor = internalColor;
	}
	
	public Color getInternalColor() {
		return internalColor;
	}
	
	public void setInternalColor(Color internalColor) {
		this.internalColor = internalColor;
	}
	
	public abstract void fillInternal(Graphics g);
	
	public abstract double surfaceArea();
	
	public abstract double volume();

}
