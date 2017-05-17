package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logic.Karta;
import logic.ManagerIgre;

public class TopPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1740250979628994678L;
	/**
	 * Create the panel.
	 */

	List<JLabel> protivnikoveKarte = new ArrayList<>();

	public TopPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setPreferredSize(new Dimension(0, 125));
		osveziKarte();
		

	}

	public void okreniKartu(Karta bacena) {
		int i = (int) (Math.random() * protivnikoveKarte.size());
		
		JLabel karta = protivnikoveKarte.get(i);
		ImageIcon icon = new ImageIcon(bacena.getSlika());
		karta.setIcon(icon);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		karta.setVisible(false);
		remove(karta);
		protivnikoveKarte.remove(i);
		//if ( ManagerIgre.igrac().getURuci().size()==6)
			//osveziKarte();
	}

	public void osveziKarte() {
		if (protivnikoveKarte.isEmpty()) {
			removeAll();
			ImageIcon image = new ImageIcon("pozadina.jpg");
			for (int i = 0; i < 6; i++) {
				Component horizontalGlue = Box.createHorizontalGlue();
				add(horizontalGlue);
				JLabel lblSpil2 = new JLabel(image);
				add(lblSpil2);
				if (protivnikoveKarte.size() < 6)
					protivnikoveKarte.add(lblSpil2);
			}
			Component horizontalGlue_1 = Box.createHorizontalGlue();
			add(horizontalGlue_1);
		}
	}
}
