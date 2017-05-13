package gui;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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
		JLabel lblSpil1 = new JLabel(image);
		add(lblSpil1);
		//prvaKarta = new JButton(image);
		//prvaKarta.addMouseListener(new MouseAdapter() {
		//	@Override
		//	public void mouseClicked(MouseEvent arg0) {
		//		prvaKarta.setBackground(Color.gray);
		//	}
		//});
		//prvaKarta.setBackground(Color.blue);
		//add(prvaKarta);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		add(horizontalGlue);
		JLabel lblSpil2 = new JLabel(image);
		add(lblSpil2);
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		add(horizontalGlue_1);
		JLabel lblSpil3 = new JLabel(image);
		add(lblSpil3);
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		add(horizontalGlue_2);
		JLabel lblSpil4 = new JLabel(image);
		add(lblSpil4);
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		add(horizontalGlue_3);
		JLabel lblSpil5 = new JLabel(image);
		add(lblSpil5);
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		add(horizontalGlue_4);
		JLabel lblSpil6 = new JLabel(image);
		add(lblSpil6);
		Component horizontalStrut_6 = Box.createHorizontalStrut(10);
		add(horizontalStrut_6);

	}

}
