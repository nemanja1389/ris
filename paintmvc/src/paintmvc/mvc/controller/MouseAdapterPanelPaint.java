package paintmvc.mvc.controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JColorChooser;
import javax.swing.JTextArea;

import paintmvc.geometry.Line;
import paintmvc.geometry.Point;
import paintmvc.geometry.Shape;
import paintmvc.mvc.model.PaintModel;
import paintmvc.mvc.view.PaintFrame;
import paintmvc.mvc.view.TestDialog;

public class MouseAdapterPanelPaint extends MouseAdapter {

	private JTextArea txtArea;
	PaintModel model;
	PaintFrame frame;
	int mouseClicked = 0;
	Point startPoint;
	Color colorLine;
	
	public MouseAdapterPanelPaint(JTextArea txtAreaCord) {
		this.txtArea = txtAreaCord;
	}
	
	public MouseAdapterPanelPaint(JTextArea txtAreaCord, PaintModel model, PaintFrame frame) {
		this.txtArea = txtAreaCord;
		this.model = model;
		this.frame = frame;
	}
	
	
	@Override
	public void mouseExited(MouseEvent e) {
		this.txtArea.setText("");
	}
	
	@Override
	public void mouseClicked(MouseEvent e){
		if(frame.getTglbtnPoint().isSelected()){
			colorLine = JColorChooser.showDialog(frame, "Izaberi boju", Color.BLACK);
			if(colorLine == null){
				colorLine = Color.BLACK;
			}
			Point p = new Point(e.getX(), e.getY(), colorLine);
			model.getShape().add(p);
		} else if(frame.getTglbtnLine().isSelected()){
			if(mouseClicked%2 == 0){
				colorLine = JColorChooser.showDialog(frame, "Izaberi boju", Color.BLACK);
				if(colorLine == null){
					colorLine = Color.BLACK;
				}
				startPoint = new Point(e.getX(), e.getY(), colorLine);
				mouseClicked++;
			} else {
				Line l = new Line(startPoint, new Point(e.getX(), e.getY(), colorLine), colorLine);
				model.getShape().add(l);
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
}
