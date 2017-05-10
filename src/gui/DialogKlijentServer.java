package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogKlijentServer extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JRadioButton rdbnKlijent;
	JRadioButton rdbnServer;
	ButtonGroup klijentServer;
	JPanel panelKlijent;
	JButton btnIgra;
	private JTextField textField;

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
		setBounds(100, 100, 382, 182);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel playerPanel = new JPanel();
			contentPanel.add(playerPanel, BorderLayout.NORTH);
			playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.X_AXIS));
			{
				JLabel lblPlayerName = new JLabel("Unesite vase ime:");
				playerPanel.add(lblPlayerName);
			}
			{
				Component horizontalStrut = Box.createHorizontalStrut(20);
				playerPanel.add(horizontalStrut);
			}
			{
				textField = new JTextField();
				playerPanel.add(textField);
				textField.setColumns(10);
			}
			{
				Component horizontalStrut = Box.createHorizontalStrut(20);
				playerPanel.add(horizontalStrut);
			}
			{
				Component horizontalGlue = Box.createHorizontalGlue();
				playerPanel.add(horizontalGlue);
			}
		}
		{
			JPanel connectPanel = new JPanel();
			contentPanel.add(connectPanel, BorderLayout.CENTER);
			connectPanel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panelRadioButton = new JPanel();
				connectPanel.add(panelRadioButton, BorderLayout.NORTH);
				{
					rdbnKlijent = new JRadioButton("Klijent");
					rdbnKlijent.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							panelKlijent.setVisible(true);
							contentPanel.repaint();
						}
					});
					panelRadioButton.add(rdbnKlijent);
				}
				{
					rdbnServer = new JRadioButton("Server");
					rdbnServer.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							panelKlijent.setVisible(false);
							contentPanel.repaint();
						}
					});
					panelRadioButton.add(rdbnServer);
				}
				{
					klijentServer= new ButtonGroup();
					klijentServer.add(rdbnKlijent);
					klijentServer.add(rdbnServer);
				}
			}
			{
				JPanel panelBottom = new JPanel();
				connectPanel.add(panelBottom, BorderLayout.SOUTH);
				{
					btnIgra = new JButton("Igra");
					btnIgra.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
						}
					});
					if (rdbnKlijent.isSelected()){
						btnIgra.setEnabled(false);
					}
					panelBottom.add(btnIgra);
				}
			}
			{
				panelKlijent = new JKlijentPanel();
				panelKlijent.setVisible(false);
				connectPanel.add(panelKlijent, BorderLayout.CENTER);
			}
			
		}
	}

}
