package exercise2;

import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;

import javax.swing.ScrollPaneConstants;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StudentInformationDemoFX extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		//Declaring label array
		
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
		rightPane.setHgap(5);
		rightPane.setVgap(5);
		
		GridPane centerPane = new GridPane();
		centerPane.setAlignment(Pos.BOTTOM_CENTER);
		centerPane.setHgap(5);
		centerPane.setVgap(5);
		
		FlowPane flowPane = new FlowPane();
		flowPane.setPadding(new Insets(11,12,13,14));

		
		 Label[] myLabel;
		//Declaring label names array
		  String[] names = { "Name:", "Address:", "Province:", "City:", "Postal Code:", "Phone number:",
				"Email:" };
		//Declaring text field array
		 TextField[] myTxt;
		//Declaring check boxes
		  CheckBox checkStudentCouncil, checkVolunteerWork;
		//Declaring radio buttons
		  RadioButton radioComputerScience, radioBusiness;
		//Declaring radio button group
		  ToggleGroup  groupStudentMajor;
		//Declaring combo box to hold string values
		  ComboBox<String> course;
		//Declaring a JList to display courses selected
		 ListView<String> courseList;
		//Declaring a list model to manipulate the JList element
		 ObservableList<String> listModel =  FXCollections.observableArrayList();
		//Declaring a button to display the information
		  Button display;
		//Declaring a text area that will contain information about the student
		  TextArea output;
		//Declaring scroll pane that will be attached to the text area
		  ScrollPane scroll;
		  
		//Creating check boxes
			checkStudentCouncil = new CheckBox("Student Council");
			checkVolunteerWork = new CheckBox("Volunteer Work");

			//Creating radio buttons
			radioComputerScience = new RadioButton("Computer Science");
			radioBusiness = new RadioButton("Business");
			
			//Creating radio button group and adding radio buttons to it
			groupStudentMajor = new ToggleGroup();
			
			radioComputerScience.setToggleGroup(groupStudentMajor);
			radioBusiness.setToggleGroup(groupStudentMajor);

			//Creating and configuring combo box
			course = new ComboBox<String>();
			course.setVisibleRowCount(3);
			course.setPrefSize(248, 60);
			
			//Creating ListView element
			courseList = new ListView<String>();
			courseList.setPrefSize(1, 100);
			courseList.setPrefWidth(1);

			//Creating button to display information
			display = new Button("Display");
			GridPane.setHalignment(display, HPos.CENTER);

			//Creating text area that will hold information
			output = new TextArea();
			output.setPrefColumnCount(75);
			output.setPrefRowCount(4);
			output.setEditable(true);
			
			//Creating scroll bar and attaching it to the text area
			scroll = new ScrollPane(output);
			scroll.setVbarPolicy(ScrollBarPolicy.ALWAYS);
			scroll.setHbarPolicy(ScrollBarPolicy.ALWAYS);
			GridPane.setHalignment(scroll, HPos.CENTER);
		  
		//Initializing label and text field array
		  myLabel = new Label[names.length];
		  myTxt = new TextField[names.length];
		  
		  for (int i = 0; i < names.length; i++) {

				myLabel[i] = new Label(names[i]);
				myTxt[i] = new TextField();
				leftPane.add(myLabel[i], 0, i);
				leftPane.add(myTxt[i], 35, i);

			}
  
		 leftPane.add(checkVolunteerWork, 40, 1);
		 leftPane.add(checkStudentCouncil, 40, 4);
		 
		 flowPane.getChildren().addAll(radioComputerScience, radioBusiness);
	
		 rightPane.add(flowPane, 120, 0);
		 
		 
		 rightPane.add(course, 120, 2);
		 rightPane.add(courseList, 120, 3);
		 
		 centerPane.add(display, 0, 50);
		 centerPane.add(scroll, 0, 51);
		 
		 root.getChildren().add(leftPane);
		 root.getChildren().add(rightPane);
		 root.getChildren().add(centerPane);
		 
		  Scene scene = new Scene(root, 850, 400);
		  
			primaryStage.setTitle("Student Information Form");
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
