package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import logic.Karta;
import logic.ManagerIgre;
import logic.NeMozeSeNositiException;

public class JTalonPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8691133858454493253L;
	private GridLayout layout;
	private static List<JButton> dugmadi = new ArrayList<>();
	private static Map<Karta, JButton> kartaDugme = new HashMap<>();
	private static TopPanel top;
	private static Frame frame;

	/**
	 * Create the panel.
	 */
	public JTalonPanel(TopPanel top, Frame frame) {
		// ManagerIgre.zapocniIgru(null);
		JTalonPanel.frame = frame;
		JTalonPanel.top = top;
		setBackground(Color.blue);
		setPreferredSize(new Dimension(200, 100));
		setMaximumSize(new Dimension(100, 250));
		layout = new GridLayout(2, 2, 20, 20);
		setLayout(layout);
		getTalonDugmadi(ManagerIgre.tabla());
		osveziTalon();
	}

	public void getTalonDugmadi(List<Karta> talon) {
		for (Karta k : talon) {
			String slika = k.getSlika();
			ImageIcon image1 = new ImageIcon(slika);
			JButton dugme = new JButton(image1);
			dugme.setBackground(Color.blue);
			dugme.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (dugme.getBackground().equals(Color.blue)) {
						dugme.setBackground(Color.gray);
					} else {
						dugme.setBackground(Color.blue);
					}
				}
			});
			dugme.setVisible(true);
			add(dugme);
			dugmadi.add(dugme);
			kartaDugme.put(k, dugme);
		}
	}

	public List<Karta> oznaceneNaTalonu() {
		List<Karta> oznacene = new ArrayList<>();
		for (JButton d : dugmadi) {
			if (d.getBackground().equals(Color.gray)) {
				for (Map.Entry<Karta, JButton> entry : kartaDugme.entrySet()) {
					if (entry.getValue().equals(d)) {
						oznacene.add(entry.getKey());
					}
				}
			}
		}
		return oznacene;
	}

	public boolean odigraoSam(Karta bacena, List<Karta> nositi) {
		try {
			if (nositi == null) {
				ManagerIgre.odigraoSam(bacena);
			} else {
				ManagerIgre.odigraoSam(bacena, nositi);
			}
			osveziTalon();
			repaint();
			frame.blokiraj();
			return true;
		} catch (NeMozeSeNositiException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(frame, "Ne može da nosite karte");
			return false;
		}
	}

	public static void odigraoJe(Karta bacena, List<Karta> nositi) {
		if (nositi != null) {
			for (Karta karta : nositi) {
				JButton dugme = kartaDugme.get(karta);
				dugme.setBackground(Color.gray);
			}
		}
		top.okreniKartu(bacena);
		frame.odblokiraj();
		top.osveziKarte();
		frame.repaint();
	}

	public void osveziTalon() {
		dugmadi.removeAll(dugmadi);
		kartaDugme.remove(kartaDugme);
		removeAll();
		revalidate();
		repaint();
		getTalonDugmadi(ManagerIgre.tabla());
	}
}
