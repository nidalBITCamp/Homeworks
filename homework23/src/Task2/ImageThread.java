package Task2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class represents a negative modifier certain image
 * 
 * @author Niddal.Salkic
 *
 */
public class ImageThread extends JFrame {

	private static final long serialVersionUID = -6189875705245189368L;

	private static BufferedImage image = null;
	private static JPanel window;
	private static LinkedBlockingQueue<Task> tasks;
	private static ArrayList<Worker> workers;
	private static int start = 0;
	private static int end = 10;

	public ImageThread() {

		// Upload picture
		try {
			image = ImageIO.read(new File("picture.jpg"));
		} catch (IOException e) {

			e.printStackTrace();
		}

		// Set panel and addin them to window
		window = new MyPanel();
		window.setBorder(BorderFactory.createTitledBorder("  Picture: "));
		add(window);

		// Set some of option for window
		setSize(1200, 700);
		setResizable(false);
		setTitle("   Negative picture   ");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// Declaration of tasks and workers
		tasks = new LinkedBlockingQueue<>();
		workers = new ArrayList<>();

		for (int i = 0; i < 130; i++) {

			tasks.add(new Task(start, end));

			start += 10;
			end += 10;
		}

		// Declaration and adding workers
		for (int i = 0; i < 16; i++) {
			Worker s = new Worker();
			s.start();

			try {
				s.join();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			workers.add(s);

		}

	}

	/**
	 * This class present the worker of task, which extends Thread
	 */
	public static class Worker extends Thread {

		@Override
		public void run() {

			while (!tasks.isEmpty()) {
				try {
					Task job = tasks.take();
					job.run();
				} catch (InterruptedException e) {
					break;
				}
			}
		}
	}

	/**
	 * This class present the task of worker, which implements Runnable
	 * 
	 * @author Niddal.Salkic
	 *
	 */
	public static class Task implements Runnable {

		private int start;
		private int end;

		public Task(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public void run() {

			try {
				for (int row = start; row < end; row++) {
					for (int col = 0; col < image.getHeight(); col++) {
						int pixel = image.getRGB(row, col);
						System.out.println(pixel);
						image.setRGB(row, col, 255 - pixel);
					}
				}

			} catch (ArrayIndexOutOfBoundsException e) {

				System.out.println("End");

			}
		}

	}

	/**
	 * This class present JPanel with picture
	 * 
	 * @author Niddal
	 *
	 */
	public static class MyPanel extends JPanel {

		private static final long serialVersionUID = 2842573446138222691L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			g.drawImage(image, 100, 0, image.getWidth(), image.getHeight(),
					null);
			repaint();
		}

	}

	public static void main(String[] args) {

		new ImageThread();
	}

}
