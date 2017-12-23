/**
 * Calculate mileage reimbursement
 * This program calculates mileage reimbursement based on a table
 * Author: ThienNgo n. Le
 */

import java.util.*;
import java.io.*;

public class ThienNgoLe_06 {

    static Toolkit tools = new Toolkit();
    static final String ONE_PLACE = "0.0";
    static final String TWO_PLACE = "0.00";

    public static void main(String[] args) throws IOException {

        int nNumbers = 0;              // The numbers of mile read from input file
        int numPositiveMiles = 0;      // The numbers of mile greater than 0
        double miles = 0.0;            // The value of miles
        double reimbursement = 0.0;    // The value of the reimbursement
        double sumReimbursement = 0.0; // The total of the reimbursement
        String oneLine;                // The information to output


        // Define the file's names
        final String INPUT_FILE =
                "input\\ThienNgoLe_5_06_Input.txt";
        final String OUTPUT_FILE =
                "output\\ThienNgoLe_5_06_Output.txt";

        // Access the input file
        File inputDataFile = new File(INPUT_FILE);
        Scanner inputFile = new Scanner(inputDataFile);

        //Access the output file
        FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
        PrintWriter outputFile = new PrintWriter(outputDataFile);

        // Print the heading to the output file and echo heading to console
        showHeading(outputFile);

        // Read number of mile values
        nNumbers = inputFile.nextInt();

        // Determine the reimbursement
        while (inputFile.hasNext()) {
            miles = getInput(inputFile);

            if (miles <= 0) {
                oneLine = tools.leftPad(miles, 10, ONE_PLACE, " ") +
                        "          *****";
                outputFile.println(oneLine); // Output to the output file
                System.out.println(oneLine); // Echo output to the console
                continue;
            } else {
                reimbursement = calcReimb(miles);
                sumReimbursement += reimbursement;

                ++numPositiveMiles;
                oneLine = tools.leftPad(miles, 10, ONE_PLACE, " ")
                        + tools.leftPad(reimbursement, 15, TWO_PLACE, " ");
                outputFile.println(oneLine); // Output to the output file
                System.out.println(oneLine); // Echo output to the console

            }
        }  // End while

        // Write the result to the output file and echo to console
        outputResult(outputFile, nNumbers, numPositiveMiles,
                reimbursement, sumReimbursement);

        // Close the input file
        inputFile.close();

        // Close the output file
        outputFile.close();

        // Exit
        System.exit(0);

    }  // Emd main

    //****************************************************************************

    // Make the heading
    public static void showHeading(PrintWriter output) {
        String oneLine;
        oneLine = "  Mileage     Reimbursement\r\n" +
                "----------   ---------------";
        output.println(oneLine);     // Output to the output file
        System.out.println(oneLine); // Echo to the console

    }  // End showHeading

    //****************************************************************************

    // Read the input file
    public static double getInput(Scanner input) {
        double miles = 0.0;
        miles = input.nextDouble();
        return miles;

    }  // End getInput

    //****************************************************************************

    // calculate reimbursement
    public static double calcReimb(double mileValue) {
        double reimbursement;
        double base = 0.0;
        double rate = 0.0;
        double overRate = 0.0;

        if (mileValue <= 0) {
            base = 0.0;
            rate = 0.0;
            overRate = 0.0;
        } else if (mileValue < 400) {
            base = 0.0;
            rate = 0.18;
            overRate = mileValue;
        } else if (mileValue < 900) {
            base = 65;
            rate = 0.15;
            overRate = mileValue - 400;
        } else if (mileValue < 1300) {
            base = 115;
            rate = 0.12;
            overRate = mileValue - 900;
        } else if (mileValue < 1900) {
            base = 140;
            rate = 0.10;
            overRate = mileValue - 1300;
        } else if (mileValue < 2600) {
            base = 165;
            rate = 0.08;
            overRate = mileValue - 1900;
        } else {
            base = 195;
            rate = 0.06;
            overRate = mileValue - 2600;
        }
        reimbursement = base + (rate * overRate);
        return reimbursement;
    }  // End calcReimb

    //****************************************************************************

    // Output
    public static void outputResult(PrintWriter output, int totalNumbers,
                                    int numPositive, double reimbursement,
                                    double sumReimbursement) {
        String oneLine;
        oneLine = "The number of mileage value is: "
                + tools.leftPad(totalNumbers, 11, "0", " ") +
                "\r\n" + "The number of positive miles is: "
                + tools.leftPad(numPositive, 10, "0", " ") +
                "\r\nThe total of reimbursement is: "
                + tools.leftPad(sumReimbursement, 12, TWO_PLACE, " ")
                + "\r\nProgram is written by ThienNgo N. Le";
        output.println(oneLine);      // Output to the output file
        System.out.println(oneLine);  // Echo to the console

    }  // End outputResult

}  // End class
           