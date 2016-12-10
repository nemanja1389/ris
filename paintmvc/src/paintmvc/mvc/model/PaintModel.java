package paintmvc.mvc.model;

import java.awt.Graphics;
import java.awt.Shape;
import java.util.ArrayList;
import java.util.Iterator;

import paintmvc.geometry.Point;

public class PaintModel {
	
	private ArrayList shape = new ArrayList();

	public ArrayList getShape() {
		return shape;
	}

	public void setShape(ArrayList shape) {
		this.shape = shape;
	}
}
