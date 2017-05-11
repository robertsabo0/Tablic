package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JTablonPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8691133858454493253L;
	private int brojKarata;
	private GridLayout layout;
	/**
	 * Create the panel.
	 */
	public JTablonPanel() {
		setBackground(SystemColor.inactiveCaptionBorder);
		layout= new GridLayout(2, 2, 20, 20);
		setLayout(layout);
		
	}
	
	public void postaviKartu(JButton card){
		if (brojKarata==(layout.getRows()*layout.getColumns())){
			layout.setColumns(layout.getColumns()+1);
		}
		brojKarata++;
		add(card);
	}
	
	public void skiniKartu(JButton card){
		remove(card);
		
		if (brojKarata>4 && brojKarata%2==1){
			layout.setColumns(layout.getColumns()-1);
		}
		brojKarata--;
	}
	
	public void oznaciKartu (JButton card){
		card.setBackground(Color.gray);
	}
	
	
	
	

}
