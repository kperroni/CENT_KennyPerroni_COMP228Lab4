package exercise1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class StudentInformationFrame extends JFrame implements ActionListener {
	
	private JLabel[] myLabel;
	private final String[] names = { "Name:", "Address:", "Province:", "City:", "Postal Code:", "Phone number:", "Email:" };
	private JTextField[] myTxt;
	private final JCheckBox checkStudentCouncil, checkVolunteerWork;
	private final JRadioButton radioComputerScience, radioBusiness;
	private final ButtonGroup groupStudentMajor;
	private final JComboBox<String> course;
	private final JList<String> courseList;
	private final JButton display;
	private final JTextArea output;
	private final JScrollPane scroll;
	private final JPanel west, east, eastNorth, eastCenter, eastSouth, south, center;
	private final GridLayout gridLayout;
	private final BorderLayout borderLayout;
	private final Box verticalEast = Box.createVerticalBox();

	public StudentInformationFrame() {

		super("Student Information Form");

		checkStudentCouncil = new JCheckBox("Student Council");
		checkVolunteerWork = new JCheckBox("Volunteer Work");

		radioComputerScience = new JRadioButton("Computer Science");
		radioBusiness = new JRadioButton("Business");
		groupStudentMajor = new ButtonGroup();
		groupStudentMajor.add(radioComputerScience);
		groupStudentMajor.add(radioBusiness);

		course = new JComboBox<String>();
		course.addItem("English");
		course.addItem("Java");
		course.addItem("C#");
		course.addItem("CWP");
		course.setMaximumRowCount(3);
		course.setPreferredSize(new Dimension (200,50));
		
		courseList = new JList<String>();

		display = new JButton("Display");

		output = new JTextArea(4, 75);
		output.setEditable(true);
	    scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		west = new JPanel();
		east = new JPanel();
		eastNorth = new JPanel();
		eastCenter = new JPanel();
		eastSouth = new JPanel();
		south = new JPanel();
		center = new JPanel();

		gridLayout = new GridLayout(7, 1, 3, 3);
		borderLayout = new BorderLayout(5, 5);

		setLayout(borderLayout);

		west.setLayout(gridLayout);

		add(west, BorderLayout.WEST);
		add(east, BorderLayout.EAST);
		add(south, BorderLayout.SOUTH);
		add(center, BorderLayout.CENTER);
		
		//south.add(display);
		south.add(scroll);

		myLabel = new JLabel[names.length];
		myTxt = new JTextField[names.length];
		
		for (int i = 0; i < names.length; i++) {

			myLabel[i] = new JLabel(names[i]);
			myTxt[i] = new JTextField(20);
			west.add(myLabel[i]);
			west.add(myTxt[i]);
			
		}
		
		center.setLayout(new BorderLayout(2 ,2));
		center.add(checkStudentCouncil, BorderLayout.NORTH);
		center.add(checkVolunteerWork, BorderLayout.CENTER);
		
		east.setLayout(new BorderLayout(25, 25));
		east.add(eastNorth, BorderLayout.NORTH);
		eastNorth.setLayout(new FlowLayout());
		eastNorth.add(radioComputerScience);
		eastNorth.add(radioBusiness);
		
		east.add(eastCenter, BorderLayout.CENTER);
		eastCenter.setLayout(new GridLayout(1,1));
		eastCenter.add(course);
	
		east.add(eastSouth, BorderLayout.SOUTH);
		eastSouth.setLayout(new GridLayout(2,2));
		eastSouth.add(courseList);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
