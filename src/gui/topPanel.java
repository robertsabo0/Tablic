package gui;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;

public class topPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public topPanel() {
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
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(10);
		add(horizontalStrut_6);

	}

}
