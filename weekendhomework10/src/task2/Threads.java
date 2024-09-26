package task2;

/**
 * This class present three threads who printed specified text in different
 * intervals, with specified orders: Third print when second is finished and the
 * second when the first is completed
 * 
 * @author Niddal.Salkic
 *
 */
public class Threads {

	public static void main(String[] args) {

		// Declaration first thread and starting them
		MyThreads m1 = new MyThreads(1);
		Thread t1 = new Thread(m1);
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			System.out
					.println("The thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity.");
			e.printStackTrace();
		}

		// Declaration second thread and starting them
		MyThreads m2 = new MyThreads(2);
		Thread t2 = new Thread(m2);
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			System.out
					.println("The thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity.");
			e.printStackTrace();
		}

		// Declaration third thread and starting them
		MyThreads m3 = new MyThreads(3);
		Thread t3 = new Thread(m3);
		t3.start();

	}

	/**
	 * This class is inner class which present threads with implements Runnable
	 * interface
	 * 
	 * @author Niddal.Salkic
	 *
	 */
	static class MyThreads implements Runnable {

		private Integer index;

		public MyThreads(Integer index) {

			this.index = index;
		}

		/**
		 * Run method for thread
		 */
		@Override
		public void run() {

			if (index.equals(1)) {

				for (int i = 1; i <= 10; i++) {
					System.out.println(i);

					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						System.out
								.println("The thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity.");
						e.printStackTrace();
					}
				}

			} else if (index.equals(2)) {

				for (int i = 1; i < 5; i++) {

					System.out.println("BitCamp");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			} else if (index.equals(3)) {

				for (int i = 1; i <= 5; i++) {

					System.out.println((int) (Math.random() * 5 + 1));
					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {
						System.out
								.println("The thread is waiting, sleeping, or otherwise occupied, and the thread is interrupted, either before or during the activity.");
						e.printStackTrace();
					}
				}

			} else
				System.out.println("Wrong input");
		}
	}

}
