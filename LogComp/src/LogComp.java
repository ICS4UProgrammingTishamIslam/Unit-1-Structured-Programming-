import java.util.Scanner;

public class LogComp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double weightPerLog;
		double smallLog = .25;
		double medLog = .5;
		double largeLog = 1;
		double numLogs;
		final double carryWeight = 1100;
		final double weightOfLogs = 20;
		

		
		System.out.println("Please enter your log length, in meters");

		Scanner userInput = new Scanner(System.in);
		String userInputAsString = userInput.nextLine();
		double userInputAsDouble = Double.parseDouble(userInputAsString);
		
		if (userInputAsDouble == smallLog || userInputAsDouble == largeLog || userInputAsDouble == medLog) {
			
			weightPerLog = weightOfLogs * userInputAsDouble;
			numLogs = carryWeight / weightPerLog;
			System.out.println("You could carry " + numLogs + " logs");
			
		}
		else {
			System.out.println("Please enter a valid number (1, 0.5, 0.25), and re-run the program");
		}
	}

}
