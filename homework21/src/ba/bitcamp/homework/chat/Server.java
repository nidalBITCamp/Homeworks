package ba.bitcamp.homework.chat;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 * This class present the server with window for chat with connected client
 * 
 * @author Niddal.salkic
 *
 */
public class Server extends JFrame {

	private static final long serialVersionUID = 8346110717705094243L;
	private static final int CHAT_SIZE = 36;
	static final int PORT = 3333;

	// Declaration new swing object for this window
	private JPanel input = new JPanel(new FlowLayout(FlowLayout.TRAILING));
	private JTextArea history = new JTextArea();
	private JTextField chat = new JTextField();
	private JButton send = new JButton("SEND");

	// Declaration new server and client
	private ServerSocket server = null;
	private Socket client = null;

	public Server() throws IOException {

		// Set window layout to Border layout
		setLayout(new BorderLayout());

		// Add action listener to send button
		send.setSize(getMinimumSize());
		send.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					BufferedWriter writer = new BufferedWriter(
							new OutputStreamWriter(client.getOutputStream()));
					writer.write(chat.getText());
					writer.newLine();
					writer.flush();

					history.append("Server: " + chat.getText() + "\n");

				} catch (IOException e1) {

					e1.printStackTrace();
				}
				chat.setText("");
			}
		});

		// Add scroll to text area
		history.setEditable(false);
		history.setFont(new Font("Serif", Font.BOLD, 14));
		JScrollPane scroll = new JScrollPane(history);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// Set the title for text area and text field
		history.setBorder(BorderFactory
				.createTitledBorder("  Chat history... "));
		chat.setBorder(BorderFactory.createTitledBorder(" Chat window "));

		// Set columns for text field
		chat.setColumns(CHAT_SIZE);

		// Adding text field - chat, and button - send to JPanel
		input.add(chat);
		input.add(send);

		// Adding Text area - history, and JPanel input to window
		add(scroll, BorderLayout.CENTER);
		add(input, BorderLayout.SOUTH);

		// Set some of option for window
		setSize(500, 300);
		setResizable(false);
		setTitle("   Server chat   ");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		// Set server to specified port
		server = new ServerSocket(PORT);
		client = server.accept();

		// Set text to text area with method
		setAreaText(history, client, "Client");

	}

	/**
	 * Method for set text to text area with buffer reader
	 * 
	 * @param area
	 *            - JTextArea
	 * @param client
	 *            - Socket client
	 * @throws IOException
	 */
	public static void setAreaText(JTextArea area, Socket client, String user)
			throws IOException {

		String text = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				client.getInputStream()));

		while ((text = reader.readLine()) != null) {

			area.append(user + ": " + ChatUtility.function(text) + "\n");

		}

	}

	public static void main(String[] args) {

		try {
			new Server();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
