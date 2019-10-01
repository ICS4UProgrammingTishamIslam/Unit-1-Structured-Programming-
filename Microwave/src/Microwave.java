/*
 * Created by: Tisham Islam
 * Created on: 17-Sep-2019
 * Created for: ICS4U
 * Day #7 (Microwave)
 * This program calculates the amount of time various food items will take in the microwave to reheat
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Microwave {

	protected Shell shlMicrowaveByTisham;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Microwave window = new Microwave();
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
		shlMicrowaveByTisham.open();
		shlMicrowaveByTisham.layout();
		while (!shlMicrowaveByTisham.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMicrowaveByTisham = new Shell();
		shlMicrowaveByTisham.setSize(450, 300);
		shlMicrowaveByTisham.setText("Microwave by TishamI");
		
		//tells you what to do. shocker
		Label lblWhatToDo = new Label(shlMicrowaveByTisham, SWT.WRAP);
		lblWhatToDo.setBounds(22, 10, 239, 39);
		lblWhatToDo.setText("Choose a food item and the number of foods you wish to re heat in the microwave");
		
		//submarine radio button. the tasty kind
		Button radSub = new Button(shlMicrowaveByTisham, SWT.RADIO);
		radSub.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		radSub.setBounds(146, 70, 90, 16);
		radSub.setText("Sub");
		
		//soup radio button
		Button radSoup = new Button(shlMicrowaveByTisham, SWT.RADIO);
		radSoup.setSelection(true);
		radSoup.setBounds(54, 70, 90, 16);
		radSoup.setText("Soup");
		
		//pizza radio button
		Button radPizza = new Button(shlMicrowaveByTisham, SWT.RADIO);
		radPizza.setBounds(242, 70, 90, 16);
		radPizza.setText("Pizza");
		
		//spinner for choosing how much food you want to heat up. who the heck heats up 3 bowls of soup at once?
		Spinner spnNum = new Spinner(shlMicrowaveByTisham, SWT.BORDER);
		spnNum.setMaximum(3);
		spnNum.setMinimum(1);
		spnNum.setBounds(22, 102, 47, 22);

		//the total amount of time taken from heating everything up
		Label lblTimeTaken = new Label(shlMicrowaveByTisham, SWT.NONE);
		lblTimeTaken.setBounds(22, 153, 327, 15);
		
		//starts the imaginary microwave countdown, then tells you how long the microwave was on for
		Button btnStart = new Button(shlMicrowaveByTisham, SWT.NONE);
		btnStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				double time; //total time taken in microwave
				double food; //base time for the food selected
				
				//multiplier = x1 if 1 item, x1.5 if 2 items, and x2 if 3 items. easier to have it set here
				//spinner.getSelection() returns an int, so cast as double
				double multiplier = ((double)spnNum.getSelection() / 2) + 0.5;
				
				//food time based on what food is selected
				if (radSoup.getSelection() == true) {
					//1.75 minutes, 1;45 microwave time
					food = 105;
				}
				else if (radSub.getSelection() == true) {
					//1 minute, 60 microwave time
					food = 60;
				}
				else if (radPizza.getSelection() == true) {
					//.75 minutes, 45 microwave time. odd that 0> decimals of things are referred to in the plural
					food = 45;
				}
				//just in case mistake happens
				else {
					food = 105;
				}
				
				//calculates the time taken 
				time = food * multiplier;
				
				//displays the time taken
				lblTimeTaken.setText("The time spent in the microwave was " + time);
			}
		});
		btnStart.setBounds(104, 102, 75, 25);
		btnStart.setText("Start");
		
		

	}
}
