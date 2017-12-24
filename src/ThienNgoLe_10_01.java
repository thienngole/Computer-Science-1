/**
 * Payroll Calculation Program
 * This program Calculate net pay using parallel and 2 dimensional arrays.
 * Author: ThienNgo N. Le
 */

import java.util.*;
import java.io.*;

public class ThienNgoLe_10_01 {

    static Toolkit tools = new Toolkit();
    static final int max = 30; // The maximun number of employees
    static String[] names = new String[max];  // Name of employees
    static double[][] values = new double[max][6];  // The parameter of employees
    static int nNames = 0;  // The number of employees

    public static void main(String[] args) throws IOException {

        String line = "";         // Information to output
        double netPayTot = 0.0;   // The total of net pay
        double grossPayTot = 0.0; // The total of gross pay
        double fedTaxTot = 0.0;   // The total of federal tax
        double stateTaxTot = 0.0; // The total of state tax
        double rateAvg = 0.0;     // The average of pay rate
        double hourAvg = 0.0;     // The average of hour
        // Define the file's names
        final String INPUT_FILE =
                "input\\ThienNgoLe_5_10_Input.txt";
        final String OUTPUT_FILE =
                "output\\ThienNgoLe_5_10_Output.txt";

        // Access the input file
        File inputDataFile = new File(INPUT_FILE);
        Scanner inputFile = new Scanner(inputDataFile);

        // Access the output file
        FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
        PrintWriter outputFile = new PrintWriter(outputDataFile);

        // Explain and print heading
        heading(outputFile);

        // Read data from the input file
        nNames = readData(inputFile, names, values);

        // Let the user know if the number of employees is greater than 30
        if (nNames > max) {
            line = "The number of employees is greater than 30. \r\n" +
                    "Please check your employee list. Thank you!";
            System.out.println(line);
            outputFile.println(line);
            // Terminate the program
            System.exit(0);
        }

        // Calculate the gross pay
        calcGrossPay(values, nNames);

        // Calculate the federal tax
        calcFedTax(values, nNames);

        // Calculate the state tax
        calcStateTax(values, nNames);

        // Calculate the net pay
        calcNetPay(values, nNames);

        // Print detail
        printDetail(outputFile, names, values, nNames);

        // Calculate the total of net pay
        netPayTot = calcNetPayTot(values, nNames);

        // Calculate the total of gross pay
        grossPayTot = calcGrossPayTot(values, nNames);

        // Calculate the total of federal tax
        fedTaxTot = calcFedTaxTot(values, nNames);

        // Calculate the total of state tax
        stateTaxTot = calcStateTaxTot(values, nNames);

        // Calculate the average of pay rate
        rateAvg = calcRateAvg(values, nNames);

        // Calculate the average of hours
        hourAvg = calcHourAvg(values, nNames);

        // Summary output
        printSummary(outputFile, netPayTot, grossPayTot, fedTaxTot,
                stateTaxTot, rateAvg, hourAvg, nNames);

        // Sort by name alphabetically
        heading(outputFile);

        tools.selectionSortStringWithNumbers(names, values, nNames, -1);

        printDetail(outputFile, names, values, nNames);

        printSummary(outputFile, netPayTot, grossPayTot, fedTaxTot,
                stateTaxTot, rateAvg, hourAvg, nNames);

        // Sort by gross pay
        heading(outputFile);

        tools.selectionSortStringWithNumbers(names, values, nNames, 2);

        printDetail(outputFile, names, values, nNames);

        printSummary(outputFile, netPayTot, grossPayTot, fedTaxTot,
                stateTaxTot, rateAvg, hourAvg, nNames);

        // Close the input file
        inputFile.close();

        // Close the output file
        outputFile.close();

        // Exit
        System.exit(0);
    } // End main

    //****************************************************************************

    // Make the heading
    public static void heading(PrintWriter output) {
        String line; // The information to output
        line = "                      Fabulous Funiture Company\r\n"
                + "                           Payroll Report\r\n\r\n"
                + "       Name        Hours   Rate   Gross    NetPay  Ferderal   State\r\n"
                + "-----------------  -----  ------ -------   ------  --------   -----  ";
        output.println(line);     // Output to the output file
        System.out.println(line); // Echo to the console
    } // End heading

    //****************************************************************************

    // Read data from the input file
    public static int readData(Scanner input, String[] names, double[][] values) {
        int nNames = 0;  // The number of employees

        while (input.hasNext() && nNames < max) {
            values[nNames][0] = input.nextDouble();
            values[nNames][1] = input.nextDouble();
            names[nNames] = input.nextLine().trim();
            ++nNames;
        }
        return nNames;
    } // End ReadData

    //****************************************************************************

    // Calculate the gross pay
    public static double calcGrossPay(double[][] values, int nNames) {
        int i; // array's index
        for (i = 0; i < nNames; i++) {
            if (values[i][0] <= 40.0) {
                values[i][2] = values[i][0] * values[i][1];
            } else if (values[i][0] <= 50.0) {
                values[i][2] = 40 * values[i][1]
                        + (values[i][0] - 40) * values[i][1] * 1.5;
            } else {
                values[i][2] = 40 * values[i][1] + 10 * values[i][1] * 1.5
                        + (values[i][0] - 50) * values[i][1] * 2.0;
            }
        }
        return values[i][2];
    } // End CalcGrossPay

