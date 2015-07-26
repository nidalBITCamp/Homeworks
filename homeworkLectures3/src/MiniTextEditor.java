import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * 
 * @author Niddal
 *
 */
public class MiniTextEditor extends JFrame {

	private static final long serialVersionUID = -256631337511923838L;

	private int count = 0;
	private int size = 15;
	Editor t = new Editor();

	public MiniTextEditor() {

		setLayout(new BorderLayout());

		// Declaration used swing objects
		JTextArea area = new JTextArea();
		JMenu menu = new JMenu("File");
		JMenu menu1 = new JMenu("Edit");
		JMenu menu2 = new JMenu("Help");
		JMenuBar bar = new JMenuBar();

		// Item for file menu
		JMenuItem item = new JMenuItem(" Open File...");
		JMenuItem item1 = new JMenuItem("Save As...");
		JMenuItem item2 = new JMenuItem("Exit");

		// Item for edit menu
		JMenuItem item3 = new JMenuItem("Clear All..");
		JMenuItem item5 = new JMenuItem("Change font");
		JMenuItem item6 = new JMenuItem("Copy");
		JMenuItem item7 = new JMenuItem("Zoom in");
		JMenuItem item8 = new JMenuItem("Zoom out");

		// Item for help menu
		JMenuItem item4 = new JMenuItem("About editor");

		// Set text area editable and add sliders to area
		area.setEditable(true);
		JScrollPane scroll = new JScrollPane(area);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		// Adding items to menu file
		menu.add(item);
		menu.add(item1);
		menu.add(item2);

		// Adding items to menu edit
		menu1.add(item7);
		menu1.add(item8);
		menu1.add(item6);
		menu1.add(item5);
		menu1.add(item3);
		
		// Adding items to menu help
		menu2.add(item4);

		// Adding menus to menu bar
		bar.add(menu);
		bar.add(menu1);
		bar.add(menu2);

		// Action listener for check your exit from window
		addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {

				t.check(area);

			}
		});

		// Action listener for open specified file and add text to text area
		item.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				t.OpenFile(area);
			}

		});

		// Action listener for save input from text area to specified file
		item1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				t.saveAs(area);

			}
		});

		// Action listener for exit item
		item2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				t.check(area);

			}
		});

		// Action listener for clear item
		item3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				area.setText("");

			}
		});

		// Action listener for font item
		item5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				count++;

				t.setFont(area, count, size);

				if (count == 3) {
					count = 0;
				}
			}
		});

		// Action listener for copy item
		item6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				area.copy();

			}
		});

		// Action listener for zoom in item
		item7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				size += 5;

				area.setFont(new Font("Serif", Font.BOLD, size));

			}
		});

		// Action listener for zoom out item
		item8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				size -= 5;

				area.setFont(new Font("Serif", Font.BOLD, size));
			}
		});

		// Action listener for help item
		item4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane
						.showMessageDialog(
								null,
								"Editor is a simple text editor \n for Microsoft Windows and a basic"
										+ " text-editing program \n which enables computer users to create documents.\n Version 1.0\n BitCamp");

			}
		});

		// Adding menu and text area to frame
		setJMenuBar(bar);
		add(scroll);

		// Set some of option for frame
		setVisible(true);
		setSize(700, 500);
		setTitle("TEXT EDITOR");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {

		new MiniTextEditor();
	}

}
