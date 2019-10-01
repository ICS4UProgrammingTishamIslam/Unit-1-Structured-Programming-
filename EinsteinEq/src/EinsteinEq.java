/*
 * Created by: Tisham Islam
 * Created on: 11-Sep-2019
 * Created for: ICS4U
 * Day #5 (Einstein Equation)
 * This program calculates the energy produced when mass is converted directly to energy
*/

import java.util.Scanner;

public class EinsteinEq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//light squared as constant
		final double c2 = 2.998 * 100000000 * 2.998 * 100000000;
		
		//init message
		System.out.println("Please enter the amount of mass (kg) to be converted into energy (Joules)");
		
		//get input and convert to double
		Scanner inputMass = new Scanner(System.in);
		String massAsString = inputMass.nextLine();
		double massAsDouble = Double.parseDouble(massAsString);
		
		//calculate energy
		double energy = massAsDouble * c2;
		
		//show energy
		System.out.println("The total energy produced is " + energy + " joules");
	}
}
