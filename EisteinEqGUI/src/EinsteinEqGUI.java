/*
 * Created by: Tisham Islam
 * Created on: 16-Sep-2019
 * Created for: ICS4U
 * Day #5 (Einstein EquationGUI)
 * This program calculates the energy produced when mass is converted directly to energy, but cooler
*/


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Spinner;

public class EinsteinEqGUI {

	protected Shell shlEinsteinEq;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			EinsteinEqGUI window = new EinsteinEqGUI();
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
		shlEinsteinEq.open();
		shlEinsteinEq.layout();
		while (!shlEinsteinEq.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlEinsteinEq = new Shell();
		shlEinsteinEq.setSize(450, 300);
		shlEinsteinEq.setText("Einstein Eq By TishamI");
		shlEinsteinEq.setLayout(null);
		
		Label lblPlease = new Label(shlEinsteinEq, SWT.NONE);
		lblPlease.setBounds(39, 10, 165, 15);
		lblPlease.setText("Please enter the mass in KG");
		
		Label lblEnergy = new Label(shlEinsteinEq, SWT.NONE);
		lblEnergy.setBounds(39, 215, 400, 15);
		lblEnergy.setText("");
		
		//for selecting mass, has min of 0 so no negatives
		Spinner spnMass = new Spinner(shlEinsteinEq, SWT.BORDER);
		spnMass.setMaximum(100000);
		spnMass.setMinimum(0);
		spnMass.setBounds(39, 31, 47, 22);
		
		Button btnCalculate = new Button(shlEinsteinEq, SWT.NONE);
		btnCalculate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//light squared as constant
				final double c2 = 2.998 * 100000000 * 2.998 * 100000000;
				
				//mass is set to the spinner's value
				double[]  mass = new double[1];
				mass[0] = spnMass.getSelection();
				
				//shows mass converted to energy
				lblEnergy.setText("The energy produced by this amount of mass is " + (mass[0] * c2));
				}
		
		});
		btnCalculate.setBounds(39, 114, 75, 25);
		btnCalculate.setText("Calculate");
		
		

	}
}