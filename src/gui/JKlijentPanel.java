package gui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextField;
import java.awt.FlowLayout;

public class JKlijentPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public JKlijentPanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblServerAdress = new JLabel("Unesite adresu servera:");
		add(lblServerAdress);
		
		textField = new JTextField();
		add(textField);
		textField.setColumns(10);
		
	}

}
