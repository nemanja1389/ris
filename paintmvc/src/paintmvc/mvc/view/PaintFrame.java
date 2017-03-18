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
import javax.swing.JColorChooser;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class PaintFrame extends JFrame {

	private JPanel contentPane;
	private PaintView panel;
	private JTextArea textArea;
	private JToggleButton tglbtnPoint;
	private JToggleButton tglbtnLine;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JToggleButton tglbtnSelect;
	private JButton btnDelete;
	private JButton btnLineColor;
	private Color lineColor = Color.BLACK;
	private Color areaColor = Color.WHITE;
	private JButton btnAreaColor;
	private JToggleButton tglbtnCircle;
	
	public JButton getBtnLineColor() {
		return btnLineColor;
	}

	public void setBtnLineColor(JButton btnLineColor) {
		this.btnLineColor = btnLineColor;
	}

	public JButton getBtnAreaColor() {
		return btnAreaColor;
	}

	public void setBtnAreaColor(JButton btnAreaColor) {
		this.btnAreaColor = btnAreaColor;
	}

	public JToggleButton getTglbtnCircle() {
		return tglbtnCircle;
	}

	public void setTglbtnCircle(JToggleButton tglbtnCircle) {
		this.tglbtnCircle = tglbtnCircle;
	}

	public Color getLineColor(){
		return lineColor;
	}
	
	public void setLineColor(Color lineColor){
		this.lineColor = lineColor;
	}
	
	public Color getAreaColor(){
		return areaColor;
	}
	
	public void setAreaColor(Color areaColor){
		this.areaColor = areaColor;
	}

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

	/**
	 * Create the frame.
	 */
	public PaintFrame(PaintView panel) {
		this.panel = panel;
		setExtendedState(JFrame.MAXIMIZED_BOTH);
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
		
		tglbtnSelect = new JToggleButton("Select");
		buttonGroup.add(tglbtnSelect);
		pnlTool.add(tglbtnSelect);
		
		btnDelete = new JButton("Delete");
		pnlTool.add(btnDelete);
		
		btnLineColor = new JButton("Line color");
		btnLineColor.setBackground(lineColor);
		pnlTool.add(btnLineColor);
		
		btnAreaColor = new JButton("Area Color");
		btnAreaColor.setBackground(areaColor);
		pnlTool.add(btnAreaColor);
		
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel pnlXy = new JPanel();
		contentPane.add(pnlXy, BorderLayout.SOUTH);
		pnlXy.setLayout(new BoxLayout(pnlXy, BoxLayout.X_AXIS));
		
		textArea = new JTextArea();
		textArea.setBackground(SystemColor.control);
		pnlXy.add(textArea);
	}
}
