package paintmvc.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import paintmvc.geometry.Point;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class DialogPoint extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Point point;
	private Color lineColor;
	private JTextField txtXCrd;
	private JTextField txtYCrd;
	private JButton btnColor;
	
	public JButton getBtnColor() {
		return btnColor;
	}

	public void setBtnColor(JButton btnColor) {
		this.btnColor = btnColor;
	}

	public JTextField getTxtXCrd() {
		return txtXCrd;
	}

	public void setTxtXCrd(JTextField txtXCrd) {
		this.txtXCrd = txtXCrd;
	}

	public JTextField getTxtYCrd() {
		return txtYCrd;
	}

	public void setTxtYCrd(JTextField txtYCrd) {
		this.txtYCrd = txtYCrd;
	}

	public Color getLineColor() {
		return lineColor;
	}
	
	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	/**
	 * Create the dialog.
	 */
	public DialogPoint(Point point) {
		this.point=point;
		setModal(true);
		setBounds(100, 100, 303, 223);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblLineColor = new JLabel("Line color:");
			lblLineColor.setBounds(10, 69, 81, 14);
			contentPanel.add(lblLineColor);
		}
		{
			btnColor = new JButton("Color");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lineColor = JColorChooser.showDialog(null, "Choose line color", Color.BLACK);
					if(lineColor == null){
						lineColor = point.getLineColor();
						btnColor.setBackground(lineColor);
					}
					btnColor.setBackground(lineColor);
				}
			});
			btnColor.setBounds(100, 65, 89, 23);
			contentPanel.add(btnColor);
		}
		{
			JLabel lblX = new JLabel("x:");
			lblX.setBounds(10, 11, 46, 14);
			contentPanel.add(lblX);
		}
		{
			JLabel lblY = new JLabel("y:");
			lblY.setBounds(10, 36, 46, 14);
			contentPanel.add(lblY);
		}
		{
			txtXCrd = new JTextField();
			txtXCrd.setBounds(66, 8, 66, 20);
			contentPanel.add(txtXCrd);
			txtXCrd.setColumns(10);
		}
		{
			txtYCrd = new JTextField();
			txtYCrd.setBounds(66, 33, 66, 20);
			contentPanel.add(txtYCrd);
			txtYCrd.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtXCrd.getText().length() > 0) {
							try{
								Integer.parseInt(txtXCrd.getText());
							} catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "Morate uneti broj za sirinu!", "Upozorenje!", 
								JOptionPane.WARNING_MESSAGE);
							}
						} else if(txtYCrd.getText().length() > 0){
							try{
								Integer.parseInt(txtYCrd.getText());
							} catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "Morate uneti broj za sirinu!", "Upozorenje!", 
								JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Niste uneli sirinu!", "Upozorenje!", JOptionPane.WARNING_MESSAGE);
						}
						
						try {
							Integer.parseInt(txtXCrd.getText());
							Integer.parseInt(txtYCrd.getText());
							lineColor = btnColor.getBackground();
							setVisible(false);
						} catch (NumberFormatException e2) {
							// TODO: handle exception
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtXCrd.getText().length() > 0) {
							try{
								Integer.parseInt(txtXCrd.getText());
							} catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "Morate uneti broj za sirinu!", "Upozorenje!", 
								JOptionPane.WARNING_MESSAGE);
							}
						} else if(txtYCrd.getText().length() > 0){
							try{
								Integer.parseInt(txtYCrd.getText());
							} catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "Morate uneti broj za sirinu!", "Upozorenje!", 
								JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Niste uneli sirinu!", "Upozorenje!", JOptionPane.WARNING_MESSAGE);
						}
						
						try {
							Integer.parseInt(txtXCrd.getText());
							Integer.parseInt(txtYCrd.getText());
							lineColor = point.getLineColor();
							dispose();
						} catch (NumberFormatException e2) {
							// TODO: handle exception
						}
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
