package paintmvc.maintest;

import java.awt.Graphics;

import paintmvc.geometry.Line;
import paintmvc.geometry.Point;
import paintmvc.mvc.controller.PaintController;
import paintmvc.mvc.model.PaintModel;
import paintmvc.mvc.view.PaintView;
import paintmvc.mvc.view.PaintFrame;

public class MainTest {

	public static void main(String[] args) {
		PaintModel model = new PaintModel();
		PaintView view = new PaintView(model);
		PaintFrame frame = new PaintFrame(view);
		frame.setLocationRelativeTo(null);
		PaintController controller = new PaintController(view, model, frame);
		frame.setVisible(true);
	}

}
