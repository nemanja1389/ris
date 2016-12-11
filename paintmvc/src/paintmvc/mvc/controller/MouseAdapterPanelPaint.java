package paintmvc.mvc.controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JColorChooser;
import javax.swing.JTextArea;

import paintmvc.dialogs.DialogCircle;
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
		}
	}
}
