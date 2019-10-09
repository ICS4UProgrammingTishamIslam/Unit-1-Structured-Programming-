/*
 * Created by: Tisham Islam
 * Created on: 03-Oct-2019
 * Created for: ICS4U
 * Day #16 (Stack - Push)
 * This is a program that lets you enter data into a stack
*/

import java.util.*;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.List;

public class StackPush {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			StackPush window = new StackPush();
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
		
		Spinner spnValues = new Spinner(shell, SWT.BORDER);
		spnValues.setBounds(60, 50, 47, 22);
		
		
		Label lblStack = new Label(shell, SWT.NONE);
		lblStack.setBounds(217, 10, 55, 241);
		
		Stack<Integer> pancakes = new Stack<Integer>();

		Button btnPush = new Button(shell, SWT.NONE);
		btnPush.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				pancakes.push(spnValues.getSelection());
				lblStack.setText(spnValues.getSelection() + "\r\n" + lblStack.getText());
			}
		});
		btnPush.setBounds(60, 108, 75, 25);
		btnPush.setText("PUSH!");
		
		
		

	}
}
