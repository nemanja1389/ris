package paintmvc.mvc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JOptionPane;

import paintmvc.geometry.Shape;
import paintmvc.mvc.model.PaintModel;

public class ActionListenerClikcDelete implements ActionListener {
	
	private PaintModel model;
	
	public ActionListenerClikcDelete(PaintModel model){
		this.model = model;
	}

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

}
