/**
 * ArrayLists Program
 * This program asks the user to input the integer values,
 * calculates the sum and average of these values,
 * and prints the results to the console
 * ThienNgo N. Le
 * Program #11, CS 1050, Section 5
 * Jre 1.8.0_31, windows8 64-bit
 * Aspiration: a drawing of something in, out,up or through by as if by suction
 * "Things do not change; we change" Henry David Thoreau (1817-1862)
 */

import java.util.*;
import java.io.*;

public class ThienNgoLe_5_11 {

    static Toolkit tools = new Toolkit();
    static final String TWO_PLACE = "0.00";

    public static void main(String[] args) throws IOException {

        Scanner keyboard = new Scanner(System.in); // Assign keyboard input

        // Declare an ArrayList names numbersVal
        ArrayList<Double> numbersVal = new ArrayList<Double>();

        int nNum = 0;            // The number of values process
        double total = 0.0;      // The total of values process
        double average = 0.0;    // The average of values process
        double nextNumber = 0.0; // Next number to read

        // Explain the program to the user
        System.out.println("This program calculates the total and average of"
                + " real numbers\n and output the results to console\n"
                + "Please enter the input values to process.");

        // Input the values from the keyboard
        for (int i = 0; ; i++) {
            System.out.print("Enter your value #" + (i + 1) +
                    " (0 to exit) please: ");
            nextNumber = keyboard.nextDouble();

            // Stop input when the user input the value that equal to 0
            if (nextNumber == 0) {
                System.out.println("Thank for inputing. Please Wait for a moment!\n");
                break;
            } // End if
            numbersVal.add(i, nextNumber);
            total += nextNumber; // Count the running total
            nNum++; // Count the number of values process
        } // Emd for
        // Calculate the average of values process
        if (nNum > 0) {
            average = total / nNum;
        } // End if
        // Output the result to console
        System.out.println("The number of values processed is: " + nNum
                + "\nThe total of values processed is: "
                + tools.leftPad(total, 8, TWO_PLACE, " ")
                + "\nThe average of values processed is: "
                + tools.leftPad(average, 8, TWO_PLACE, " "));
    } // End main
} // End class
