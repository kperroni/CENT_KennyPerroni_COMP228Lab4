package exercise1;

import javax.swing.JFrame;

public class StudentInformationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Creating object to display frame
		StudentInformationFrame studentInformationFrame = new StudentInformationFrame();
		studentInformationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Setting frame size
		studentInformationFrame.setSize(900, 400);
		// Setting frame visibility
		studentInformationFrame.setVisible(true);
		// Setting frame display = center
		studentInformationFrame.setLocationRelativeTo(null);

	}

}
