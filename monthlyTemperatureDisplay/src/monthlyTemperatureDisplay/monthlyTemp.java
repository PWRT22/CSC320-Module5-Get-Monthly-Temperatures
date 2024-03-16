package monthlyTemperatureDisplay;

//Import dependencies
import java.util.Scanner;

public class monthlyTemp {
	public static void main(String[] args) {
		//Declaration of variables and arrays for the program.
		Scanner scanner = new Scanner(System.in);
		String[] yearMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}; //Declare array that contains the months of the year.
		double[] temperatures = {58.6, 56.5, 65.7, 78.6, 75.4, 86.8, 84.6, 80.0, 83.5, 78.8, 70.2, 64.9}; //Declare array that contains the monthly temperatures for the year.
		int monthTempIndex = -1;
		String monthSelected;
		double tempSum = 0;
		double lowestTemp = 0.0;
		double highestTemp = 0.0;
		double yearAverageTemp = 0.0;
		String lowestMonth = "";
		String highestMonth = "";
		int i = 0;


		System.out.println("Welcome to the Temperature Display App"); //Display welcome message to the user.
		System.out.println("Please enter 'Year' or the month you would like to see the temperature for: "); //Program instructions for the user.
		System.out.println("For example, you can enter a month such as 'January' or the word 'Year'");
		monthSelected = scanner.nextLine(); // Store user input to be used in the program.
		
		
		// Validating user input
        boolean inputValidation = false;
        for (String month : yearMonths) {
            if (monthSelected.equalsIgnoreCase(month) || monthSelected.equalsIgnoreCase("Year")) {
                inputValidation = true;
                break;
            }
        }
        if (!inputValidation) {
            System.out.println("Invalid entry, please enter a correct month name, or the word year.");
            System.out.println("Please verify the syntax is correct for the entry.");
            return; // Exit the program
        }
		
		//Loop to find the lowest temperature and month of the year
		lowestTemp = temperatures[0];
		for(i = 0; i < temperatures.length; i++) {
			if(lowestTemp > temperatures[i]) {
				lowestTemp = temperatures[i];
				lowestMonth = yearMonths[i];
			}
			
		}
		
		//Loop to find the highest temperature and month of the year
		highestTemp = temperatures[0];
		for(i = 0; i < temperatures.length; i++) {
			if(highestTemp < temperatures[i]) {
				highestTemp = temperatures[i];
				highestMonth = yearMonths[i];
			}
			
		}
		//Loop to display on the screen the month and temperature that matches the user input.
		for(i =0; i < yearMonths.length; i++){
			if(yearMonths[i].equalsIgnoreCase(monthSelected)){
				monthTempIndex = i;
				System.out.println("The average temperature for " + yearMonths[monthTempIndex] + " is " + temperatures[monthTempIndex] + "°F");
				break;
			}
			// Conditional statement to print all the months and temperatures for the year if the user input matches "Year".
			if(monthSelected.equalsIgnoreCase("Year")) {
				for(int j = 0; j < yearMonths.length; j++) {
					System.out.println(yearMonths[i] +  ":" + temperatures[i] + "°F");
					break;
				}
				
			}
		}
		//Conditional statement to print statistics if the user input is year.
		if(monthSelected.equalsIgnoreCase("Year")) {
			for(i = 0; i < temperatures.length; i++) {
				tempSum += temperatures[i];
				yearAverageTemp = (tempSum / 12.0);
			}
			System.out.println("The average temperature for the year was: " + String.format("%.1f", yearAverageTemp) + "°F");
			System.out.println("The lowest temperature for the year was: " + lowestTemp + "°F for the month of " + lowestMonth);
			System.out.println("The highest temperature for the year was: " + highestTemp + "°F for the month of " + highestMonth);
			
			
		}	
		
	}	
}
