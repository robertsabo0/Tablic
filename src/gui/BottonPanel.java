package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BottonPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public BottonPanel() {
setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		ImageIcon image=new ImageIcon("pozadina.jpg");
		
		Component horizontalGlue_5 = Box.createHorizontalGlue();
		add(horizontalGlue_5);
		JButton prvaKarta = new JButton(image);
		add(prvaKarta);
		prvaKarta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				prvaKarta.setVisible(false);
				horizontalGlue_5.setVisible(false);
			}
		});
		prvaKarta.setBackground(Color.blue);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		add(horizontalGlue);
		
		JButton drugaKarta = new JButton(image);
		add(drugaKarta);
		drugaKarta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				drugaKarta.setVisible(false);
				horizontalGlue.setVisible(false);
			}
		});
		drugaKarta.setBackground(Color.blue);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		add(horizontalGlue_1);
		
		JButton trecaKarta = new JButton(image);
		add(trecaKarta);
		trecaKarta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				trecaKarta.setVisible(false);
				horizontalGlue_1.setVisible(false);
			}
		});
		trecaKarta.setBackground(Color.blue);
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		add(horizontalGlue_2);
		
		JButton cetvrtaKarta = new JButton(image);
		add(cetvrtaKarta);
		cetvrtaKarta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cetvrtaKarta.setVisible(false);
				horizontalGlue_2.setVisible(false);
			}
		});
		cetvrtaKarta.setBackground(Color.blue);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		add(horizontalGlue_3);
		
		JButton petaKarta = new JButton(image);
		add(petaKarta);
		petaKarta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				petaKarta.setVisible(false);
				horizontalGlue_3.setVisible(false);
			}
		});
		petaKarta.setBackground(Color.blue);
		
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		add(horizontalGlue_4);
		
		JButton sestaKarta = new JButton(image);
		add(sestaKarta);
		sestaKarta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sestaKarta.setVisible(false);
				horizontalGlue_4.setVisible(false);
			}
		});
		sestaKarta.setBackground(Color.blue);
		
		Component horizontalGlue_6 = Box.createHorizontalGlue();
		add(horizontalGlue_6);
	}

}
