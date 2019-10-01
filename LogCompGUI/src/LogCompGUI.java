/*
 * Created by: Tisham Islam
 * Created on: 11-Sep-2019
 * Created for: ICS4U
 * Day #4 (Logging Company GUI)
 * This program calculates the amount of logs a truck can hold
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class LogCompGUI {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LogCompGUI window = new LogCompGUI();
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
		shell.setText("LogCompGUI by TishamI");
		shell.setLayout(null);

		final double carryWeight = 1100;
		final double weightOfLogs = 20;
		
		Button radQuarter = new Button(shell, SWT.RADIO);
		radQuarter.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		radQuarter.setBounds(55, 94, 90, 16);
		radQuarter.setText("0.25 Meter");
		
		Button radHalf = new Button(shell, SWT.RADIO);
		radHalf.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		radHalf.setBounds(55, 116, 90, 16);
		radHalf.setText("0.5 Meter");
		
		Button radFull = new Button(shell, SWT.RADIO);
		radFull.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		radFull.setBounds(55, 138, 90, 16);
		radFull.setText("1 meter");

		Label lblLogs = new Label(shell, SWT.NONE);
		lblLogs.setBounds(81, 187, 245, 15);

		Button btnCalculate = new Button(shell, SWT.NONE);
		btnCalculate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				double logLength[] = new double[1];
				double numLogs[] = new double[1];
				
				if (radQuarter.getSelection()) {
					logLength[0] = .25;
				}
				else if (radHalf.getSelection()) {
					logLength[0] = 0.5;
				}
				else if (radFull.getSelection()) {
					logLength[0] = 1;
				}
				else {
					logLength[0] = 0.25;
				}
				numLogs[0] = carryWeight / (weightOfLogs * logLength[0]);
				lblLogs.setText("The number of logs the truck can carry is " + numLogs[0]);
			}
		});
		btnCalculate.setBounds(81, 41, 75, 25);
		btnCalculate.setText("Calculate");
		
	}
}
