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
	private static  List<JButton> dugmadi= new ArrayList<>();
	private static Map <Karta,JButton> kartaDugme= new HashMap<>();
	/**
	 * Create the panel.
	 */
	public JTalonPanel() {
		setBackground(Color.blue);
		setPreferredSize(new Dimension(200, 100));
		setMaximumSize(new Dimension(100, 250));
		layout= new GridLayout(2, 2, 20, 20);
		setLayout(layout);
		ManagerIgre.zapocniIgru(null);
		getTalonDugmadi(ManagerIgre.tabla());
		for(int i=0;i<dugmadi.size();i++){
			add(dugmadi.get(i));
		}
	}
	
	public void postaviKartu(Karta karta){
		String slika= karta.getSlika();
		ImageIcon image1=new ImageIcon(slika);
		JButton card= new JButton(image1);
		
		card.setBackground(Color.blue);
		card.setVisible(true);
		card.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(card.getBackground().equals(Color.blue)){
					card.setBackground(Color.gray);
				}else{
					card.setBackground(Color.blue);
				}
				
				
			}
		});
		dugmadi.add(card);
		add(card);
		kartaDugme.put(karta, card);
	}
	
	public void skiniKartu(Karta karta){
		JButton card = kartaDugme.get(karta);
		card.setVisible(false);
		dugmadi.remove(card);
		remove(card);
		kartaDugme.remove(karta);
		
	}
	
	public static void getTalonDugmadi(List<Karta> talon){
		for(Karta k:talon){
			String slika= k.getSlika();
			ImageIcon image1=new ImageIcon(slika);
			JButton dugme= new JButton(image1);
			dugme.setBackground(Color.blue);
			dugme.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(dugme.getBackground().equals(Color.blue)){
						dugme.setBackground(Color.gray);
					}else{
						dugme.setBackground(Color.blue);
					}
				}
			});
			dugmadi.add(dugme);
			kartaDugme.put(k, dugme);
		}
	}
	public List<Karta> oznaceneNaTalonu(){
		List<Karta> oznacene=new ArrayList<>();
		for(JButton d:dugmadi){
			if(d.getBackground().equals(Color.gray)){
				for (Map.Entry<Karta, JButton> entry : kartaDugme.entrySet()) {
					if(entry.getValue().equals(d)){
						oznacene.add(entry.getKey());
					}
				}
			}
		}
		return oznacene;
	}
	public void nosi(Karta k){
			nosi(k, oznaceneNaTalonu());
	}
	
	public void nosi(Karta k, List<Karta> oznacene){
		try {
			ManagerIgre.odigraoSam(k,oznacene);
		} catch (NeMozeSeNositiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Karta o:oznacene){
			skiniKartu(o);
			
		}
	}

}
