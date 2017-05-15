package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableCellRenderer;

import logic.ManagerIgre;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5239550909572819317L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,650, 400);
		setMinimumSize(new Dimension(800, 600));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		if(ManagerIgre.krajIgre()){
			if(ManagerIgre.igrac().getUkupnoPoeni()>100){
				PorukaOPobedniku p=new PorukaOPobedniku(ManagerIgre.igrac().getIme());
				p.setVisible(true);
			}else{
				PorukaOPobedniku p=new PorukaOPobedniku(ManagerIgre.getDrugiIgracIme());
				p.setVisible(true);
			}
			
		}
		TopPanel north = new TopPanel();
		north.setBackground(Color.BLUE);
		contentPane.add(north, BorderLayout.NORTH);
		
		
		MyTableModel tm=new MyTableModel(ManagerIgre.igrac());
		table = new JTable(tm);
		table.setMaximumSize(new Dimension(100,400));
		JScrollPane sp=new JScrollPane(table);
		sp.setMaximumSize(new Dimension(175, 400));
		sp.setPreferredSize(new Dimension(210, 400));
		
		int columSize=table.getColumnModel().getColumn(0).getPreferredWidth();
		table.getColumnModel().getColumn(0).setPreferredWidth(columSize/2+4);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setCellSelectionEnabled(false);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for(int i=0;i<3;i++){
			table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		}
		contentPane.add(sp, BorderLayout.EAST);
		  
		JPanel centralni = new JCentralniPanel();
		contentPane.add(centralni, BorderLayout.CENTER);
		centralni.setLayout(new BorderLayout(0, 0));
		
		JPanel spilovi = new JSpiloviPanel();
		centralni.add(spilovi, BorderLayout.WEST);
		
		JPanel glavniSpil = new JGlavniSpilPanel();
		centralni.add(glavniSpil, BorderLayout.EAST);
		
		JTalonPanel talon = new JTalonPanel(north, this);
		centralni.add(talon, BorderLayout.CENTER);
		
		JPanel south = new BottonPanel(talon);
		south.setBackground(Color.BLUE);
		contentPane.add(south, BorderLayout.SOUTH);
		this.pack();
		blokiraj();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		odblokiraj();
	}
	MyGlassPane my=new MyGlassPane();
	public void blokiraj (){
		
		setGlassPane(my);
		my.activate();
		getGlassPane().setVisible(true);
	}
	
	public void odblokiraj (){
		my.deactivate();
		getGlassPane().setVisible(false);
	}
}