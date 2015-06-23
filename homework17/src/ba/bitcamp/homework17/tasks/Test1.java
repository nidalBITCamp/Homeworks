package ba.bitcamp.homework17.tasks;

public class Test1 {

	public static void main(String[] args) {

		char[] macAddress = { '0', '1', '2', '3', '7', '1', '0', '1', '0', '6',
				'2', '1' };

		Server s = new Server("Server1", macAddress, 2);

		Client c = new Client("Client1", macAddress );
		Client c1 = new Client("Client2", macAddress);
		Client c2 = new Client("Client3", macAddress);

		System.out.println(s);
		System.out.println(c);

		c.connect(s);
		c.disconnect();
		c.connect(s);
		c1.connect(s);
		c2.connect(s);

		System.out.println(s);
		System.out.println(c);
		System.out.println(c1);
		System.out.println(c2);

	}

}
