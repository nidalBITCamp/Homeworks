package ba.bitcamp.queueDouble.homework;

public class Main {

	public static void main(String[] args) {

		// Testing  queue double array 

		QueueDoubleArray qa = new QueueDoubleArray();

		qa.add(2.1);
		qa.offer(1.1);
		System.out.println(qa);
		System.out.println(qa.peek());
		System.out.println(qa.remove());
		System.out.println(qa);

		Long start = System.currentTimeMillis();
		for (int i = 1; i < 10000; i++) {

			qa.add(i + 1.0);

		}

		System.out.println("Array time: "
				+ (System.currentTimeMillis() - start));

		System.out.println();
		
		///////////////////////////////////////////////////
		
		
		// Testing  queue double link
		
		QueueDoubleLink ql = new QueueDoubleLink();
		
		ql.add(1.3);
		ql.add(1.1);
		ql.add(5.5);
		System.out.println(ql);
		
		System.out.println(ql.peek());
		System.out.println(ql.poll());
		System.out.println(ql);
		
		Long start1 = System.currentTimeMillis();

		for (int i = 1; i < 10000; i++) {
			ql.add( i + 1.0);
		}

		System.out.println("Link time: "+ (System.currentTimeMillis() - start1));


	}

}
