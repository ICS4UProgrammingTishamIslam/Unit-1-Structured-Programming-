/*
 * Created by: Tisham Islam
 * Created on: 18-Sep-2019
 * Created for: ICS4U
 * Day #10 (Rock Paper Scissors)
 * This is a program that rock paper scissors with you because you have no friends :P
*/

import java.util.Random;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;

public class RockPaperScissors {

	//random creation
	static Random hands = new Random();
	
	protected Shell shlRockPaperScissors;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			RockPaperScissors window = new RockPaperScissors();
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
		shlRockPaperScissors.open();
		shlRockPaperScissors.layout();
		while (!shlRockPaperScissors.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}


	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlRockPaperScissors = new Shell();
		shlRockPaperScissors.setSize(450, 300);
		shlRockPaperScissors.setText("Rock Paper Scissors by TishamI");
		
		//vars represented as arrays so they can be modified
		int[] wins = new int[1];
		int[] losses = new int[1];
		int[] winLossS = new int[1];
		
	    Label lblCpuDecision = new Label(shlRockPaperScissors, SWT.NONE);
		lblCpuDecision.setBounds(35, 117, 309, 15);
		
		Label lblWins = new Label(shlRockPaperScissors, SWT.NONE);
		lblWins.setTouchEnabled(true);
		lblWins.setText("Wins:");
		lblWins.setBounds(35, 148, 35, 15);
		
		Label lblLosses = new Label(shlRockPaperScissors, SWT.NONE);
		lblLosses.setText("Losses:");
		lblLosses.setBounds(35, 177, 35, 15);

		Spinner spnWins = new Spinner(shlRockPaperScissors, SWT.BORDER);
		spnWins.setEnabled(false);
		spnWins.setBounds(76, 148, 47, 22);
		
		Spinner spnLosses = new Spinner(shlRockPaperScissors, SWT.BORDER);
		spnLosses.setEnabled(false);
		spnLosses.setBounds(76, 177, 47, 22);
		
		//rock = 0
		Button btnRock = new Button(shlRockPaperScissors, SWT.NONE);
		btnRock.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				//gets results based on player input (this button), represented as zero
				winLossS[0] = Results(0);

				//creates text based on the win loss state
				lblCpuDecision.setText(TextCreation(winLossS[0], 0));

				//if there's a loss, increase the loss counter and modify the loss spinner
				if (winLossS[0] == 0) {
					losses[0]++;
					spnLosses.setSelection(losses[0]);
				}
				//if there's a win, increase the win counter and modify the win spinner
				else if (winLossS[0] == 2) {
					wins[0]++;
					spnWins.setSelection(wins[0]);
				}
				//no need to do anything about draws other than displaying that there was one
			}
		});
		btnRock.setBounds(35, 42, 75, 25);
		btnRock.setText("Rock");
		
		//paper = 1
		Button btnPaper = new Button(shlRockPaperScissors, SWT.NONE);
		btnPaper.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				//gets results based on player input (this button), represented as one
				winLossS[0] = Results(1);
				
				//creates text based on the win loss state
				lblCpuDecision.setText(TextCreation(winLossS[0], 1));

				//if there's a loss, increase the loss counter and modify the loss spinner
				if (winLossS[0] == 0) {
					losses[0]++;
					spnLosses.setSelection(losses[0]);
				}
				//if there's a win, increase the win counter and modify the win spinner
				else if (winLossS[0] == 2) {
					wins[0]++;
					spnWins.setSelection(wins[0]);
				}
				//no need to do anything about draws other than displaying that there was one
			}
		});
		btnPaper.setBounds(149, 42, 75, 25);
		btnPaper.setText("Paper");
		
		//scissors = 2
		Button btnScissors = new Button(shlRockPaperScissors, SWT.NONE);
		btnScissors.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//gets results based on player input (this button), represented as two
				winLossS[0] = Results(2);
				
				//creates text based on the win loss state
				lblCpuDecision.setText(TextCreation(winLossS[0], 2));
				
				//if there's a loss, increase the loss counter and modify the loss spinner
				if (winLossS[0] == 0) {
					losses[0]++;
					spnLosses.setSelection(losses[0]);
				}
				//if there's a win, increase the win counter and modify the win spinner
				else if (winLossS[0] == 2) {
					wins[0]++;
					spnWins.setSelection(wins[0]);
				}
				//no need to do anything about draws other than displaying that there was one
			}
		});
		btnScissors.setBounds(269, 42, 75, 25);
		btnScissors.setText("Scissors");

	}
	
	public static int Results(int playerMove) {
		
		//gets number from 0 to 2
		int comDec = hands.nextInt(3);
		
		//0 = loss, 1 = draw, 2 = win
		int winLoss = 1;
		
		//if com's move is the same as the player's
		if (comDec == playerMove) {
			//they drawed
			winLoss = 1;
		}
		//otherwise, if com threw rock
		else if (comDec == 0) {
			//and player threw scissors
			if (playerMove == 2) {
				//player lost
				winLoss = 0;
			}
			//or if player threw paper
			else if (playerMove == 1) {
				//player wins
				winLoss = 2;
			}
		}
		//otherwise, if com threw paper
		else if (comDec == 1) {
			//and player threw rock
			if (playerMove == 0) {
				//player lost
				winLoss = 0;
				}
			//or if player threw scissors
			else if (playerMove == 2) {
				//player wins
				winLoss = 2;
				}
		}
		//otherwise, if com threw scissors
		else if (comDec == 2) {
			//and player threw paper
			if (playerMove == 1) {
				//player loss
				winLoss = 0;
				}
			//or if player threw rock
			else if (playerMove == 0) {
				//player wins
				winLoss = 2;
				}
		}
		
		//return the result of the draw
		return winLoss;
	}
	
	
	//will send the message to the player based on the results
	public static String TextCreation(int stats, int playerMove) {
		
		String results = "";
		
		//if loss
		if (stats == 0) {
			//and player threw rock, com won with paper
			if (playerMove == 0) {
				results = "Com threw paper and won!";
			}
			//and player threw paper, com won with scissors
			else if (playerMove == 1) {
				results = "Com threw scissors and won!";
			}
			//and player threw scissors, com won with rock
			else if (playerMove == 2) {
				results = "Com threw rock and won!";
			}
		}
		//if drawed
		else if (stats == 1) {
			// player throwing rock means com drawed with rock
			if (playerMove == 0) {
				results = "Com threw rock and drawed!";
			}
			// player throwing paper means com drawed with paper
			else if (playerMove == 1) {
				results = "Com threw paper and drawed!";
			}
			// player throwing scissors means com drawed with scissors
			else if (playerMove == 2) {
				results = "Com threw scissors and drawed!";
			}
		}
		//if win
		else if (stats == 2) {
			//and player threw rock, com lost with scissors
			if (playerMove == 0) {
				results = "Com threw scissors and lost!";
			}
			//and player threw paper, com lost with rock
			else if (playerMove == 1) {
				results = "Com threw rock and lost!";
			}
			//and player threw scissors, com lost with rock
			else if (playerMove == 2) {
				results = "Com threw paper and lost!";
			}
		}
		
		//return the message given to the player
		return results;
	}
}
