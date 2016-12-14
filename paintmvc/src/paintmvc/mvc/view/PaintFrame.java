package paintmvc.mvc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class PaintFrame extends JFrame {

	private JPanel contentPane;
	private PaintView panel;
	private JToggleButton tglbtnPoint;
	private JToggleButton tglbtnLine;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JToggleButton tglbtnSelect;
	private JButton btnDelete;
	private JToggleButton tglbtnCircle;
	private JToggleButton tglbtnSquare;
	private JToggleButton tglbtnRectangle;
	private JToggleButton tglbtnModify;
	private JTextArea textArea;
	private JToggleButton tglbtnHexagon;
	

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JToggleButton getTglbtnSelect() {
		return tglbtnSelect;
	}

	public void setTglbtnSelect(JToggleButton tglbtnSelect) {
		this.tglbtnSelect = tglbtnSelect;
	}

	public PaintView getPanel() {
		return panel;
	}

	public void setPanel(PaintView panel) {
		this.panel = panel;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public JToggleButton getTglbtnPoint() {
		return tglbtnPoint;
	}

	public void setTglbtnPoint(JToggleButton tglbtnPoint) {
		this.tglbtnPoint = tglbtnPoint;
	}

	public JToggleButton getTglbtnLine() {
		return tglbtnLine;
	}

	public void setTglbtnLine(JToggleButton tglbtnLine) {
		this.tglbtnLine = tglbtnLine;
	}
	
	public JToggleButton getTglbtnCircle() {
		return tglbtnCircle;
	}

	public void setTglbtnCircle(JToggleButton tglbtnCircle) {
		this.tglbtnCircle = tglbtnCircle;
	}
	
	public JToggleButton getTglbtnSquare() {
		return tglbtnSquare;
	}

	public void setTglbtnSquare(JToggleButton tglbtnSquare) {
		this.tglbtnSquare = tglbtnSquare;
	}
	
	public JToggleButton getTglbtnRectangle() {
		return tglbtnRectangle;
	}

	public void setTglbtnRectangle(JToggleButton tglbtnRectangle) {
		this.tglbtnRectangle = tglbtnRectangle;
	}
	
	public JToggleButton getTglbtnHexagon() {
		return tglbtnHexagon;
	}

	public void setTglbtnHexagon(JToggleButton tglbtnHexagon) {
		this.tglbtnHexagon = tglbtnHexagon;
	}

	
	public JToggleButton getTglbtnModify() {
		return tglbtnModify;
	}

	public void setTglbtnModify(JToggleButton tglbtnModify) {
		this.tglbtnModify = tglbtnModify;
	}

	/**
	 * Create the frame.
	 */
	public PaintFrame(PaintView panel) {
		this.panel = panel;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlTool = new JPanel();
		contentPane.add(pnlTool, BorderLayout.NORTH);
		pnlTool.setLayout(new BoxLayout(pnlTool, BoxLayout.X_AXIS));
		
		tglbtnPoint = new JToggleButton("Point");
		buttonGroup.add(tglbtnPoint);
		pnlTool.add(tglbtnPoint);
		
		tglbtnLine = new JToggleButton("Line");
		buttonGroup.add(tglbtnLine);
		pnlTool.add(tglbtnLine);
		
		tglbtnCircle = new JToggleButton("Circle");
		buttonGroup.add(tglbtnCircle);
		pnlTool.add(tglbtnCircle);
		
		tglbtnSquare = new JToggleButton("Square");
		buttonGroup.add(tglbtnSquare);
		pnlTool.add(tglbtnSquare);
		
		tglbtnRectangle = new JToggleButton("Rectangle");
		buttonGroup.add(tglbtnRectangle);
		pnlTool.add(tglbtnRectangle);
		
		tglbtnHexagon = new JToggleButton("Hexagon");
		buttonGroup.add(tglbtnHexagon);
		pnlTool.add(tglbtnHexagon);
		
		tglbtnSelect = new JToggleButton("Select");
		buttonGroup.add(tglbtnSelect);
		pnlTool.add(tglbtnSelect);
		
		btnDelete = new JButton("Delete");
		pnlTool.add(btnDelete);
		
		tglbtnModify = new JToggleButton("Modify");
		buttonGroup.add(tglbtnModify);
		pnlTool.add(tglbtnModify);
		
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel pnlXy = new JPanel();
		contentPane.add(pnlXy, BorderLayout.SOUTH);
		pnlXy.setLayout(new BoxLayout(pnlXy, BoxLayout.X_AXIS));
		
		textArea = new JTextArea();
		textArea.setBackground(SystemColor.control);
		pnlXy.add(textArea);
	}
	
	public void addButtonClick(ActionListener listenForClick){
		btnDelete.addActionListener(listenForClick);
	}

}
