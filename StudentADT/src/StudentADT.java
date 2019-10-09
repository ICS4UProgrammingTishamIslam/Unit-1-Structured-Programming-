/*
 * Created by: Tisham Islam
 * Created on: 03-Oct-2019
 * Created for: ICS4U
 * Day #15 (Student ADT)
 * This is a program that lets you enter and then stores student information using an ADT
*/

import java.util.*;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Spinner;


class Student {
	public String firstName;
	public String middleInitial;
	public String lastName;
	public int grade;
	public boolean identified;
	
	public Student(String fName, String mInit, String lName, int grade, boolean identified) {
		this.firstName = fName;
		this.middleInitial = mInit;
		this.lastName= lName;
		this.grade = grade;
		this.identified = identified;
		}
	
	public String GetFirstName() {
		return this.firstName;
	}
	
	
	public String GetFullName() {
		
		String output = this.firstName + this.middleInitial + this.lastName;
		
		return output;
	}
	
	
	public String GetInfo() {
		
		String output = "";
		
		output += GetFullName() + "is in grade " + this.grade + " and is ";
		
		if (!this.identified) {
			output += "not ";
		}
		
		output += "identifed.";
		
		return output;
	}
}

public class StudentADT {

	protected Shell shell;
	private Text txtFirstName;
	private Text txtLastName;
	private Text txtMiddleInitial;
	private Label lblGrade;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			StudentADT window = new StudentADT();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		List<Student> studentList = new ArrayList<Student>();
		
		Label lblFirstName = new Label(shell, SWT.NONE);
		lblFirstName.setBounds(20, 30, 90, 15);
		lblFirstName.setText("First Name:");
		
		Label lblLastName = new Label(shell, SWT.NONE);
		lblLastName.setBounds(20, 75, 90, 15);
		lblLastName.setText("Last Name:");

		Label lblMiddleInitial = new Label(shell, SWT.NONE);
		lblMiddleInitial.setBounds(20, 120, 90, 15);
		lblMiddleInitial.setText("Middle Initial:");
		
		txtFirstName = new Text(shell, SWT.BORDER);
		txtFirstName.setBounds(120, 30, 90, 20);
		
		txtLastName = new Text(shell, SWT.BORDER);
		txtLastName.setBounds(120, 75, 90, 20);
		
		txtMiddleInitial = new Text(shell, SWT.BORDER);
		txtMiddleInitial.setBounds(120, 120, 90, 20);
		
		lblGrade = new Label(shell, SWT.NONE);
		lblGrade.setBounds(20, 165, 90, 15);
		lblGrade.setText("Grade:");

		Spinner spnGrade = new Spinner(shell, SWT.BORDER);
		spnGrade.setMaximum(12);
		spnGrade.setMinimum(1);
		spnGrade.setBounds(120, 165, 47, 22);
		
		Button btnIdentified = new Button(shell, SWT.CHECK);
		btnIdentified.setBounds(20, 210, 90, 15);
		btnIdentified.setText("Identified");
		
		Button btnEnter = new Button(shell, SWT.NONE);
		btnEnter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				new Student(txtFirstName.getText(), txtMiddleInitial.getText(), 
						txtLastName.getText(), spnGrade.getSelection(), btnIdentified.getSelection());
				
				//studentList.add(Student.GetFirstName());
				
			}
		});
		btnEnter.setBounds(135, 200, 75, 25);
		btnEnter.setText("Enter");

	}

}
