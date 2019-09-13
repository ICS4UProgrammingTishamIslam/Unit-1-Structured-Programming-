/*
 * Created by: Tisham Islam
 * Created on: 06-Sep-2019
 * Created for: ICS4U
 * Day #2 (Hello WorldGUI)
 * This program calculates how to say hello
*/


import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class HelloWorldGUI {	

	protected Shell shlHelloworldguiByTishami;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HelloWorldGUI window = new HelloWorldGUI();
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
		shlHelloworldguiByTishami.open();
		shlHelloworldguiByTishami.layout();
		while (!shlHelloworldguiByTishami.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		//array of words
		String words[] = new String[5];
		words[0] = "Hello ";
		words[1] = "World, ";
		words[2] = "I ";
		words[3] = "am ";
		words[4] = "Tisham";
		
		shlHelloworldguiByTishami = new Shell();
		shlHelloworldguiByTishami.setSize(450, 300);
		shlHelloworldguiByTishami.setText("HelloWorldGUI by TishamI");
		shlHelloworldguiByTishami.setLayout(null);
		
		Label lblHelloWorld = new Label(shlHelloworldguiByTishami, SWT.NONE);
		lblHelloWorld.setBounds(82, 128, 177, 55);
		
		Button btnGreetings = new Button(shlHelloworldguiByTishami, SWT.NONE);
		//press the button to say the greetings
		btnGreetings.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblHelloWorld.setText(words[0] + words[1] + words[2] + words[3] + words[4]);
			}
		});
		btnGreetings.setBounds(154, 76, 75, 25);
		btnGreetings.setText("Greetings");

	}
}
