/**
 * Calculate mileage reimbursement using arrays and methods.
 * This program calculates mileage reimbursement based on a table
 * Author: ThienNgo N. Le
 */

import java.util.*;
import java.io.*;

public class ThienNgoLe_08 {

    static Toolkit tools = new Toolkit();
    static final String ONE_PLACE = "0.0";
    static final String TWO_PLACE = "0.00";

    public static void main(String[] args) throws IOException {

        int nNum = 0;          // The number of mileage values processed
        int positiveVal = 0;   // The number of mileage values that is greater than 0
        double miles[];        // Mileage values
        double reimb[];        // Reimbursement values
        double totMiles;       // The total of mileage values that were greater than 0
        double totReimb;       // The total of reimbursement values
        double avgReimb;       // The averages number of reimbursement
        double avgMiles;       // The averages number of miles traveled

        // Define the file's names
        final String INPUT_FILE =
                "input\\ThienNgoLe_5_08_Input.txt";
        final String OUTPUT_FILE =
                "output\\ThienNgoLe_5_08_Output.txt";

        // Access the input file
        File inputDataFile = new File(INPUT_FILE);
        Scanner inputFile = new Scanner(inputDataFile);

        //Access the output file
        FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
        PrintWriter outputFile = new PrintWriter(outputDataFile);

        // Print the heading to the output file and echo heading to console
        explainAndHeading(outputFile);

        // Read the values of mileage from the input file
        miles = readData(inputFile);

        // The number of mile values processed
        nNum = miles.length;

        // Calculate the value of reimbursement
        reimb = calcReimb(miles);

        // Count the mileage values that were greater than 0
        positiveVal = numPositive(miles);

        // Calculate the total of mileage traveled
        totMiles = mileageTotal(miles);

        // Calculate the total reimbursement
        totReimb = reimbTotal(reimb);

        // Calculate the average of miles traveled
        avgMiles = calcAvgMiles(miles);

        // Calculate the average of reimbursement
        avgReimb = calcAvgReimb(reimb, miles);

        // Write detail to the output file and echo to the console
        printDetail(outputFile, miles, reimb);


        // Write the summary result to the output file and echo to the console
        outputResult(outputFile, totReimb, nNum, positiveVal,
                totMiles, avgMiles, avgReimb);

        // Close the input file
        inputFile.close();

        // Close the output file
        outputFile.close();

        // Exit
        System.exit(0);

    }  // Emd main

    //****************************************************************************

    // Make the heading
    public static void explainAndHeading(PrintWriter output) {
        String oneLine; // The information to output
        oneLine = "This program uses arrays and methods to calculate\r\n" +
                "mileage reimbursement based on a table and output\r\n" +
                "the results to the output file and to the console\r\n" +
                "  Mileage     Reimbursement\r\n" +
                "----------   ---------------";
        output.println(oneLine);     // Output to the output file
        System.out.println(oneLine); // Echo to the console

    }  // End explainAndHeading

    //****************************************************************************

    // Read the input file
    public static double[] readData(Scanner input) {
        double[] localVal; // Mileage values read from the input file
        int nNum = 0;      // Number of values processed
        int i = 0;         // The index of values
        nNum = input.nextInt();
        localVal = new double[nNum];

        // Read the input file
        while (input.hasNext()) {
            localVal[i] = input.nextDouble();
            ++i;
        } // End while
        return localVal;

    }  // End readData

    //****************************************************************************

    // Calculate reimbursement
    public static double[] calcReimb(double[] mileage) {
        int len = mileage.length; // The length of the array
        int i = 0;                // The index of values
        double[] reimbursement = new double[len];

        // Calculate the reimbursement
        for (i = 0; i < len; ++i) {
            if (mileage[i] <= 0) {
                reimbursement[i] = 0.0;
            } else if (mileage[i] < 400) {
                reimbursement[i] = 0.18 * mileage[i];
            } else if (mileage[i] < 900) {
                reimbursement[i] = 65.00 + 0.15 * (mileage[i] - 400);
            } else if (mileage[i] < 1300) {
                reimbursement[i] = 115.00 + 0.12 * (mileage[i] - 900);
            } else if (mileage[i] < 1900) {
                reimbursement[i] = 140.00 + 0.10 * (mileage[i] - 1300);
            } else if (mileage[i] < 2600) {
                reimbursement[i] = 165.00 + 0.08 * (mileage[i] - 1900);
            } else {
                reimbursement[i] = 195.00 + 0.06 * (mileage[i] - 2600);
            }
        } // End for
        return reimbursement;

    } // End calcReimb

    //****************************************************************************

