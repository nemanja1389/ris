package paintmvc.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import paintmvc.geometry.Line;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Line line;
	private Color lineColor;
	private JTextField txtStartX;
	private JTextField txtStartY;
	private JTextField txtEndX;
	private JTextField txtEndY;
	private JButton btnColor;

	public JButton getBtnColor() {
		return btnColor;
	}

	public void setBtnColor(JButton btnColor) {
		this.btnColor = btnColor;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public JTextField getTxtStartX() {
		return txtStartX;
	}

	public void setTxtStartX(JTextField txtStartX) {
		this.txtStartX = txtStartX;
	}

	public JTextField getTxtStartY() {
		return txtStartY;
	}

	public void setTxtStartY(JTextField txtStartY) {
		this.txtStartY = txtStartY;
	}

	public JTextField getTxtEndX() {
		return txtEndX;
	}

	public void setTxtEndX(JTextField txtEndX) {
		this.txtEndX = txtEndX;
	}

	public JTextField getTxtEndY() {
		return txtEndY;
	}

	public void setTxtEndY(JTextField txtEndY) {
		this.txtEndY = txtEndY;
	}

	/**
	 * Create the dialog.
	 */
	public DialogLine(Line line) {
		this.line = line;
		setModal(true);
		setBounds(100, 100, 450, 194);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblStartPointX = new JLabel("Start point x:");
			lblStartPointX.setBounds(10, 14, 81, 14);
			contentPanel.add(lblStartPointX);
		}
		{
			txtStartX = new JTextField();
			txtStartX.setColumns(10);
			txtStartX.setBounds(101, 11, 66, 20);
			contentPanel.add(txtStartX);
		}
		{
			JLabel lblStartPointY = new JLabel("Start point y:");
			lblStartPointY.setBounds(10, 39, 81, 14);
			contentPanel.add(lblStartPointY);
		}
		{
			txtStartY = new JTextField();
			txtStartY.setColumns(10);
			txtStartY.setBounds(101, 36, 66, 20);
			contentPanel.add(txtStartY);
		}
		{
			JLabel label = new JLabel("Line color:");
			label.setBounds(10, 71, 81, 14);
			contentPanel.add(label);
		}
		{
			btnColor = new JButton("Color");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lineColor = JColorChooser.showDialog(null, "Choose line color", Color.BLACK);
					if (lineColor == null) {
						lineColor = line.getLineColor();
						btnColor.setBackground(lineColor);
					}
					btnColor.setBackground(lineColor);
				}
			});
			btnColor.setBackground(line.getLineColor());
			btnColor.setBounds(101, 67, 89, 23);
			contentPanel.add(btnColor);
		}
		{
			JLabel lblEndPointX = new JLabel("End point x:");
			lblEndPointX.setBounds(177, 14, 81, 14);
			contentPanel.add(lblEndPointX);
		}
		{
			JLabel lblEndPointY = new JLabel("End point y:");
			lblEndPointY.setBounds(177, 39, 81, 14);
			contentPanel.add(lblEndPointY);
		}
		{
			txtEndX = new JTextField();
			txtEndX.setBounds(268, 11, 66, 20);
			contentPanel.add(txtEndX);
			txtEndX.setColumns(10);
		}
		{
			txtEndY = new JTextField();
			txtEndY.setBounds(268, 39, 66, 20);
			contentPanel.add(txtEndY);
			txtEndY.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtStartX.getText().length() > 0) {
							try {
								Integer.parseInt(txtStartX.getText());
							} catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "Morate uneti broj za sirinu!", "Upozorenje!",
										JOptionPane.WARNING_MESSAGE);
							}
						} else if (txtStartY.getText().length() > 0) {
							try {
								Integer.parseInt(txtStartY.getText());
							} catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "Morate uneti broj za sirinu!", "Upozorenje!",
										JOptionPane.WARNING_MESSAGE);
							}
						} else if (txtEndX.getText().length() > 0) {
							try {
								Integer.parseInt(txtEndX.getText());
							} catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog(null, "Morate uneti broj za sirinu!", "Upozorenje!",
										JOptionPane.WARNING_MESSAGE);
							}
						} else if (txtEndY.getText().length() > 0){
							try {
								Integer.parseInt(txtEndY.getText());
							} catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog(null, "Morate uneti broj za sirinu!", "Upozorenje!",
										JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Niste uneli sirinu!", "Upozorenje!",
									JOptionPane.WARNING_MESSAGE);
						}

						try {
							Integer.parseInt(txtStartX.getText());
							Integer.parseInt(txtStartY.getText());
							Integer.parseInt(txtEndX.getText());
							Integer.parseInt(txtEndY.getText());
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
						if (txtStartX.getText().length() > 0) {
							try {
								Integer.parseInt(txtStartX.getText());
							} catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "Morate uneti broj za sirinu!", "Upozorenje!",
										JOptionPane.WARNING_MESSAGE);
							}
						} else if (txtStartY.getText().length() > 0) {
							try {
								Integer.parseInt(txtStartY.getText());
							} catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "Morate uneti broj za sirinu!", "Upozorenje!",
										JOptionPane.WARNING_MESSAGE);
							}
						} else if (txtEndX.getText().length() > 0) {
							try {
								Integer.parseInt(txtEndX.getText());
							} catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog(null, "Morate uneti broj za sirinu!", "Upozorenje!",
										JOptionPane.WARNING_MESSAGE);
							}
						} else if (txtEndY.getText().length() > 0){
							try {
								Integer.parseInt(txtEndY.getText());
							} catch (NumberFormatException e2) {
								JOptionPane.showMessageDialog(null, "Morate uneti broj za sirinu!", "Upozorenje!",
										JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Niste uneli sirinu!", "Upozorenje!",
									JOptionPane.WARNING_MESSAGE);
						}

						try {
							Integer.parseInt(txtStartX.getText());
							Integer.parseInt(txtStartY.getText());
							Integer.parseInt(txtEndX.getText());
							Integer.parseInt(txtEndY.getText());
							lineColor = line.getLineColor();
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
