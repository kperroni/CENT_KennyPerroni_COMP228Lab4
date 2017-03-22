package exercise1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class StudentInformationFrame extends JFrame implements ActionListener, ItemListener, MouseListener {

	// Declaring label array
	private JLabel[] myLabel;
	// Declaring label names array
	private final String[] names = { "Name:", "Address:", "Province:", "City:", "Postal Code:", "Phone number:",
			"Email:" };
	// Declaring text field array
	private JTextField[] myTxt;
	// Declaring check boxes
	private final JCheckBox checkStudentCouncil, checkVolunteerWork;
	// Declaring radio buttons
	private final JRadioButton radioComputerScience, radioBusiness;
	// Declaring radio button group
	private final ButtonGroup groupStudentMajor;
	// Declaring combo box to hold string values
	private final JComboBox<String> course;
	// Declaring a JList to display courses selected
	private JList<String> courseList;
	// Declaring a list model to manipulate the JList element
	private DefaultListModel<String> listModel = new DefaultListModel<String>();
	// Declaring a button to display the information
	private final JButton display;
	// Declaring a text area that will contain information about the student
	private final JTextArea output;
	// Declaring scroll pane that will be attached to the text area
	private final JScrollPane scroll;
	// Declaring panels to organize the content
	private final JPanel west, east, eastNorth, eastCenter, south, southBox, center;

	// Constructor

	public StudentInformationFrame() {

		// Setting title
		super("Student Information Form");

		// Creating check boxes
		checkStudentCouncil = new JCheckBox("Student Council");
		checkVolunteerWork = new JCheckBox("Volunteer Work");

		// Creating radio buttons
		radioComputerScience = new JRadioButton("Computer Science");
		radioBusiness = new JRadioButton("Business");

		// Creating radio button group and adding radio buttons to it
		groupStudentMajor = new ButtonGroup();
		groupStudentMajor.add(radioComputerScience);
		groupStudentMajor.add(radioBusiness);

		// Creating and configuring combo box
		course = new JComboBox<String>();
		course.setMaximumRowCount(3);
		course.setPreferredSize(new Dimension(250, 60));
		course.setSize(new Dimension(100, 500));

		// Creating JList element
		courseList = new JList<String>(listModel);

		// Creating button to display information
		display = new JButton("Display");
		display.setAlignmentX(JComponent.CENTER_ALIGNMENT);

		// Creating text area that will hold information
		output = new JTextArea(4, 75);
		output.setEditable(false);

		// Creating scroll bar and attaching it to the text area
		scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setAlignmentX(JComponent.CENTER_ALIGNMENT);

		// Creating different panels
		west = new JPanel();
		east = new JPanel();
		eastNorth = new JPanel();
		eastCenter = new JPanel();
		south = new JPanel();
		southBox = new JPanel();
		center = new JPanel();

		// Setting frame layout
		setLayout(new BorderLayout(5, 5));

		// Setting west panel layout
		west.setLayout(new GridLayout(7, 1, 3, 3));

		// Adding panels to the frame
		add(west, BorderLayout.WEST);
		add(east, BorderLayout.EAST);
		add(south, BorderLayout.SOUTH);
		add(center, BorderLayout.CENTER);

		// Adding panel to south panel
		south.add(southBox);

		// Setting layout to panel
		southBox.setLayout(new BoxLayout(southBox, BoxLayout.Y_AXIS));
		// Adding button and text area to panel
		southBox.add(display);
		southBox.add(scroll);

		// Initializing label and text field array
		myLabel = new JLabel[names.length];
		myTxt = new JTextField[names.length];

		// Loop to create labels and text fields
		// Adding labels and text fields inside the loop

		for (int i = 0; i < names.length; i++) {

			myLabel[i] = new JLabel(names[i]);
			myTxt[i] = new JTextField(20);
			west.add(myLabel[i]);
			west.add(myTxt[i]);

		}

		// Setting layout to panel
		center.setLayout(new BorderLayout(2, 2));
		// Adding check boxes to panel
		center.add(checkStudentCouncil, BorderLayout.NORTH);
		center.add(checkVolunteerWork, BorderLayout.CENTER);

		// Setting layout to panel
		east.setLayout(new BorderLayout(2, 40));
		// Adding panel inside another panel
		east.add(eastNorth, BorderLayout.NORTH);
		// Setting layout to panel
		eastNorth.setLayout(new FlowLayout());
		// Adding radio buttons to panel
		eastNorth.add(radioComputerScience);
		eastNorth.add(radioBusiness);

		// Adding panel inside another panel
		east.add(eastCenter, BorderLayout.CENTER);
		// Setting layout to panel
		eastCenter.setLayout(new GridLayout(2, 1, 0, 0));
		// Adding combo box and JList to panel
		eastCenter.add(course);
		eastCenter.add(courseList);

		// Adding listener to combo box, button, and radio buttons
		course.addItemListener(this);
		display.addMouseListener(this);
		radioBusiness.addActionListener(this);
		radioComputerScience.addActionListener(this);

	}

	// Listener for radio buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		JRadioButton auxRadio = (JRadioButton) e.getSource();

		// If computer science radio button is selected
		if (auxRadio.getText() == "Computer Science") {

			// Clearing combo box and JList
			course.removeAllItems();
			listModel.removeAllElements();
			// Adding elements to combo box
			course.addItem("");
			course.addItem("PHP");
			course.addItem("Java");
			course.addItem("C#");
			course.addItem("CWP");

		}

		// If business radio button is selected

		else {

			// Clearing combo box and JList
			course.removeAllItems();
			listModel.removeAllElements();
			// Adding elements to combo box
			course.addItem("");
			course.addItem("Quality Service");
			course.addItem("Statistics");
			course.addItem("Business Management");
			course.addItem("Marketing");

		}

	}

	// Listener for combo box
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

		// When an item is selected
		if (e.getStateChange() == ItemEvent.SELECTED) {

			// If the selected item is not in the list, it is added
			if (!listModel.contains(e.getItem().toString()))
				listModel.addElement(e.getItem().toString());

		}

	}

	// Listener for display button
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

		// Creating courses, activities and program variables
		String myCourses = "";
		String otherActivities = "";
		String program = "";

		// Checking which check boxes were selected and assigning the value to
		// otherActivities variable
		if (checkStudentCouncil.isSelected() && checkVolunteerWork.isSelected())

			otherActivities = checkStudentCouncil.getText() + "-" + checkVolunteerWork.getText();

		else if (checkStudentCouncil.isSelected() && !checkVolunteerWork.isSelected())

			otherActivities = checkStudentCouncil.getText();

		else if (checkVolunteerWork.isSelected() && !checkStudentCouncil.isSelected())

			otherActivities = checkVolunteerWork.getText();

		else if (!checkStudentCouncil.isSelected() && !checkVolunteerWork.isSelected())

			otherActivities = "No activities";

		// Checking which radio button was selected and assigning the value to
		// program variable
		if (radioBusiness.isSelected())

			program = radioBusiness.getText();

		else if (radioComputerScience.isSelected())

			program = radioComputerScience.getText();

		else
			program = "No program selected";

		// Clearing text area
		output.setText("");

		// Getting courses from JList and adding the values to myCourses String
		for (int i = 0; i < listModel.size(); i++) {

			myCourses += listModel.getElementAt(i) + "\n";

		}

		// Printing student information in text area
		output.setText(String.format("%s, %s, %s, %s, %s, %s, %s, %s, %s%n%s%s", myTxt[0].getText(), myTxt[1].getText(),
				myTxt[2].getText(), myTxt[3].getText(), myTxt[4].getText(), myTxt[5].getText(), myTxt[6].getText(),
				otherActivities, program, "Courses:", myCourses));

		// Setting text area cursor at the beginning
		output.setCaretPosition(0);

	}

	// Not implemented methods

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