    // Print detail
    public static void printDetail(PrintWriter output, double[] miles,
                                   double[] reimb) {
        int len = miles.length; // The length of the array
        int i = 0;              // The index of values
        String oneLine = "";    // The information to output

        // print the detail
        for (i = 0; i < len; ++i) {
            if (miles[i] <= 0) {
                oneLine = tools.leftPad(miles[i], 10, ONE_PLACE, " ") +
                        "          *****";
                output.println(oneLine);     // Output to the output file
                System.out.println(oneLine); // Echo output to the console
                continue;
            } else {
                oneLine = tools.leftPad(miles[i], 10, ONE_PLACE, " ") +
                        tools.leftPad(reimb[i], 15, TWO_PLACE, " ");
                output.println(oneLine);     // Output to the output file
                System.out.println(oneLine); // Echo output to the console
            }
        } // End for
    } // End printDetail

    //****************************************************************************

    // Count number of mileage values greater than 0
    public static int numPositive(double[] miles) {
        int len = miles.length; // The length of the array
        int num = 0;            // The number of positive values

        // Count number of positive miles
        for (int i = 0; i < len; ++i) {
            if (miles[i] > 0) {
                num++;
            }  // End if
        }  // End for
        return num;
    }  // End numPositive

    //****************************************************************************

    // Calculate the total of mile traveled
    public static double mileageTotal(double[] miles) {
        int len = miles.length;  // The length of the array
        double totalMiles = 0.0; // The total of miles traveled

        // Calculate the total of mile traveled
        for (int i = 0; i < len; ++i) {
            if (miles[i] > 0) {
                totalMiles += miles[i];
            } // End if
        }  // End for
        return totalMiles;
    }  // End mileageTotal

    //****************************************************************************

    // Calculate the total of reimbursement
    public static double reimbTotal(double[] reimb) {
        int len = reimb.length;  // The length of the array
        double totalReimb = 0.0; // The total of the reimbursement

        // Calculate the total of reimbursement
        for (int i = 0; i < len; ++i) {
            totalReimb += reimb[i];
        } // End for
        return totalReimb;
    }  // End reimbTotal

    //****************************************************************************

    // Calculate the average miles
    public static double calcAvgMiles(double[] miles) {
        double totMiles = 0.0; // The total miles traveled
        double avgMiles = 0.0; // The average of miles traveled
        int numPo = 0;         // The number of mileage values greater than 0

        // Call the method numPositive to determine the value of numPo
        numPo = numPositive(miles);

        // Call the method mileageTotal to determine the value of totMiles
        totMiles = mileageTotal(miles);

        // Calculate the average of the miles traveled
        if (numPo > 0) {
            avgMiles = totMiles / numPo;
        } // End if
        return avgMiles;
    } // End calcavgMiles

    //****************************************************************************

    // Calculate the average Reimbursement
    public static double calcAvgReimb(double[] reimb, double[] miles) {
        double totReimb = 0.0; // The total of the reimbursement
        double avgReimb = 0.0; // The average of the reimbursement
        int numPo = 0;         // The number of mileage values greater than 0

        // Call the method numPositive to determine the value of numPo
        numPo = numPositive(miles);

        // Call the method reimbTotal to determine the value of totReimb
        totReimb = reimbTotal(reimb);

        // Calculate the average of the reimbursement
        if (numPo > 0) {
            avgReimb = totReimb / numPo;
        }
        return avgReimb;
    } // End calcAvgReimb

    //****************************************************************************

    // Output
    public static void outputResult(PrintWriter output, double totR, int nNum,
                                    int numP, double totM, double avgM,
                                    double avgR) {
        String oneLine;
        oneLine = "The total of the reimbursement values is: "
                + tools.leftPad(totR, 5, TWO_PLACE, " ") +
                "\r\n" + "The number of mileage values processed is: "
                + tools.leftPad(nNum, 5, "0", " ") +
                "\r\nThe number of mileage values that were greater than 0 is: "
                + tools.leftPad(numP, 5, "0", " ") +
                "\r\nThe total of mileage values that were greater than 0 is: "
                + tools.leftPad(totM, 5, TWO_PLACE, " ") +
                "\r\nThe average number of miles traveled is: "
                + tools.leftPad(avgM, 5, TWO_PLACE, " ") +
                "\r\nThe average reimbursement is: "
                + tools.leftPad(avgR, 5, TWO_PLACE, " ") +
                "\r\nProgram is written by ThienNgo N. Le";
        output.println(oneLine);      // Output to the output file
        System.out.println(oneLine);  // Echo to the console

    }  // End outputResult

}  // End class
           