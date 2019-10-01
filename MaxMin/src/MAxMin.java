/*
 * Created by: Tisham Islam
 * Created on: 30-Sep-2019
 * Created for: ICS4U
 * Day #12 (MinMax)
 * This program creates an array of ten numbers and finds both the minimum and the maximum of the array
*/

//for the use of randoms
import java.util.Random;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;


public class MAxMin {

	protected Shell shlMaxmin;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MAxMin window = new MAxMin();
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
		shlMaxmin.open();
		shlMaxmin.layout();
		while (!shlMaxmin.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMaxmin = new Shell();
		shlMaxmin.setSize(155, 231);
		shlMaxmin.setText("Max Min by TishamI");
		
		//stores ints in an array
		int[] numbers = new int[10];
		//generates random numbers for us
		Random numGen = new Random();
		
		Label lblArray = new Label(shlMaxmin, SWT.BORDER);
		lblArray.setBounds(91, 10, 38, 157);
		
		Label lblMin = new Label(shlMaxmin, SWT.NONE);
		lblMin.setBounds(10, 81, 55, 15);
		lblMin.setText("Min:");
		
		Label lblMax = new Label(shlMaxmin, SWT.NONE);
		lblMax.setBounds(10, 141, 55, 15);
		lblMax.setText("Max:");
		
		Button btnGenerate = new Button(shlMaxmin, SWT.NONE);
		btnGenerate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//min and max vars
				int min = -1;
				int max = -1;
				
				//reset the label's text, in case you wish to do a reset
				lblArray.setText("");
				
				//for the size of the array
				for (int i = 0; i < numbers.length; i++) {
					//set array at i to random number from 0 - 99
					numbers[i] = numGen.nextInt(100);
					
					//display the number in the array label
					lblArray.setText(lblArray.getText() + numbers[i] + "\r\n");
					
					//if the number is smaller than the current min, update the min
					if (numbers[i] < min) {
						min = numbers[i];
					}
					//if min is still unset, set it
					else if (min == -1) {
						min = numbers[i];
					}
					
					//if the number is greater than the current max, update the max
					if (numbers[i] > max) {
						max = numbers[i];
					}
					//if max is still unset, set it
					else if (max == -1) {
						max = numbers[i];
					}
				}
				
				//set the min and max labels once the mins and maxs have been found
				lblMax.setText("Max: " + max);
				lblMin.setText("Min: " + min);
			}
		});
		btnGenerate.setBounds(10, 24, 75, 25);
		btnGenerate.setText("Generate");

	}
}
