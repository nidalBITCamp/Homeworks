package Task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * This class present class which calculated number of repetitions of first
 * letter in the file
 * 
 * @author Niddal.Salkic
 *
 */
public class FileThread {

	// Declaration global variables
	static LinkedBlockingQueue<Task> tasks;
	static ArrayList<Worker> workers;
	static BufferedReader br = null;
	static String line;
	static Integer count = 0;
	static Object lock = new Object();
	static Character testing;

	public static void main(String[] args) {

		// Declaration of tasks and workers
		tasks = new LinkedBlockingQueue<>();
		workers = new ArrayList<>();

		try {

			String testingLine;
			br = new BufferedReader(new FileReader("testing.txt"));

			// get first line and first letters of first word
			line = br.readLine();
			testing = line.charAt(0);

			// Make task for first sentence
			Task firstJob = new Task(line, testing);
			tasks.add(firstJob);

			// Reading the file and adding job to tasks
			while (br.ready()) {

				testingLine = br.readLine();
				Task job = new Task(testingLine, testing);
				tasks.add(job);

			}

			// Declaration and adding four workers
			for (int i = 0; i < 4; i++) {
				Worker s = new Worker();
				s.start();

				try {
					s.join();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

				workers.add(s);
			}

		} catch (IOException e) {
			System.out.println("Something went wrong.... IOException");
			e.printStackTrace();
		}

		System.out.println("Number of repetitions of first letter " + testing
				+ " in the file: " + count);

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
					System.out
							.println("The thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, "
									+ "either before or during the activity. ");
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

		private String line;
		private Character test;

		public Task(String line, char test) {
			super();
			this.line = line;
			this.test = test;
		}

		@Override
		public void run() {

			for (int i = 0; i < line.length(); i++) {

				if (Character.toString(test).equalsIgnoreCase(
						Character.toString(line.charAt(i)))) {

					synchronized (lock) {

						count++;
					}

				}
			}

		}
	}

}
