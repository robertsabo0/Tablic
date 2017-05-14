package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import logic.ManagerIgre;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DialogKlijentServer extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3581087770290560456L;
	private final JPanel contentPanel = new JPanel();
	JRadioButton rdbnKlijent;
	JRadioButton rdbnServer;
	ButtonGroup klijentServer;
	JButton btnIgra;
	private JTextField textImeIgraca;
	private JTextField textAdresaServera;
	JPanel klijentPanel;

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
				textImeIgraca = new JTextField();
				playerPanel.add(textImeIgraca);
				textImeIgraca.setColumns(10);
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
							klijentPanel.setVisible(true);
							contentPanel.repaint();
						}
					});
					panelRadioButton.add(rdbnKlijent);
				}
				{
					rdbnServer = new JRadioButton("Server");
					rdbnServer.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							klijentPanel.setVisible(false);
							btnIgra.setEnabled(true);
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
					btnIgra.setEnabled(false);
					btnIgra.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ManagerIgre.igrac().setIme(textImeIgraca.getText());
							
							Frame igra = new Frame ();
							igra.setVisible(true);
						}
					});
					if (rdbnKlijent.isSelected()){
						btnIgra.setEnabled(false);
					}
					panelBottom.add(btnIgra);
				}
			}
			{
				klijentPanel = new JPanel();
				connectPanel.add(klijentPanel, BorderLayout.CENTER);
				klijentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				klijentPanel.setVisible(false);
				{
					JLabel lblAdresaServera = new JLabel("Unesite adresu servera:");
					klijentPanel.add(lblAdresaServera);
				}
				{
					textAdresaServera = new JTextField();
					textAdresaServera.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent arg0) {
							btnIgra.setEnabled(true);
						}
					});
					klijentPanel.add(textAdresaServera);
					textAdresaServera.setColumns(10);
				}
			}
			
		}
	}
}
