package exercise2;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StudentInformationDemoFX extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		// Declaring grid panes
		GridPane root = new GridPane();
		root.setAlignment(Pos.TOP_LEFT);
		root.setHgap(5);
		root.setVgap(5);

		GridPane leftPane = new GridPane();
		leftPane.setAlignment(Pos.TOP_LEFT);
		leftPane.setHgap(5);
		leftPane.setVgap(5);

		GridPane rightPane = new GridPane();
		rightPane.setAlignment(Pos.TOP_LEFT);
		rightPane.setHgap(2);
		rightPane.setVgap(5);

		GridPane rightLeftContainer = new GridPane();
		rightLeftContainer.setAlignment(Pos.TOP_LEFT);
		rightLeftContainer.setHgap(2);
		rightLeftContainer.setVgap(5);

		GridPane bottomPane = new GridPane();
		bottomPane.setAlignment(Pos.BOTTOM_CENTER);
		bottomPane.setHgap(5);
		bottomPane.setVgap(5);

		GridPane radioPane = new GridPane();
		radioPane.setAlignment(Pos.BOTTOM_CENTER);
		radioPane.setHgap(5);
		radioPane.setVgap(5);

		// Declaring label array
		Label[] myLabel;
		// Declaring label names array
		String[] names = { "Name:", "Address:", "Province:", "City:", "Postal Code:", "Phone number:", "Email:" };
		// Declaring text field array
		TextField[] myTxt;
		// Declaring check boxes
		CheckBox checkStudentCouncil, checkVolunteerWork;
		// Declaring radio buttons
		RadioButton radioComputerScience, radioBusiness;
		// Declaring radio toggle group
		ToggleGroup groupStudentMajor;
		// Declaring combo box to hold string values
		ComboBox<String> course;
		// Declaring a list view to display courses selected
		ListView<String> courseList;
		// Declaring a list view model to manipulate the List element
		ObservableList<String> listModel = FXCollections.observableArrayList();
		// Values for list view
		ObservableList<String> computerScienceCourses = FXCollections.observableArrayList("C#", "Java", "C++", "PHP",
				"Python");

		ObservableList<String> businessCourses = FXCollections.observableArrayList("Statistics", "Business Management",
				"Human Resources", "Communications", "English");

		// Declaring a button to display the information
		Button display;
		// Declaring a text area that will contain information about the student
		TextArea output;
		// Declaring scroll pane that will be attached to the text area
		ScrollPane scroll;

		// Creating check boxes
		checkStudentCouncil = new CheckBox(String.format("%-30s", "Student Council"));
		checkVolunteerWork = new CheckBox("Volunteer Work");

		// Creating radio buttons
		radioComputerScience = new RadioButton("Computer Science");
		radioBusiness = new RadioButton("Business");

		// Creating radio button group and adding radio buttons to it
		groupStudentMajor = new ToggleGroup();

		radioComputerScience.setToggleGroup(groupStudentMajor);
		radioBusiness.setToggleGroup(groupStudentMajor);

		// Creating and configuring combo box
		course = new ComboBox<String>();
		course.setVisibleRowCount(3);
		course.setPrefSize(300, 60);

		// Creating ListView element
		courseList = new ListView<String>(listModel);
		courseList.setPrefSize(1, 100);

		// Creating button to display information
		display = new Button("Display");
		GridPane.setHalignment(display, HPos.CENTER);

		// Creating text area that will hold information
		output = new TextArea();
		output.setPrefColumnCount(75);
		output.setPrefRowCount(6);
		output.setEditable(false);

		// Creating scroll bar and attaching it to the text area
		scroll = new ScrollPane(output);
		scroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		scroll.setHbarPolicy(ScrollBarPolicy.ALWAYS);
		GridPane.setHalignment(scroll, HPos.CENTER);

		// Initializing label and text field array
		myLabel = new Label[names.length];
		myTxt = new TextField[names.length];

		for (int i = 0; i < names.length; i++) {

			myLabel[i] = new Label(String.format("%-30s", names[i]));
			myTxt[i] = new TextField();
			leftPane.add(myLabel[i], 0, i);
			leftPane.add(myTxt[i], 5, i);

		}

		// Adding elements to left pane
		leftPane.add(checkVolunteerWork, 6, 1);
		leftPane.add(checkStudentCouncil, 6, 4);

		// Adding radio buttons to radio pane
		radioPane.add(radioComputerScience, 0, 0);
		radioPane.add(radioBusiness, 1, 0);

		// Adding elements to right pane
		rightPane.add(radioPane, 7, 0);
		rightPane.add(course, 7, 2);
		rightPane.add(courseList, 7, 3);

		// Adding elements to bottom pane
		bottomPane.add(display, 0, 6);
		bottomPane.add(scroll, 0, 7);

		rightLeftContainer.add(leftPane, 0, 0);
		rightLeftContainer.add(rightPane, 1, 0);

		// Adding elements to root pane
		root.add(rightLeftContainer, 0, 0);
		root.add(bottomPane, 0, 1);

		// Adding listener to combo box, button, and radio buttons
		groupStudentMajor.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

			public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

				RadioButton checked = (RadioButton) groupStudentMajor.getSelectedToggle();

				if (checked.getText().equals("Computer Science")) {
					course.getSelectionModel().clearSelection();
					listModel.clear();
					course.setItems(computerScienceCourses);
				}

				else {
					if (checked.getText().equals("Business")) {
						course.getSelectionModel().clearSelection();
						listModel.clear();
						course.setItems(businessCourses);
					}
				}

			}
		});

		course.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String t1, String t2) {
				// TODO Auto-generated method stub
				if (!listModel.contains(t2) && t2 != null) {
					listModel.add(t2);
				}
			}
		});

		display.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub

				// Creating courses, activities and program variables
				String myCourses = "";
				String otherActivities = "";
				String program = "";

				// Checking which check boxes were selected and assigning the
				// value to otherActivities variable
				if (checkStudentCouncil.isSelected() && checkVolunteerWork.isSelected())

					otherActivities = checkStudentCouncil.getText().trim() + "-" + checkVolunteerWork.getText().trim();

				else if (checkStudentCouncil.isSelected() && !checkVolunteerWork.isSelected())

					otherActivities = checkStudentCouncil.getText().trim();

				else if (checkVolunteerWork.isSelected() && !checkStudentCouncil.isSelected())

					otherActivities = checkVolunteerWork.getText().trim();

				else if (!checkStudentCouncil.isSelected() && !checkVolunteerWork.isSelected())

					otherActivities = "No activities";

				// Checking which radio button was selected and assigning the
				// value to program variable
				if (radioBusiness.isSelected())

					program = radioBusiness.getText();

				else if (radioComputerScience.isSelected())

					program = radioComputerScience.getText();

				else
					program = "No program selected";

				// Clearing text area
				output.setText("");

				// Getting courses from JList and adding the values to myCourses
				// String
				for (int i = 0; i < listModel.size(); i++) {

					myCourses += listModel.get(i) + "\n";

				}

				// Printing student information in text area
				output.setText(String.format("%s, %s, %s, %s, %s, %s, %s, %s, %s%n%s%n%s", myTxt[0].getText(),
						myTxt[1].getText(), myTxt[2].getText(), myTxt[3].getText(), myTxt[4].getText(),
						myTxt[5].getText(), myTxt[6].getText(), otherActivities, program, "Courses:", myCourses));

				// Setting text area cursor at the beginning
				output.positionCaret(0);

			}

		});

		// Creating scene
		Scene scene = new Scene(root, 850, 400);

		// Configuring stage
		primaryStage.setTitle("Student Information Form");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
