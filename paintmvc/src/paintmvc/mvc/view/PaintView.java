package paintmvc.mvc.view;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import paintmvc.geometry.Shape;
import paintmvc.mvc.model.PaintModel;
import java.awt.event.MouseEvent;

public class PaintView extends JPanel {
	
	PaintModel model;
	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public PaintView(PaintModel model){
		this.model = model;
	}

	public void addMotionMouseListen(MouseMotionAdapter mouseListen){
		this.addMouseMotionListener(mouseListen);
	}
	
	public void addMouseListen(MouseAdapter mouseListen){
		this.addMouseListener(mouseListen);
	}
	
	public void paint(Graphics g) {
		super.paint(g);

		Iterator it = model.getShape().iterator();
		while(it.hasNext()){
			Shape s = (Shape)it.next();
			s.draw(g);
		}
		
		repaint();
		this.grabFocus();
	}
}
