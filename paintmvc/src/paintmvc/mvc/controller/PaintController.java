package paintmvc.mvc.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import paintmvc.dialogs.CircleDialog;
import paintmvc.geometry.Circle;
import paintmvc.geometry.Line;
import paintmvc.geometry.Point;
import paintmvc.geometry.Shape;
import paintmvc.geometry.Square;
import paintmvc.mvc.model.PaintModel;
import paintmvc.mvc.view.PaintView;
import paintmvc.mvc.view.PaintFrame;
import paintmvc.mvc.view.TestDialog;

public class PaintController {

	private PaintModel model = new PaintModel();
	private PaintView view = new PaintView(model);
	private PaintFrame frame = new PaintFrame(view);
	int mouseDragged = 0;
	Point startPoint;
	private Color lineColor = Color.BLACK;
	private Color areaColor = Color.WHITE;


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
	}
	
	public void showInPaint(){

		this.view.addMotionMouseListen(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				frame.getTxtCoordinate().setText("X: " + e.getX() + "   Y: " + e.getY());
			}
		});
		this.view.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if(frame.getTglbtnCircle().isSelected()){
					if(mouseDragged == 0){
						model.getShape().add(new Circle(startPoint, (int)startPoint.distance(new Point(e.getX(), e.getY())), lineColor, areaColor));
						mouseDragged = 1;
					} else {
						model.getShape().remove(model.getShape().size()-1);
						model.getShape().add(new Circle(startPoint, (int)startPoint.distance(new Point(e.getX(), e.getY())), lineColor, areaColor));
					}
					
					
				}else if(frame.getTglbtnLine().isSelected()){
					if(mouseDragged == 0){
						model.getShape().add(new Line(startPoint, new Point(e.getX(), e.getY(), lineColor), lineColor));
						mouseDragged = 1;
					} else {
						model.getShape().remove(model.getShape().size()-1);
						model.getShape().add(new Line(startPoint, new Point(e.getX(), e.getY(), lineColor), lineColor));
					}
					
				}else if(frame.getTglBtnSquare().isSelected()){
					if(mouseDragged == 0){
						model.getShape().add(new Square(startPoint, (int)startPoint.distance(new Point(e.getX(), e.getY())), lineColor, areaColor));
						mouseDragged = 1;
					} else {
						model.getShape().remove(model.getShape().size()-1);
						model.getShape().add(new Square(startPoint, (int)startPoint.distance(new Point(e.getX(), e.getY())), lineColor, areaColor));
					}
				}
			}
		});
		this.view.addMouseListen(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				frame.getTxtCoordinate().setText("");
			}
			
			@Override
			public void mouseClicked(MouseEvent e){
				if(frame.getTglbtnPoint().isSelected()){
					model.getShape().add(new Point(e.getX(), e.getY(), lineColor));
					frame.getTxtArLog().append("Added: "+ new Point(e.getX(), e.getY(), lineColor).toString() + '\n');
					
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
			
			@Override
			public void mousePressed(MouseEvent e){
				
				if(frame.getTglbtnCircle().isSelected()){
					startPoint = new Point(e.getX(), e.getY(), lineColor);
				}else if(frame.getTglBtnSquare().isSelected()){
					startPoint = new Point(e.getX(), e.getY(), lineColor);
				}else if(frame.getTglbtnLine().isSelected()){
					startPoint = new Point(e.getX(), e.getY(), lineColor);
				}
			}
			
			@Override
			public void mouseReleased(MouseEvent e){
				if(frame.getTglbtnCircle().isSelected()){
					model.getShape().add(new Circle(startPoint, (int)startPoint.distance(new Point(e.getX(), e.getY())), lineColor, areaColor));
				}else if(frame.getTglBtnSquare().isSelected()){
					model.getShape().add(new Square(startPoint, (int)startPoint.distance(new Point(e.getX(), e.getY())), lineColor, areaColor));
					frame.getTxtArLog().append("Added: "+ new Square(startPoint, (int)startPoint.distance(new Point(e.getX(), e.getY())), lineColor, areaColor).toString() + '\n');
				}else if(frame.getTglbtnLine().isSelected()){
					model.getShape().add(new Line(startPoint, new Point(e.getX(), e.getY(), lineColor), lineColor));
					frame.getTxtArLog().append("Added: "+ new Line(startPoint, new Point(e.getX(), e.getY(), lineColor), lineColor).toString() + '\n');
				}
				
			}
		});
		
		this.frame.getBtnDelete().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Iterator it = model.getShape().iterator();
				while (it.hasNext()){
					Shape s = (Shape)it.next();
					if(s.isSelected()){						
						int poruka = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete oblik?", "Upozorenje!", JOptionPane.WARNING_MESSAGE);
						if (poruka == JOptionPane.OK_OPTION)
							it.remove();
					}
				}
			}
		});
		this.frame.getBtnLineColor().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				lineColor = JColorChooser.showDialog(null, "Izaberi boju", lineColor);
				if(lineColor != null){
					lineColor = lineColor;
					frame.getBtnLineColor().setBackground(lineColor);
				}
			}
		});
		
		this.frame.getBtnAreaColor().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				areaColor = JColorChooser.showDialog(null, "Izabveri boju", areaColor);
				if(areaColor != null){
					areaColor = areaColor;
					frame.getBtnAreaColor().setBackground(areaColor);
				}
			}
		});

	}

}
