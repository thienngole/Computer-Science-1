/**
 * Interactive Average Program
 * This program asks the user to input two real numbers,
 * calculates the average of these numbers, and display the result.
 * Author: ThienNgo N. Le
 */

import java.util.Scanner;

public class ThienNgoLe_01 {

    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);
        double num1, num2; // Input values
        double average;    // Average of the input values

        // Explain the program to the user
        System.out.println("This program averages two real numbers.");

        // Input the two numbers
        System.out.print("Enter your first number: ");
        num1 = console.nextDouble();

        System.out.print("Enter your second number: ");
        num2 = console.nextDouble();

        // Calculate the average of the two numbers
        average = (num1 + num2) / 2.0;

        // Output the results
        System.out.print("The average of " + num1);
        System.out.println(" and " + num2 + " is " + average);
        System.out.println("Program is written by ThienNgo N. Le");

        // Close files and exit
        console.close();
        System.exit(0);
    } // End main
} // End class
    