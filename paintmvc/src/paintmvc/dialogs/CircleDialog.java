package paintmvc.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CircleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtRadius;
	public String kx;
	public String ky;
	public String kp;

	public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public String getKx() {
		return kx;
	}

	public void setKx(String kx) {
		this.kx = kx;
	}

	public String getKy() {
		return ky;
	}

	public void setKy(String ky) {
		this.ky = ky;
	}

	public String getKp() {
		return kp;
	}

	public void setKp(String kp) {
		this.kp = kp;
	}

	/**
	 * Create the dialog.
	 */
	public CircleDialog() {
		setModal(true);
		setBounds(100, 100, 226, 195);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblX = new JLabel("X:");
		lblX.setBounds(10, 11, 46, 14);
		contentPanel.add(lblX);
		
		JLabel lblY = new JLabel("Y:");
		lblY.setBounds(10, 39, 46, 14);
		contentPanel.add(lblY);
		
		txtX = new JTextField();
		txtX.setBounds(66, 8, 86, 20);
		contentPanel.add(txtX);
		txtX.setColumns(10);
		
		txtY = new JTextField();
		txtY.setBounds(66, 33, 86, 20);
		contentPanel.add(txtY);
		txtY.setColumns(10);
		
		JLabel lblRadius = new JLabel("Radius:");
		lblRadius.setBounds(10, 67, 46, 14);
		contentPanel.add(lblRadius);
		
		txtRadius = new JTextField();
		txtRadius.setBounds(66, 64, 86, 20);
		contentPanel.add(txtRadius);
		txtRadius.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setKx(getTxtX().getText());
						setKy(getTxtY().getText());
						setKp(getTxtRadius().getText());
						

						if (getKx().length() > 0) {
							try{
								Integer.parseInt(getKx());
							} catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "Morate uneti broj za X koordinatu!", "Upozorenje!", 
								JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Niste uneli X koordinatu!", "Upozorenje!", JOptionPane.WARNING_MESSAGE);
						}
						
						if (getKy().length() > 0) {
							try{
								Integer.parseInt(getKy());
							} catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "Morate uneti broj za Y koordinatu!", "Upozorenje!", 
								JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Niste uneli Y koordinatu!", "Upozorenje!", 
							JOptionPane.WARNING_MESSAGE);
						}
						
						if (getKp().length() > 0) {
							try{
								Integer.parseInt(getKp());
							} catch (NumberFormatException e1) {
								JOptionPane.showMessageDialog(null, "Morate uneti broj za poluprecnik!", "Upozorenje!", 
								JOptionPane.WARNING_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Niste uneli poluprcnik!", "Upozorenje!", JOptionPane.WARNING_MESSAGE);
						}
						
						try {
							Integer.parseInt(getKx());
							Integer.parseInt(getKy());
							Integer.parseInt(getKp());
							setVisible(false);
						} catch (NumberFormatException e1) {

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
