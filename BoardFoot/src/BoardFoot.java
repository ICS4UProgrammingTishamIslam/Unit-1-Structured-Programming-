/*
 * Created by: Tisham Islam
 * Created on: 18-Sep-2019
 * Created for: ICS4U
 * Day #9 (Roll Die Console)
 * This is a program that rolls a number for you, from 1 to x, where x is entered by the user
*/

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class BoardFoot {

	protected Shell shlBoardFoot;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BoardFoot window = new BoardFoot();
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
		shlBoardFoot.open();
		shlBoardFoot.layout();
		while (!shlBoardFoot.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBoardFoot = new Shell();
		shlBoardFoot.setSize(450, 300);
		shlBoardFoot.setText("Board Foot by TishamI");
		
		Spinner spnDimension1 = new Spinner(shlBoardFoot, SWT.BORDER);
		spnDimension1.setMinimum(1);
		spnDimension1.setBounds(58, 67, 47, 22);
		
		Spinner spnDimension2 = new Spinner(shlBoardFoot, SWT.BORDER);
		spnDimension2.setMinimum(1);
		spnDimension2.setBounds(283, 67, 47, 22);
		
		Label lblDimension1 = new Label(shlBoardFoot, SWT.NONE);
		lblDimension1.setBounds(39, 46, 81, 15);
		lblDimension1.setText("Dimension 1:");
		
		Label lblDimension2 = new Label(shlBoardFoot, SWT.NONE);
		lblDimension2.setBounds(264, 46, 81, 15);
		lblDimension2.setText("Dimension 2:");
		
		Label lblCalculations = new Label(shlBoardFoot, SWT.NONE);
		lblCalculations.setBounds(10, 203, 414, 15);
		
		Button btnCalculate = new Button(shlBoardFoot, SWT.NONE);
		btnCalculate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//get the area first 
				double area = spnDimension1.getSelection() * spnDimension2.getSelection();
				//then get the inverse of the height
				double inverseHeight = area/144;
				//get actual height by dividing 1 by the inverse
				double actualHeight = 1 / inverseHeight;
				lblCalculations.setText("The height of the board is " + actualHeight + " inch(es)");
			}
		});
		btnCalculate.setBounds(157, 148, 75, 25);
		btnCalculate.setText("Calculate");

	}
}
