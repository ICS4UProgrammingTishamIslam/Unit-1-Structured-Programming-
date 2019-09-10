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
		shlHelloworldguiByTishami = new Shell();
		shlHelloworldguiByTishami.setSize(450, 300);
		shlHelloworldguiByTishami.setText("HelloWorldGUI by TishamI");
		shlHelloworldguiByTishami.setLayout(null);
		
		Label lblHelloWorld = new Label(shlHelloworldguiByTishami, SWT.NONE);
		lblHelloWorld.setBounds(82, 128, 177, 55);
		
		Button btnGreetings = new Button(shlHelloworldguiByTishami, SWT.NONE);
		btnGreetings.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lblHelloWorld.setText("Hello World, I am Tisham");
			}
		});
		btnGreetings.setBounds(154, 76, 75, 25);
		btnGreetings.setText("Greetings");

	}
}
