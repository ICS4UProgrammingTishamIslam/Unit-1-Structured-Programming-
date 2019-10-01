/*
 * Created by: Tisham Islam
 * Created on: 17-Sep-2019
 * Created for: ICS4U
 * Day #6 (Calculator)
 * This program calculates
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Calculator {

	protected Shell shlCalculateulater;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Calculator window = new Calculator();
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
		shlCalculateulater.open();
		shlCalculateulater.layout();
		while (!shlCalculateulater.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlCalculateulater = new Shell();
		shlCalculateulater.setSize(450, 300);
		shlCalculateulater.setText("Calculate-U-Later by TishamI");
		
		//display what the spinners do
		Label lblNum1 = new Label(shlCalculateulater, SWT.NONE);
		lblNum1.setBounds(10, 15, 55, 15);
		lblNum1.setText("1st Num");
		
		Label lblNum2 = new Label(shlCalculateulater, SWT.NONE);
		lblNum2.setBounds(203, 15, 55, 15);
		lblNum2.setText("2nd Num");
		
		//display the answers
		Label lblCalculations = new Label(shlCalculateulater, SWT.NONE);
		lblCalculations.setBounds(10, 129, 382, 15);
		
		//choose your numbers!
		Spinner spnNum1 = new Spinner(shlCalculateulater, SWT.BORDER);
		spnNum1.setMinimum(-100);
		spnNum1.setBounds(10, 32, 55, 22);
		
		Spinner spnNum2 = new Spinner(shlCalculateulater, SWT.BORDER);
		spnNum2.setMinimum(-100);
		spnNum2.setBounds(203, 32, 55, 22);
		
		//buttons for operations
		Button btnAdd = new Button(shlCalculateulater, SWT.NONE);
		btnAdd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//sets answer by adding/subtracting/multiplying/dividing the spinner's numbers
				lblCalculations.setText("The answer is " + (spnNum1.getSelection() + spnNum2.getSelection()));
			}
		});
		btnAdd.setBounds(11, 76, 75, 25);
		btnAdd.setText("+");
		
		Button btnSubtract = new Button(shlCalculateulater, SWT.NONE);
		btnSubtract.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblCalculations.setText("The answer is " + (spnNum1.getSelection() - spnNum2.getSelection()));
			}
		});
		btnSubtract.setBounds(108, 76, 75, 25);
		btnSubtract.setText("-");
		
		Button btnMultiply = new Button(shlCalculateulater, SWT.NONE);
		btnMultiply.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {				
				lblCalculations.setText("The answer is " + (spnNum1.getSelection() * spnNum2.getSelection()));
			}
		});
		btnMultiply.setBounds(203, 76, 75, 25);
		btnMultiply.setText("X");
		
		Button btnDivide = new Button(shlCalculateulater, SWT.NONE);
		btnDivide.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (spnNum2.getSelection() == 0) {
					lblCalculations.setText("Answer is invalid, dumbass");
					return;
				}
				lblCalculations.setText("The answer is " + (spnNum1.getSelection() / spnNum2.getSelection()));
			}
		});
		btnDivide.setBounds(295, 76, 75, 25);
		btnDivide.setText("/");

	}
}
