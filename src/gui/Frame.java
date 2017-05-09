package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class Frame extends JFrame {

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,650, 400);
		setMinimumSize(new Dimension(650, 400));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel north = new topPanel();
		contentPane.add(north, BorderLayout.NORTH);
		
		JPanel south = new BottonPanel();
		contentPane.add(south, BorderLayout.SOUTH);
		
		table = new JTable();
		contentPane.add(table, BorderLayout.EAST);
		
		JPanel centralni = new JCentralniPanel();
		contentPane.add(centralni, BorderLayout.CENTER);
		centralni.setLayout(new BorderLayout(0, 0));
		
		JPanel spilovi = new JSpiloviPanel();
		centralni.add(spilovi, BorderLayout.WEST);
		
		JPanel glavniSpil = new JGlavniSpilPanel();
		centralni.add(glavniSpil, BorderLayout.EAST);
		
		JPanel talon = new JTablonPanel();
		centralni.add(talon, BorderLayout.CENTER);
	}

}
