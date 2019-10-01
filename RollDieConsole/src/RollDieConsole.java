/*
 * Created by: Tisham Islam
 * Created on: 18-Sep-2019
 * Created for: ICS4U
 * Day #9 (Roll Die Console)
 * This is a program that rolls a number for you, from 1 to x, where x is entered by the user
*/


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import java.util.Random;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class RollDieConsole {

	protected Shell shlRollDiein;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RollDieConsole window = new RollDieConsole();
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
		shlRollDiein.open();
		shlRollDiein.layout();
		while (!shlRollDiein.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	
	protected void createContents() {
		
		shlRollDiein = new Shell();
		shlRollDiein.setSize(450, 300);
		shlRollDiein.setText("Roll Die (In the console) By TishamI");
		
		//select max value
		Spinner spnMaxValue = new Spinner(shlRollDiein, SWT.BORDER);
		spnMaxValue.setMinimum(2);
		spnMaxValue.setBounds(211, 68, 47, 22);
		
		//tells you what the spinners for
		Label lblMaxValue = new Label(shlRollDiein, SWT.NONE);
		lblMaxValue.setBounds(211, 33, 55, 15);
		lblMaxValue.setText("Max Value");
		
		//executes the roll
		Button btnRoll = new Button(shlRollDiein, SWT.NONE);
		btnRoll.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//uses the roll die function witht eh spinner's value
				RollDie(spnMaxValue.getSelection());
			}
		});
		btnRoll.setBounds(77, 65, 75, 25);
		btnRoll.setText("Roll!");
		
	}
	
	//for rolling a number
	public static void RollDie(int maxValue) {

		//random creation
		Random roll = new Random();
		
		//uses the max value, then adds one (random goes from 0 to x -1)
		int rolled = roll.nextInt(maxValue) + 1;
		
		//print the result in the console
		System.out.print("You rolled a " + rolled + "\r\n");
	}

}
