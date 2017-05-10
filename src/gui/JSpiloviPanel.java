package gui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridLayout;

public class JSpiloviPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public JSpiloviPanel() {
		setLayout(new GridLayout(2, 1, 0, 0));
		ImageIcon image=new ImageIcon("pozadina.jpg");
		JButton goreKarte = new JButton(image);
		goreKarte.setBackground(Color.blue);
		add(goreKarte);
		
		JButton doleKarte = new JButton(image);
		doleKarte.setBackground(Color.blue);
		add(doleKarte);

	}

}