    //****************************************************************************

    // Calculate the federal tax
    public static double calcFedTax(double[][] values, int nNames) {
        int i; // array's index
        for (i = 0; i < nNames; i++) {
            values[i][4] = values[i][2] * 0.18;
            values[i][4] = tools.roundNumber(values[i][4], 2);
        }
        return values[i][4];
    } // End CalcFedTax

    //****************************************************************************

    // Calculate the state tax
    public static double calcStateTax(double[][] values, int nNames) {
        int i; // array's index
        for (i = 0; i < nNames; i++) {
            values[i][5] = values[i][2] * 0.045;
            values[i][5] = tools.roundNumber(values[i][5], 2);
        }
        return values[i][5];
    } // End CalcFedTax

    //****************************************************************************

    // Calculate the net pay
    public static double calcNetPay(double[][] values, int nNames) {
        int i; // array's index
        for (i = 0; i < nNames; i++) {
            values[i][3] = values[i][2] - (values[i][4] + values[i][5]);
        }
        return values[i][3];
    } // End CalcNetPay

    //****************************************************************************

    // PrintDetail
    public static void printDetail(PrintWriter output, String[] names,
                                   double[][] values, int nNames) {

        String oneLine = ""; // information to output
        for (int i = 0; i < nNames; i++) {
            oneLine = tools.padString(names[i], 17, "", " ")
                    + tools.leftPad(values[i][0], 7, "0.00", " ")
                    + tools.leftPad(values[i][1], 7, "0.00", " ")
                    + tools.leftPad(values[i][2], 9, "0.00", " ")
                    + tools.leftPad(values[i][3], 9, "0.00", " ")
                    + tools.leftPad(values[i][4], 10, "0.00", " ")
                    + tools.leftPad(values[i][5], 8, "0.00", " ");
            System.out.println(oneLine); // Echo to the console
            output.println(oneLine);     //Output to the output file
        }
    }

    //****************************************************************************

    // Calculate the total of net pay
    public static double calcNetPayTot(double[][] values, int nNames) {
        double totalNetPay = 0.0; // The total of net pay
        for (int i = 1; i <= nNames; i++) {
            totalNetPay += values[i][3];
        }
        return totalNetPay;
    } // End CalcNetPayTot

    //****************************************************************************

    // Calculate the total of gross pay
    public static double calcGrossPayTot(double[][] values, int nNames) {
        double totalGrossPay = 0.0; // The total of gross pay
        for (int i = 1; i <= nNames; i++) {
            totalGrossPay += values[i][2];
        }
        return totalGrossPay;
    } // End CalcGrossPayTot

    //****************************************************************************

    // Calculate the total of federal tax
    public static double calcFedTaxTot(double[][] values, int nNames) {
        double totalFedTax = 0.0; // The total of federal tax
        for (int i = 1; i <= nNames; i++) {
            totalFedTax += values[i][4];
        }
        return totalFedTax;
    } // End CalcFedTaxTot

    //****************************************************************************

    // Calculate the total of state tax
    public static double calcStateTaxTot(double[][] values, int nNames) {
        double totalStateTax = 0.0; // The total of state tax
        for (int i = 1; i <= nNames; i++) {
            totalStateTax += values[i][5];
        }
        return totalStateTax;
    } // End CalcStateTaxTot

    //****************************************************************************

    // Calculate the average of pay rate
    public static double calcRateAvg(double[][] values, int nNames) {
        double totalRate = 0.0; // The total of pay rate
        double avgRate = 0.0;   // The average of pay rate
        for (int i = 1; i <= nNames; i++) {
            totalRate += values[i][1];
        }
        if (nNames > 0) {
            avgRate = totalRate / nNames;
        }
        return avgRate;
    } // End CalcRateAvg

    //****************************************************************************

    // Calculate the average of hours
    public static double calcHourAvg(double[][] values, int nNames) {
        double totalHour = 0.0; // The total of hour
        double avgHour = 0.0;   // The average of hour
        for (int i = 1; i <= nNames; i++) {
            totalHour += values[i][0];
        }
        if (nNames > 0) {
            avgHour = totalHour / nNames;
        }
        return avgHour;
    } // End CalcHourAvg

    //****************************************************************************

    //PrintSummary(outputFile, names, values)
    public static void printSummary(PrintWriter output, double netPay,
                                    double gross, double fed,
                                    double state, double rate,
                                    double hour, int nNames) {
        String line = ""; // information to output
        line = "----------------------------------------------------------------------\r\n"
                + "Total: " + tools.leftPad(gross, 33, "0.00", " ")
                + tools.leftPad(netPay, 9, "0.00", " ")
                + tools.leftPad(fed, 10, "0.00", " ")
                + tools.leftPad(state, 8, "0.00", " ") + "\r\n"
                + "----------------------------------------------------------------------\r\n"
                + "Average: " + tools.leftPad(hour, 15, "0.00", " ")
                + tools.leftPad(rate, 7, "0.00", " ") + "\r\n"
                + "----------------------------------------------------------------------\r\n"
                + "The number of employees processed: " + nNames + "\r\n"
                + "Program is written by ThienNgo N. Le\r\n";
        System.out.println(line); // Echo to the console
        output.println(line);     // Output to the output file

    } // End printSummary
} // End class