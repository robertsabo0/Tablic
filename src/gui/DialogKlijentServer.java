package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogKlijentServer extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogKlijentServer dialog = new DialogKlijentServer();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogKlijentServer() {
		setTitle("Tablic");
		setBounds(100, 100, 359, 223);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.X_AXIS));
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		contentPanel.add(horizontalGlue_1);
		
		JButton btnKreiraj = new JButton("Kreiraj partiju");
		contentPanel.add(btnKreiraj);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		contentPanel.add(horizontalStrut);
		
		JButton btnPridruziSe = new JButton("Pridruzi se partiji");
		btnPridruziSe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPanel.add(btnPridruziSe);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		contentPanel.add(horizontalGlue);
		{
			
		}
	}

}
