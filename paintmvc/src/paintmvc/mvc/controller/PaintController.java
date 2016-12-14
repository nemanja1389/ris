package paintmvc.mvc.controller;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import paintmvc.geometry.Shape;
import paintmvc.mvc.model.PaintModel;
import paintmvc.mvc.view.PaintView;
import paintmvc.mvc.view.PaintFrame;
import paintmvc.mvc.view.TestDialog;

public class PaintController {

	private PaintModel model;
	private PaintView view;
	private PaintFrame frame;


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
		this.view.addMotionMouseListen(new MouseMotionAdapterPanelPaint(this.frame.getTextArea()));
		this.view.addMouseListen(new MouseAdapterPanelPaint(this.frame.getTextArea(), this.model, this.frame));
		this.frame.addButtonClick(new ActionListenerClikcDelete(this.model));
	}
}
