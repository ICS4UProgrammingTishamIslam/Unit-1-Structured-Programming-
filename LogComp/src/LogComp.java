/*
 * Created by: Tisham Islam
 * Created on: 11-Sep-2019
 * Created for: ICS4U
 * Day #4 (Logging Company)
 * This program calculates the amount of logs a truck can hold
*/

import java.util.Scanner;

public class LogComp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//vars
		double weightPerLog;
		double smallLog = .25;
		double medLog = .5;
		double largeLog = 1;
		double numLogs;
		final double carryWeight = 1100;
		final double weightOfLogs = 20;
		

		//initial message
		System.out.println("Please enter your log length, in meters");

		//user input get
		Scanner userInput = new Scanner(System.in);
		String userInputAsString = userInput.nextLine();
		double userInputAsDouble = Double.parseDouble(userInputAsString);
		
		//checks if valid
		if (userInputAsDouble == smallLog || userInputAsDouble == largeLog || userInputAsDouble == medLog) {
			
			//calculates the amount of logs the truck can hold based on chosen length
			weightPerLog = weightOfLogs * userInputAsDouble;
			numLogs = carryWeight / weightPerLog;
			System.out.println("You could carry " + numLogs + " logs");
			
		}
		else {
			//if invalid, says so
			System.out.println("Please enter a valid number (1, 0.5, 0.25), and re-run the program");
		}
	}

}
