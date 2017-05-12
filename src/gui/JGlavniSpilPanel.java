package gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class JGlavniSpilPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5046936779435740032L;

	/**
	 * Create the panel.
	 */
	public JGlavniSpilPanel() {
		setBackground(Color.BLUE);
		setLayout(new BorderLayout(0, 0));
		
		
		ImageIcon icon = new ImageIcon("pozadina.jpg");
		
		JLabel lblSpil = new JLabel(icon);
		add(lblSpil, BorderLayout.CENTER);
		
	}

}
