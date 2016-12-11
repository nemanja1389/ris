package paintmvc.mvc.controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JColorChooser;
import javax.swing.JTextArea;

import paintmvc.dialogs.DialogCircle;
import paintmvc.dialogs.DialogLine;
import paintmvc.dialogs.DialogPoint;
import paintmvc.dialogs.DialogRectangle;
import paintmvc.dialogs.DialogSquare;
import paintmvc.geometry.Circle;
import paintmvc.geometry.Line;
import paintmvc.geometry.Point;
import paintmvc.geometry.Shape;
import paintmvc.geometry.Square;
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
	public void mouseClicked(MouseEvent e) {
		if (frame.getTglbtnPoint().isSelected()) {
			colorLine = JColorChooser.showDialog(frame, "Izaberi boju", Color.BLACK);
			if (colorLine == null) {
				colorLine = Color.BLACK;
			}
			Point p = new Point(e.getX(), e.getY(), colorLine);
			model.getShape().add(p);
		} else if (frame.getTglbtnLine().isSelected()) {
			if (mouseClicked % 2 == 0) {
				colorLine = JColorChooser.showDialog(frame, "Izaberi boju", Color.BLACK);
				if (colorLine == null) {
					colorLine = Color.BLACK;
				}
				startPoint = new Point(e.getX(), e.getY(), colorLine);
				mouseClicked++;
			} else {
				Line l = new Line(startPoint, new Point(e.getX(), e.getY(), colorLine), colorLine);
				model.getShape().add(l);
				mouseClicked = 0;
			}
		} else if (frame.getTglbtnSelect().isSelected()) {
			Iterator it = model.getShape().iterator();
			ArrayList select = new ArrayList<>();
			Shape s1 = null;
			while (it.hasNext()) {
				Shape s = (Shape) it.next();
				s.setSelected(false);
				if (s.contains(e.getX(), e.getY())) {
					select.add(s);
					s1 = s;
				}
			}
			if (s1 != null) {
				s1.setSelected(true);
			}
		} else if (frame.getTglbtnCircle().isSelected()) {
			DialogCircle dialog = new DialogCircle();
			dialog.setLocationRelativeTo(null);
			dialog.getTxtXCrd().setEditable(false);
			dialog.getTxtYCrd().setEditable(false);
			dialog.getTxtXCrd().setText(String.valueOf(e.getX()));
			dialog.getTxtYCrd().setText(String.valueOf(e.getY()));
			dialog.setVisible(true);
			try {
				model.getShape().add(new Circle(new Point(e.getX(), e.getY(), dialog.getInternalColor()), Integer.parseInt(dialog.getTxtRadius().getText()), dialog.getLineColor(), dialog.getInternalColor() ));
			} catch (Exception e2) {
				// TODO: handle exception
			}
		} else if (frame.getTglbtnSquare().isSelected()){
			DialogSquare dialog = new DialogSquare();
			dialog.setLocationRelativeTo(null);
			dialog.getTxtXCrd().setEditable(false);
			dialog.getTxtYCrd().setEditable(false);
			dialog.getTxtXCrd().setText(String.valueOf(e.getX()));
			dialog.getTxtYCrd().setText(String.valueOf(e.getY()));
			dialog.setVisible(true);
			try {
				model.getShape().add(new Square(new Point(e.getX(), e.getY(), dialog.getInternalColor()), Integer.parseInt(dialog.getTxtWidth().getText()), dialog.getLineColor(), dialog.getInternalColor()));
			} catch (Exception e2) {
				// TODO: handle exception
			}
		} else if (frame.getTglbtnRectangle().isSelected()){
			DialogRectangle dialog = new DialogRectangle();
			dialog.setLocationRelativeTo(null);
			dialog.getTxtXCrd().setEditable(false);
			dialog.getTxtYCrd().setEditable(false);
			dialog.getTxtXCrd().setText(String.valueOf(e.getX()));
			dialog.getTxtYCrd().setText(String.valueOf(e.getY()));
			dialog.setVisible(true);
			try {
				model.getShape().add(new paintmvc.geometry.Rectangle(new Point(e.getX(), e.getY(), dialog.getLineColor()), Integer.parseInt(dialog.getTxtWidth().getText()), Integer.parseInt(dialog.getTxtHeight().getText()), dialog.getLineColor(), dialog.getInternalColor()));
			} catch (Exception e2) {
				// TODO: handle exception
			}
		} else if (frame.getTglbtnModify().isSelected()){
			Iterator it = model.getShape().iterator();
			while (it.hasNext()) {
				Shape s = (Shape) it.next();
				if (s.contains(e.getX(), e.getY())) {
					if(s instanceof Point){
						DialogPoint dialog = new DialogPoint((Point)s);
						dialog.setLocationRelativeTo(null);
						dialog.getTxtXCrd().setText(String.valueOf(((Point) s).getX()));
						dialog.getTxtYCrd().setText(String.valueOf(((Point) s).getY()));
						dialog.getBtnColor().setBackground(s.getLineColor());
						dialog.setVisible(true);
						((Point) s).setX(Integer.parseInt(dialog.getTxtXCrd().getText()));
						((Point) s).setY(Integer.parseInt(dialog.getTxtYCrd().getText()));
						s.setLineColor(dialog.getLineColor());
					} else if(s instanceof Line){
						DialogLine dialog = new DialogLine((Line)s);
						dialog.setLocationRelativeTo(null);
						dialog.getTxtStartX().setText(String.valueOf(((Line) s).getStartPoint().getX()));
						dialog.getTxtStartY().setText(String.valueOf(((Line) s).getStartPoint().getY()));
						dialog.getTxtEndX().setText(String.valueOf(((Line) s).getEndPoint().getX()));
						dialog.getTxtEndY().setText(String.valueOf(((Line) s).getEndPoint().getY()));
						dialog.getBtnColor().setBackground(s.getLineColor());
						dialog.setVisible(true);
						((Line) s).getStartPoint().setX(Integer.parseInt(dialog.getTxtStartX().getText()));
						((Line) s).getStartPoint().setY(Integer.parseInt(dialog.getTxtStartY().getText()));
						((Line) s).getEndPoint().setX(Integer.parseInt(dialog.getTxtEndX().getText()));
						((Line) s).getEndPoint().setY(Integer.parseInt(dialog.getTxtEndY().getText()));
						s.setLineColor(dialog.getLineColor());
					}
				}
			}
		}
	}
}
