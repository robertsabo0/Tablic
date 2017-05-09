package gui;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BottonPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public BottonPanel() {
setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		add(horizontalStrut);
		
		JButton prvaKarta = new JButton("New button");
		add(prvaKarta);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		add(horizontalGlue);
		
		JButton drugaKarta = new JButton("New button");
		add(drugaKarta);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		add(horizontalGlue_1);
		
		JButton trecaKarta = new JButton("New button");
		add(trecaKarta);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		add(horizontalGlue_2);
		
		JButton cetvrtaKarta = new JButton("New button");
		add(cetvrtaKarta);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		add(horizontalGlue_3);
		
		JButton petaKarta = new JButton("New button");
		add(petaKarta);
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		add(horizontalGlue_4);
		
		JButton sestaKarta = new JButton("New button");
		add(sestaKarta);
		//sdfsdfsdf
		Component horizontalStrut_6 = Box.createHorizontalStrut(10);
		add(horizontalStrut_6);
	}

}
