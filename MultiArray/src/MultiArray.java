/*
 * Created by: Tisham Islam
 * Created on: 01-Oct-2019
 * Created for: ICS4U
 * Day #13 (Multidimensional Array)
 * This is a program that creates a multi array for four students and display their marks, before calculating their average
*/

//
import java.util.Random;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MultiArray {

	protected Shell shlMultiarray;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MultiArray window = new MultiArray();
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
		shlMultiarray.open();
		shlMultiarray.layout();
		while (!shlMultiarray.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMultiarray = new Shell();
		shlMultiarray.setSize(450, 633);
		shlMultiarray.setText("MultiArray by TishamI");
		
		//mark array
		int[][] marks = new int[4][6];
		
		//random
		Random numGen = new Random();
		
		Label lblMarkA = new Label(shlMultiarray, SWT.NONE);
		lblMarkA.setBounds(25, 194, 55, 292);
		
		Label lblMarkB = new Label(shlMultiarray, SWT.NONE);
		lblMarkB.setBounds(125, 194, 55, 292);
		
		Label lblMarkC = new Label(shlMultiarray, SWT.NONE);
		lblMarkC.setBounds(225, 194, 55, 292);
		
		Label lblMarkD = new Label(shlMultiarray, SWT.NONE);
		lblMarkD.setBounds(325, 194, 55, 292);

		
		Label lblClassAverage = new Label(shlMultiarray, SWT.NONE);
		lblClassAverage.setBounds(10, 540, 414, 15);

		
		Button btnGenerate = new Button(shlMultiarray, SWT.NONE);
		btnGenerate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				//variables
				int classAverage = 0;
				int classSum = 0;
				
				//reset text
				lblMarkA.setText("");
				lblMarkB.setText("");
				lblMarkC.setText("");
				lblMarkD.setText("");
				
				//populate array
				//first degree
				for (int i = 0; i < 4; i++) {
					//second degree
					for (int j = 0; j < 6; j++) {
						//from 40 to 99, to be a bit more realistic
						marks[i][j] = numGen.nextInt(60) + 40;
						classSum += marks[i][j];
					}
				}
				
				//display marks for each student
				for (int i = 0; i < 6; i++) {
					lblMarkA.setText(lblMarkA.getText() + marks[0][i] + "\r\n");
					lblMarkB.setText(lblMarkB.getText() + marks[1][i] + "\r\n");
					lblMarkC.setText(lblMarkC.getText() + marks[2][i] + "\r\n");
					lblMarkD.setText(lblMarkD.getText() + marks[3][i] + "\r\n");
				}

				//set class average
				classAverage = classSum / 24;
				lblClassAverage.setText("The class' average is " + classAverage + " percent");
			}
		});
		btnGenerate.setBounds(174, 111, 75, 25);
		btnGenerate.setText("Generate");
	}
}
