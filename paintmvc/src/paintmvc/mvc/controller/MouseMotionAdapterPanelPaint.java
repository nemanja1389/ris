package paintmvc.mvc.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JTextArea;

public class MouseMotionAdapterPanelPaint extends MouseMotionAdapter {
	
	private JTextArea txtAreaCord;

	public MouseMotionAdapterPanelPaint(JTextArea txtAreaCord) {
		this.txtAreaCord = txtAreaCord;
	}
	
	@Override
	public void mouseMoved(MouseEvent e){
		this.txtAreaCord.setText("X: " + e.getX() + "   Y: " + e.getY());
	}

}
