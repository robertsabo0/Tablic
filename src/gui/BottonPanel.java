package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import logic.Karta;
import logic.ManagerIgre;

public class BottonPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7917254802978612604L;
	private static JTalonPanel talon;

	/**
	 * Create the panel.
	 */

	public BottonPanel(JTalonPanel talon) {
		// ManagerIgre.zapocniIgru(null);
		BottonPanel.talon = talon;
		setPreferredSize(new Dimension(0, 125));
		List<Karta> ruka = ManagerIgre.igrac().getURuci();
		getRuka(ruka);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
	}

	public void getRuka(List<Karta> ruka) {
		for (Karta k : ruka) {
			Component horizontalGlue_4 = Box.createHorizontalGlue();
			add(horizontalGlue_4);
			String slika = k.getSlika();
			ImageIcon image1 = new ImageIcon(slika);
			JButton dugme = new JButton(image1);
			dugme.setBackground(Color.blue);
			dugme.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if (talon.oznaceneNaTalonu().size() == 0) {
						dugme.setVisible(false);
						horizontalGlue_4.setVisible(false);
						if (talon.odigraoSam(k, null)) {
							remove(dugme);
							remove(horizontalGlue_4);
						}
					} else {
						
						if (talon.odigraoSam(k, talon.oznaceneNaTalonu())) {
							dugme.setVisible(false);
							horizontalGlue_4.setVisible(false);
							remove(dugme);
							remove(horizontalGlue_4);
						}
					}

				}
			});
			add(dugme);
		}
		Component horizontalGlue_4 = Box.createHorizontalGlue();
		add(horizontalGlue_4);

	}

	public void osveziRuku() {
		removeAll();
		getRuka(ManagerIgre.igrac().getURuci());
		repaint();
	}
}
