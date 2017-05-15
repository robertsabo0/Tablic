package gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;

import javax.swing.JComponent;
import javax.swing.event.MouseInputAdapter;

public class MyGlassPane extends JComponent {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	public MyGlassPane() {
		MouseInputAdapter ma = new MouseInputAdapter() {
		};

		addMouseListener(ma);
		addMouseMotionListener(ma);
		addKeyListener(new KeyAdapter() {
		});

		addComponentListener(new ComponentAdapter() {

			@Override
			public void componentShown(ComponentEvent arg0) {
				requestFocusInWindow();
			}

		});
		setFocusTraversalKeysEnabled(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		Color c = new Color(255, 255, 255, 165);
		g.setColor(c);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.setColor(Color.BLACK);
		g.drawString("Cekanje drugog igraca!", getWidth() / 2 - 40, getHeight() / 2);
	}
	
	public void activate (){
		setEnabled(true);
	}
	
	public void deactivate(){
		setEnabled(false);
	}

}
