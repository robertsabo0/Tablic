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
		setBackground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,650, 400);
		setMinimumSize(new Dimension(800, 600));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel north = new topPanel();
		north.setBackground(Color.BLUE);
		contentPane.add(north, BorderLayout.NORTH);
		
		JPanel south = new BottonPanel();
		south.setBackground(Color.BLUE);
		contentPane.add(south, BorderLayout.SOUTH);
		MyTableModel tm=new MyTableModel();
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
		
		JPanel talon = new JTablonPanel();
		talon.setBackground(Color.BLUE);
		centralni.add(talon, BorderLayout.CENTER);
	}

}
