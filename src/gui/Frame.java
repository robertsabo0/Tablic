package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import logic.Igrac;
import logic.ManagerIgre;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5239550909572819317L;
	private JPanel contentPane;
	private JTable table;
	public static Frame frame;
	public static boolean blokiran;
	public static JTalonPanel talon;
	private BottonPanel south;
	private TopPanel north;
	private MyTableModel tm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Frame();
					frame.setVisible(true);
					if (blokiran) {
						frame.blokiraj();
					}
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
		if (DialogKlijentServer.dks!=null)
			DialogKlijentServer.dks.dispose();
		setTitle("Tablic: "+Igrac.getIme());
		setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		setMinimumSize(new Dimension(800, 600));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		if (ManagerIgre.krajIgre()) {
			if (ManagerIgre.igrac().getUkupnoPoeni() > 100) {
				ManagerIgre.igrac();
				PorukaOPobedniku p = new PorukaOPobedniku(Igrac.getIme());
				p.setVisible(true);
			} else {
				PorukaOPobedniku p = new PorukaOPobedniku(ManagerIgre.getDrugiIgracIme());
				p.setVisible(true);
			}

		}
		north = new TopPanel();
		north.setBackground(Color.BLUE);
		contentPane.add(north, BorderLayout.NORTH);

		tm = new MyTableModel(ManagerIgre.igrac());
		table = new JTable(tm);
		table.setMaximumSize(new Dimension(100, 400));
		JScrollPane sp = new JScrollPane(table);
		sp.setMaximumSize(new Dimension(175, 400));
		sp.setPreferredSize(new Dimension(210, 400));

		int columSize = table.getColumnModel().getColumn(0).getPreferredWidth();
		table.getColumnModel().getColumn(0).setPreferredWidth(columSize / 2 + 4);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setCellSelectionEnabled(false);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < 3; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		contentPane.add(sp, BorderLayout.EAST);

		JPanel centralni = new JCentralniPanel();
		contentPane.add(centralni, BorderLayout.CENTER);
		centralni.setLayout(new BorderLayout(0, 0));

		JPanel spilovi = new JSpiloviPanel();
		centralni.add(spilovi, BorderLayout.WEST);

		JPanel glavniSpil = new JGlavniSpilPanel();
		centralni.add(glavniSpil, BorderLayout.EAST);

		talon = new JTalonPanel(north, this);
		centralni.add(talon, BorderLayout.CENTER);

		south = new BottonPanel(talon);
		south.setBackground(Color.BLUE);
		contentPane.add(south, BorderLayout.SOUTH);

	}

	MyGlassPane my = new MyGlassPane();

	public void blokiraj() {

		setGlassPane(my);
		my.activate();
		getGlassPane().setVisible(true);
	}

	public void odblokiraj() {
		talon.osveziTalon();
		my.deactivate();
		getGlassPane().setVisible(false);
	}

	public void osvezi() {
		talon.osveziTalon();
		tm.azuriraj();
		south.osveziRuku();
		north.osveziKarte();
	}

}