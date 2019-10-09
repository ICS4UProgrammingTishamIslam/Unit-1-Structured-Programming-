import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.SWT;

public class PlanetEnumeration {

	protected Shell shlPlanetEnumeration;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PlanetEnumeration window = new PlanetEnumeration();
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
		shlPlanetEnumeration.open();
		shlPlanetEnumeration.layout();
		while (!shlPlanetEnumeration.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlPlanetEnumeration = new Shell();
		shlPlanetEnumeration.setSize(450, 300);
		shlPlanetEnumeration.setText("Planet Enumeration by TishamI");

	}
}
