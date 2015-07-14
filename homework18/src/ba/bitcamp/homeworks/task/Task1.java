package ba.bitcamp.homeworks.task;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class present a program that has one slider which is the font size. The
 * higher value of the slider responder larger font.
 * 
 * @author Niddal
 *
 */
public class Task1 extends JFrame {

	private static final long serialVersionUID = 372802758361420809L;

	private int size = 0;

	JLabel label = new JLabel(" Example text ");
	JSlider slider = new JSlider(0, 100, 0);
	BorderLayout window = new BorderLayout();

	public Task1() {

		// Add new label in the center of border layout
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBorder(BorderFactory.createTitledBorder("Label 1"));
		label.setForeground(Color.RED);
		label.setFont(new Font("Serif", Font.BOLD, size));
		add(label, BorderLayout.CENTER);

		// Add new slider in the south of border layout
		slider.setMinorTickSpacing(10);
		slider.setMajorTickSpacing(20);
		slider.setBorder(BorderFactory.createTitledBorder("Font size"));
		add(slider, BorderLayout.SOUTH);

		// Set the change listener to slider with anonymous class
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {

				size = slider.getValue();
				label.setFont(new Font("Serif", Font.BOLD, size));

			}
		});

		// Attributes of frame, size, title, and location
		setSize(700, 500);
		setTitle(" ADJUSTABLE FONT SIZE ");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Task1();

	}

}