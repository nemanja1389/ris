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

public class PaintView extends JPanel {
	
	PaintModel model;

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
