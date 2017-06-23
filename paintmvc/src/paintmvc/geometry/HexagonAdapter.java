package paintmvc.geometry;

import java.awt.Color;
import java.awt.Graphics;

import ris.Hexagon;

public class HexagonAdapter extends SurfaceShape {
	
	private Hexagon hexagon = new Hexagon(0, 0, 0);
	
	public HexagonAdapter(){}
	
	public HexagonAdapter(int x, int y, int radius){
		hexagon.setX(x);
		hexagon.setY(y);
		hexagon.setR(radius);
	}
	
	public HexagonAdapter(int x, int y, int radius, Color lineColor, Color areaColor){
		this(x,y,radius);
		hexagon.setBorderColor(lineColor);
		hexagon.setAreaColor(areaColor);
	}
	
	public HexagonAdapter(int x, int y, int radius, Color lineColor, Color areaColor, boolean selected){
		this(x,y,radius,lineColor,areaColor);
		hexagon.setSelected(selected);
	}

	@Override
	public void fillArea(Graphics g) {
	}

	@Override
	public double surfaceArea() {
		return 0;
	}

	@Override
	public double volume() {
		return 0;
	}

	@Override
	public boolean contains(int x, int y) {
		return hexagon.doesContain(x, y);
	}

	@Override
	public void draw(Graphics g) {
		hexagon.paint(g);
	}

}
