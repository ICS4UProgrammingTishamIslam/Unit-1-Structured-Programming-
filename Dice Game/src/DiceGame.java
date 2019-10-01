/*
 * Created by: Tisham Islam
 * Created on: 17-Sep-2019
 * Created for: ICS4U
 * Day #8 (Dice Game)
 * This program lets you guess what number the computer chose, from 1-6
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
//for random purposes
import java.util.Random;

public class DiceGame {

	protected Shell shlDiceGameBy;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DiceGame window = new DiceGame();
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
		shlDiceGameBy.open();
		shlDiceGameBy.layout();
		while (!shlDiceGameBy.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {

		int[] misses = new int[1];	    //check misses. is an array so you can modify it later		
		Random guesser = new Random(); //create a random
		
		//initialization of misses[0]
		misses[0] = 0;
		
		shlDiceGameBy = new Shell();
		shlDiceGameBy.setSize(450, 300);
		shlDiceGameBy.setText("Dice Game by TishamI");
		
		Spinner spnYourGuess = new Spinner(shlDiceGameBy, SWT.BORDER);
		spnYourGuess.setMaximum(6);
		spnYourGuess.setMinimum(1);
		spnYourGuess.setBounds(20, 47, 47, 22);
		
		Label lblGuess = new Label(shlDiceGameBy, SWT.NONE);
		lblGuess.setBounds(20, 25, 350, 15);
		lblGuess.setText("Guess the number the computer will choose");
		
		Label lblWrongTimes = new Label(shlDiceGameBy, SWT.NONE);
		lblWrongTimes.setBounds(20, 93, 404, 15);
		
		Label lblRandomNumber = new Label(shlDiceGameBy, SWT.NONE);
		lblRandomNumber.setBounds(20, 137, 404, 15);

		
		Button btnGuess = new Button(shlDiceGameBy, SWT.NONE);
		btnGuess.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//get num from 0-5, + 1 so it becomes 1-6
				int dice = guesser.nextInt(6) + 1;
				
				//if wrong, increase miss counter and display new total of misses, before telling the computer's number
				if (dice != spnYourGuess.getSelection()) {
						misses[0] += 1;
						lblWrongTimes.setText("You've guessed wrong " + misses[0] + " times without guessing right");
						lblRandomNumber.setText("The computer's number was " + dice);
				}
				//if right, displays that you matched the number.
				//The amount of wrong guesses remains, but the internal value is reset for next time
				else if (dice == spnYourGuess.getSelection()) {
					lblRandomNumber.setText("You've guessed right! The computer's number was " + dice);
					misses[0] = 0;
				}
			}
		});
		btnGuess.setBounds(107, 47, 75, 25);
		btnGuess.setText("Guess");
	}

}
