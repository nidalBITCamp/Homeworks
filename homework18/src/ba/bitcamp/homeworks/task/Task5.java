package ba.bitcamp.homeworks.task;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class present a program that has three sliders . Each slider is responsible for one of
 * the three RGB colors .
 * 
 * @author Niddal
 *
 */
public class Task5 extends JPanel {

	private static final long serialVersionUID = 2673968178655675068L;

	private int red;
	private int green;
	private int blue;

	public Task5(int width, int height) {

		int sliderHeight = height / 12;

		Dimension sliderDimension = new Dimension(width - 45, sliderHeight);

		// Set sliders with method
		JSlider redSlider = new JSlider(0, 255);
		initSlider(redSlider, "red", sliderDimension);

		JSlider greenSlider = new JSlider(0, 255);
		initSlider(greenSlider, "green", sliderDimension);

		JSlider blueSlider = new JSlider(0, 255);
		initSlider(blueSlider, "blue", sliderDimension);

		// Set labels
		JLabel redLabel = new JLabel("Red");
		redLabel.setForeground(Color.RED);
		JLabel greenLabel = new JLabel("Green");
		greenLabel.setForeground(Color.GREEN);
		JLabel blueLabel = new JLabel("Blue");
		blueLabel.setForeground(Color.BLUE);

		// Add sliders and labels to panel
		add(redLabel);
		add(redSlider);
		add(greenLabel);
		add(greenSlider);
		add(blueLabel);
		add(blueSlider);

	}

	/**
	 * Method for initialization slider
	 * 
	 * @param slider
	 *            - Object JSlider
	 * @param name
	 *            - string name of slider
	 * @param d
	 *            - dimension of slider
	 */
	private void initSlider(JSlider slider, String name, Dimension d) {

		slider.setName(name);
		slider.setPreferredSize(d);
		slider.setValue(0);
		slider.setMinorTickSpacing(10);
		slider.setPaintTicks(true);

		// Set change listener to slider
		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {

				JSlider changed = (JSlider) e.getSource();

				// Set value of RGB color with value of slider

				switch (name) {

				case "red":
					red = changed.getValue();
					break;
				case "green":
					green = changed.getValue();
					break;
				case "blue":
					blue = changed.getValue();
					break;

				}
				updatePanel();
			}
		});

	}

	/**
	 * Method for set new background color of panel
	 */
	private void updatePanel() {

		setBackground(new Color(red, green, blue));
		setForeground(new Color(255 - red, 255 - green, 255 - blue));

	}

	public static void main(String[] args) {

		// Initialization new frame
		JFrame window = new JFrame("Picker");

		Task5 panel = new Task5(500, 600);

		window.add(panel);
		window.setSize(500, 700);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

	}

}