package ba.bitcamp.homework17.tasks;


public class Test2 {

	public static void main(String[] args) {

		char[] macAddress = { '0', '1', '2', '3', '7', '1', '0', '1', '0', '6',
				'2', '1' };

		Server s = new Server("Server1", macAddress, 2);

		Client c = new Client("Client1", macAddress);
		Client c1 = new Client("Client2", macAddress);
		Client c2 = new Client("Client3", macAddress);
		Client c3 = new Client("Client4", macAddress);

		BusNetwork bn1 = new BusNetwork("Network1");

		bn1.addComputer(c);
		bn1.addComputer(c2);
		bn1.addComputer(c1);
		bn1.addComputer(c3);

		System.out.println(bn1);

		StarNetwork sn = new StarNetwork("Network 2", s);
		c2.disconnect();
		sn.addComputer(c2);
		c.disconnect();
		sn.addComputer(c);
		c3.disconnect();
		sn.addComputer(c3);
		System.out.println(sn);

	}

}
