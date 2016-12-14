package paintmvc.geometry;

import java.awt.Color;
import java.awt.Graphics;

import ris.Hexagon;

public class HexagonAdapter extends Shape {
	
	private Hexagon hexagon;

	public Hexagon getHexagon() {
		return hexagon;
	}

	public void setHexagon(Hexagon hexagon) {
		this.hexagon = hexagon;
	}
	
	public HexagonAdapter(int x, int y, int r){
		this.hexagon = new Hexagon(x, y, r);
	}
	
	public HexagonAdapter(int x, int y, int z, Color lineColor, Color areaColor){
		super(lineColor);
		this.hexagon = new Hexagon(x, y, z);
		hexagon.setAreaColor(areaColor);
	}
	
	public HexagonAdapter(int x, int y, int z, boolean selected, Color lineColor, Color areaColor) {
		super(selected, lineColor);
		this.hexagon = new Hexagon(x, y, z);
		hexagon.setAreaColor(areaColor);
	}

	@Override
	public boolean contains(int x, int y) {
		if(hexagon.doesContain(x, y)){
			return true;
		}else
			return false;
	}

	@Override
	public void draw(Graphics g) {
		hexagon.paint(g);
	}

}
