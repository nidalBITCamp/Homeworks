package ba.bitcamp.homeworks.task;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class present a program where the user with mouse click chooses where to
 * place the circle . Mouse click represents coordinates of the center of the
 * circle. Size of the circle is adjusted by sliders
 * 
 * @author Niddal
 *
 */
public class Task7 extends JFrame {

	private static final long serialVersionUID = -1261606584792678090L;

	// Variables for draw circle
	private int x;
	private int y;
	private int radius;

	// Declaration new panel and slider
	JPanel panel = new myPanel();
	JSlider size = new JSlider(0, 700, 0);

	public Task7() {

		size.setBorder(BorderFactory.createTitledBorder(" Value of radisu "));

		// Set layout of frame
		setLayout(new BorderLayout());

		// Add slider to panel
		panel.setLayout(new BorderLayout());
		panel.add(size, BorderLayout.SOUTH);

		// Add change listener to slider
		size.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {

				radius = size.getValue();
				repaint();

			}
		});

		// Add panel to frame
		add(panel);

		// Add mouse listener to panel
		panel.addMouseListener(new Mouse());

		// Attributes of frame, size, title, and location
		setSize(700, 500);
		setTitle(" Circle ");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * This class present present panel, with paint component
	 * 
	 * @author Niddal
	 *
	 */
	private class myPanel extends JPanel {

		private static final long serialVersionUID = 4167571236195886124L;

		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);

			// Draw oval with graphics g
			g.setColor(Color.RED);
			g.fillOval(x - radius / 2, y - radius / 2, radius, radius);
			repaint();
		}

	}

	/**
	 * This class present mouse listener which extends mouse adapter with mouse
	 * clicked method
	 * 
	 * @author Niddal
	 *
	 */
	private class Mouse extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent e) {
			x = e.getX();
			y = e.getY();
		}

	}

	public static void main(String[] args) {
		new Task7();

	}

}
