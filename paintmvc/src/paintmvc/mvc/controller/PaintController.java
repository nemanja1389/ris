package paintmvc.mvc.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import paintmvc.geometry.Line;
import paintmvc.geometry.Point;
import paintmvc.geometry.Shape;
import paintmvc.mvc.model.PaintModel;
import paintmvc.mvc.view.PaintView;
import paintmvc.mvc.view.PaintFrame;
import paintmvc.mvc.view.TestDialog;

public class PaintController {

	private PaintModel model = new PaintModel();
	private PaintView view = new PaintView(model);
	private PaintFrame frame = new PaintFrame(view);
	int mouseClicked = 0;
	Point startPoint;


	public PaintView getView() {
		return view;
	}

	public void setView(PaintView view) {
		this.view = view;
	}

	public PaintModel getModel() {
		return model;
	}

	public void setModel(PaintModel model) {
		this.model = model;
	}

	public PaintController(PaintView view, PaintModel model, PaintFrame frame) {
		this.model = model;
		this.view = view;
		this.frame = frame;
		this.view.addMotionMouseListen(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				frame.getTextArea().setText("X: " + e.getX() + "   Y: " + e.getY());
			}
		});
		this.view.addMouseListen(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				frame.getTextArea().setText("");
			}
			
			@Override
			public void mouseClicked(MouseEvent e){
				if(frame.getTglbtnPoint().isSelected()){
					model.getShape().add(new Point(e.getX(), e.getY(), Color.BLACK));
				} else if(frame.getTglbtnLine().isSelected()){
					if(mouseClicked%2 == 0){
						startPoint = new Point(e.getX(), e.getY(), Color.BLACK);
						mouseClicked++;
					} else {
						model.getShape().add(new Line(startPoint, new Point(e.getX(), e.getY(), Color.BLACK), Color.BLACK));
						mouseClicked = 0;
					}
				} else if(frame.getTglbtnSelect().isSelected()){
					Iterator it = model.getShape().iterator();
					ArrayList select = new ArrayList<>();
					Shape s1 = null;
					while(it.hasNext()){
						Shape s = (Shape)it.next();
						s.setSelected(false);
						if(s.contains(e.getX(), e.getY())){
							select.add(s);
							s1=s;
						}
					}
					if(s1 != null){
						s1.setSelected(true);
					}
				}
			}
		});
	}

}
