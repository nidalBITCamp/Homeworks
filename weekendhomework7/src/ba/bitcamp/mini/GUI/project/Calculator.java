package ba.bitcamp.mini.GUI.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JFrame {

	private static final long serialVersionUID = -2055799360270358389L;

	// Assist variables
	private String sum = " ";
	private String sum1 = " ";
	private double first = 0;
	private boolean look;
	private boolean check = true;
	private char tmp;

	// Declaration of panels, buttons, text fields and arrays
	private JPanel display = new JPanel();
	private JPanel numPad = new JPanel();
	private JPanel operation = new JPanel();
	private JPanel remove = new JPanel();
	private JTextField info = new JTextField(sum);
	private JTextField info1 = new JTextField(sum1);
	private JButton[] buttons = new JButton[12];
	private String characters[] = { "+", "-", "/", "x", " - / +" };
	private JButton[] buttons1 = new JButton[characters.length];
	private String symbols[] = { "AC", " C ", " OFF " };
	private JButton[] buttons2 = new JButton[symbols.length];
	private Font f = new Font("Serif", Font.BOLD, 25);

	public Calculator() {

		// Check operating system for look
		int num = JOptionPane.showConfirmDialog(null,
				"Do you use the Windows operating system");

		if (num == JOptionPane.YES_OPTION) {
			look = true;
		} else if (num == JOptionPane.NO_OPTION) {
			look = false;
		} else {
			System.exit(3);
		}

		// Set border layout to frame
		setLayout(new BorderLayout());

		// Add panels display, numPad , operation and remove
		add(display, BorderLayout.NORTH);
		add(numPad, BorderLayout.CENTER);
		add(operation, BorderLayout.EAST);
		add(remove, BorderLayout.WEST);

		// Set the title
		display.setBorder(BorderFactory.createTitledBorder("Display"));
		numPad.setBorder(BorderFactory.createTitledBorder("Num Pad"));
		operation.setBorder(BorderFactory.createTitledBorder("Operation"));
		remove.setBorder(BorderFactory.createTitledBorder("Version 1.0"));

		// Set buttons for numeric pad
		numPad.setLayout(new GridLayout(4, 4));

		for (int i = 0; i < 10; i++) {
			buttons[i] = new JButton("" + (9 - i));
			buttons[i].setPreferredSize(new Dimension(10, 20));
			buttons[i].setFont(f);

			if (look == false) {
				buttons[i].setBackground(Color.DARK_GRAY);
				buttons[i].setOpaque(true);
				buttons[i].setBorderPainted(true);
			}

			buttons[i].addActionListener(new ActionNum());
			numPad.add(buttons[i]);
		}

		// Set assist buttons
		buttons[10] = new JButton(".");
		buttons[10].addActionListener(new ActionNum());
		buttons[10].setFont(f);

		if (look == false) {
			buttons[10].setBackground(Color.GRAY);
			buttons[10].setOpaque(true);
			buttons[10].setBorderPainted(true);
			buttons[10].setForeground(Color.RED);
		} else {
			buttons[10].setBackground(Color.LIGHT_GRAY);
			buttons[10].setForeground(Color.BLACK);

		}

		numPad.add(buttons[10]);
		buttons[11] = new JButton(" = ");
		buttons[11].setFont(f);

		if (look == false) {
			buttons[11].setBackground(Color.GRAY);
			buttons[11].setOpaque(true);
			buttons[11].setBorderPainted(true);
			buttons[11].setForeground(Color.RED);
		}
		buttons[11].addActionListener(new ActionNum());
		numPad.add(buttons[11]);

		// Set buttons for operation
		operation.setLayout(new GridLayout(5, 5));

		for (int i = 0; i < characters.length; i++) {
			buttons1[i] = new JButton("" + characters[i]);
			buttons1[i].setPreferredSize(new Dimension(100, 50));
			buttons1[i].setFont(f);

			if (look == false) {
				buttons1[i].setForeground(Color.RED);
				buttons1[i].setBackground(Color.GRAY);
				buttons1[i].setOpaque(true);
				buttons1[i].setBorderPainted(true);
			} else {
				buttons1[i].setForeground(Color.RED);
			}

			buttons1[i].addActionListener(new ActionNum());
			operation.add(buttons1[i]);

		}

		// Set buttons for delete input
		remove.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < symbols.length; i++) {
			buttons2[i] = new JButton("" + symbols[i]);
			buttons2[i].setPreferredSize(new Dimension(70, 30));
			buttons2[i].addActionListener(new ActionNum());
			if (look == false) {
				buttons2[i].setForeground(Color.BLUE);
				buttons2[i].setBackground(Color.GRAY);
				buttons2[i].setOpaque(true);

			} else {

				buttons2[i].setForeground(Color.BLUE);
			}
			buttons2[i].addActionListener(new ActionNum());
			remove.add(buttons2[i]);

		}

		// Set label for display
		display.setLayout(new GridLayout(2, 2));
		info.setFont(f);
		info.setForeground(Color.BLUE);
		info1.setFont(f);
		info1.setForeground(Color.DARK_GRAY);
		info1.setEditable(false);
		info.setEditable(false);
		display.add(info);
		display.add(info1);

		setSize(500, 500);
		setTitle(" Calculator ");
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * This class present class with action listener for used to all buttons on
	 * frame
	 * 
	 * @author Niddal
	 *
	 */
	public class ActionNum implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// Set value of sum from numeric pad buttons
			for (int i = 0; i < 10; i++) {

				if (e.getSource() == buttons[i]) {
					sum += buttons[i].getText();
					info.setText(sum);
					sum1 += buttons[i].getText();
					info1.setText(sum1);

					if (check == true) {
						first = Double.parseDouble(info.getText());
					}
				}
			}

			// Buttons " . "
			if (e.getSource() == buttons[10]) {
				sum += buttons[10].getText();
				info.setText(sum);
				sum1 += buttons[10].getText();
				info1.setText(sum1);
				buttons[10].setEnabled(false);

			}

			// Set the type of operations ( +, -, /, X and +/-)
			if (e.getSource() == buttons1[0]) {
				tmp = '+';
				sum = "";
				info.setText(sum);
				sum1 = String.valueOf(first) + buttons1[0].getText();
				info1.setText(sum1);
				check = false;
				buttons[10].setEnabled(true);
			}
			if (e.getSource() == buttons1[1]) {
				tmp = '-';
				sum = "";
				info.setText(sum);
				sum1 = String.valueOf(first) + buttons1[1].getText();
				info1.setText(sum1);
				check = false;
				buttons[10].setEnabled(true);
			}
			if (e.getSource() == buttons1[2]) {
				tmp = '/';
				sum = "";
				info.setText(sum);
				sum1 = String.valueOf(first) + buttons1[2].getText();
				info1.setText(sum1);
				check = false;
				buttons[10].setEnabled(true);
			}
			if (e.getSource() == buttons1[3]) {
				tmp = '*';
				sum = "";
				info.setText(sum);
				sum1 = String.valueOf(first) + buttons1[3].getText();
				info1.setText(sum1);
				check = false;
				buttons[10].setEnabled(true);

			}
			if (e.getSource() == buttons1[4]) {

				info.setText(sum);
				first = first * (-1);
				sum1 = (String.valueOf(first));
				info1.setText(sum1);
				check = false;
				buttons[10].setEnabled(true);
			}

			// Set action for remove buttons
			if (e.getSource() == buttons2[0]) {

				sum = "";
				sum1 = "";
				info.setText(sum);
				info1.setText(sum1);
				check = true;
				buttons[10].setEnabled(true);
				first = 0;

			}
			if (e.getSource() == buttons2[1]) {

				sum1 = " ";
				sum = " ";
				info1.setText(sum);
				buttons[10].setEnabled(true);
				check = true;

			}

			if (e.getSource() == buttons2[2]) {

				int num = JOptionPane.showConfirmDialog(null,
						" Do you want exit");
				if (num == JOptionPane.YES_OPTION) {
					System.exit(3);
				}
			}

			// Button " = " , and get results
			if (e.getSource() == buttons[11]) {
				try {
					switch (tmp) {

					case '+':
						first = first + Double.parseDouble(info.getText());
						info.setText(String.valueOf(first));
						break;
					case '-':
						first = first - Double.parseDouble(info.getText());
						info.setText(String.valueOf(first));
						break;
					case '/':
						first = first / Double.parseDouble(info.getText());
						info.setText(String.valueOf(first));
						break;
					case '*':
						first = first * Double.parseDouble(info.getText());
						info.setText(String.valueOf(first));
						break;

					default:

						info.setText(String.valueOf(first));
					}
				} catch (NumberFormatException t) {

					JOptionPane.showMessageDialog(null, "Wrong input");

				}

			}

		}
	}

	public static void main(String[] args) {

		new Calculator();

	}
}