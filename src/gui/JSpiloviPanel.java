package gui;

import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class JSpiloviPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1660184878032792770L;

	/**
	 * Create the panel.
	 */
	public JSpiloviPanel() {
		setBackground(Color.BLUE);
		setLayout(new GridLayout(2, 1, 0, 0));
		ImageIcon image=new ImageIcon("pozadina.jpg");
		
		JLabel lblSpil1 = new JLabel(image);
		add(lblSpil1);
		
		JLabel lblSpil2 = new JLabel(image);
		add(lblSpil2);
		

	}

}
