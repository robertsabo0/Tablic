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

public class topPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1740250979628994678L;
	/**
	 * Create the panel.
	 */
	static JButton prvaKarta,drugaKarta,trecaKarta,cetvrtaKarta,petaKarta,sestaKarta;
	public topPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(10);
		add(horizontalStrut);
		ImageIcon image=new ImageIcon("pozadina.jpg");
		prvaKarta = new JButton(image);
		prvaKarta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				prvaKarta.setBackground(Color.gray);
			}
		});
		prvaKarta.setBackground(Color.blue);
		add(prvaKarta);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		add(horizontalGlue);
		
		drugaKarta = new JButton(image);
		add(drugaKarta);
		drugaKarta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				drugaKarta.setBackground(Color.gray);
			}
		});
		drugaKarta.setBackground(Color.blue);
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		add(horizontalGlue_1);
		
		trecaKarta = new JButton(image);
		add(trecaKarta);
		trecaKarta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				trecaKarta.setBackground(Color.gray);
			}
		});
		trecaKarta.setBackground(Color.blue);
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		add(horizontalGlue_2);
		
		cetvrtaKarta = new JButton(image);
		add(cetvrtaKarta);
		cetvrtaKarta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cetvrtaKarta.setBackground(Color.gray);
			}
		});
		cetvrtaKarta.setBackground(Color.blue);
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		add(horizontalGlue_3);
		
		petaKarta = new JButton(image);
		add(petaKarta);
		petaKarta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				petaKarta.setBackground(Color.gray);
			}
		});
		petaKarta.setBackground(Color.blue);
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		add(horizontalGlue_4);
		
		sestaKarta = new JButton(image);
		add(sestaKarta);
		sestaKarta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				sestaKarta.setBackground(Color.gray);
			}
		});
		sestaKarta.setBackground(Color.blue);
		Component horizontalStrut_6 = Box.createHorizontalStrut(10);
		add(horizontalStrut_6);

	}

}
