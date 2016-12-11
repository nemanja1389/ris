package paintmvc.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogSquare extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXCrd;
	private JTextField txtYCrd;
	private JTextField txtWidth;
	private Color lineColor = Color.BLACK;
	private Color internalColor = Color.WHITE;

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

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public void setTxtWidth(JTextField txtWidth) {
		this.txtWidth = txtWidth;
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}

	public Color getInternalColor() {
		return internalColor;
	}

	public void setInternalColor(Color internalColor) {
		this.internalColor = internalColor;
	}

	/**
	 * Create the dialog.
	 */
	public DialogSquare() {
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblX = new JLabel("x:");
			lblX.setBounds(10, 11, 46, 14);
			contentPanel.add(lblX);
		}
		{
			txtXCrd = new JTextField();
			txtXCrd.setColumns(10);
			txtXCrd.setBounds(66, 11, 86, 20);
			contentPanel.add(txtXCrd);
		}
		{
			JLabel lblY = new JLabel("y:");
			lblY.setBounds(10, 45, 46, 14);
			contentPanel.add(lblY);
		}
		{
			txtYCrd = new JTextField();
			txtYCrd.setColumns(10);
			txtYCrd.setBounds(66, 42, 86, 20);
			contentPanel.add(txtYCrd);
		}
		{
			JLabel lblWidth = new JLabel("Width:");
			lblWidth.setBounds(10, 82, 46, 14);
			contentPanel.add(lblWidth);
		}
		{
			txtWidth = new JTextField();
			txtWidth.setColumns(10);
			txtWidth.setBounds(66, 79, 86, 20);
			contentPanel.add(txtWidth);
		}
		{
			JLabel lblLineColor = new JLabel("Line color:");
			lblLineColor.setBounds(10, 127, 80, 14);
			contentPanel.add(lblLineColor);
		}
		{
			JButton btnLineColor = new JButton("Color");
			btnLineColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					lineColor = JColorChooser.showDialog(null, "Choose line color", Color.BLACK);
					if(lineColor == null){
						lineColor = Color.BLACK;
					}
					btnLineColor.setBackground(lineColor);
				}
			});
			btnLineColor.setBounds(100, 123, 89, 23);
			contentPanel.add(btnLineColor);
		}
		{
			JLabel lblInternalColor = new JLabel("Internal color:");
			lblInternalColor.setBounds(10, 152, 80, 14);
			contentPanel.add(lblInternalColor);
		}
		{
			JButton btnInternalColor = new JButton("Color");
			btnInternalColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					internalColor = JColorChooser.showDialog(null, "Choose line color", Color.WHITE);
					if(internalColor == null){
						internalColor = Color.WHITE;
					}
					btnInternalColor.setBackground(internalColor);
				}
			});
			btnInternalColor.setBounds(100, 148, 89, 23);
			contentPanel.add(btnInternalColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (txtWidth.getText().length() > 0) {
							try{
								Integer.parseInt(txtWidth.getText());
							} catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "Morate uneti broj za sirinu!", "Upozorenje!", 
								JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Niste uneli sirinu!", "Upozorenje!", JOptionPane.WARNING_MESSAGE);
						}
						
						try {
							Integer.parseInt(txtWidth.getText());
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
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
