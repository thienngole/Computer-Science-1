/**
 * Payroll Calculation Program
 * This program Calculate net pay using parallel and 2 dimensional arrays.
 * Author: ThienNgo N. Le
 */

import java.util.*;
import java.io.*;

public class ThienNgoLe_10_02 {

    static Toolkit tools = new Toolkit();
    static final int max = 30; // The maximun number of employees
    static String[] names = new String[max];  // Name of employees
    static double[][] values = new double[max][6];  // The parameter of employees
    static int nNames = 0;  // The number of employees

    public static void main(String[] args) throws IOException {
        String Line = "";         // Information to output
        double netPayTot = 0.0;   // The total of net pay
        double grossPayTot = 0.0; // The total of gross pay
        double fedTaxTot = 0.0;   // The total of federal tax
        double stateTaxTot = 0.0; // The total of state tax
        double rateAvg = 0.0;     // The average of pay rate
        double hourAvg = 0.0;     // The average of hour
        // Define the file's names
        final String INPUT_FILE = "input\\ThienNgoLe_5_010_Input.txt";
        final String OUTPUT_FILE = "output\\ThienNgoLe_5_010_Output.txt";

        // Access the input file
        File inputDataFile = new File(INPUT_FILE);
        Scanner inputFile = new Scanner(inputDataFile);

        // Access the output file
        FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
        PrintWriter outputFile = new PrintWriter(outputDataFile);

        // Explain and print heading
        Heading(outputFile);

        // Read data from the input file
        nNames = ReadData(inputFile, names, values);

        // Let the user know if the number of employees is greater than 30
        if (nNames > max) {
            Line = "The number of employees is greater than 30. \r\n" +
                    "Please check your employee list. Thank you!";
            System.out.println(Line);
            outputFile.println(Line);
            // Terminate the program
            System.exit(0);
        }

        // Calculate the gross pay
        CalcGrossPay(values, nNames);

        // Calculate the federal tax
        CalcFedTax(values, nNames);

        // Calculate the state tax
        CalcStateTax(values, nNames);

        // Calculate the net pay
        CalcNetPay(values, nNames);

        // Print detail
        PrintDetail(outputFile, names, values, nNames);

        // Calculate the total of net pay
        netPayTot = CalcNetPayTot(values, nNames);

        // Calculate the total of gross pay
        grossPayTot = CalcGrossPayTot(values, nNames);

        // Calculate the total of federal tax
        fedTaxTot = CalcFedTaxTot(values, nNames);

        // Calculate the total of state tax
        stateTaxTot = CalcStateTaxTot(values, nNames);

        // Calculate the average of pay rate
        rateAvg = CalcRateAvg(values, nNames);

        // Calculate the average of hours
        hourAvg = CalcHourAvg(values, nNames);

        // Summary output
        PrintSummary(outputFile, netPayTot, grossPayTot, fedTaxTot,
                stateTaxTot, rateAvg, hourAvg, nNames);

        // Sort the employees alphabetically
        Heading(outputFile); // Explain and print heading

//      tools.selectionSortStringWithNumbers(names, values, nNames, -1);
        // Summary output
        PrintSummary(outputFile, netPayTot, grossPayTot, fedTaxTot,
                stateTaxTot, rateAvg, hourAvg, nNames);

        // Sort by gross pay
        Heading(outputFile); // Explain and print heading
        // Sort by gross pay
//      tools.selectionSortStringWithNumbers(names, values, nNames, 2);
        // Summary output
        PrintSummary(outputFile, netPayTot, grossPayTot, fedTaxTot,
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
    public static void Heading(PrintWriter output) {
        String Line; // The information to output
        Line = "                      Fabulous Funiture Company\r\n"
                + "                           Payroll Report\r\n\r\n"
                + "       Name        Hours   Rate   Gross    NetPay   Ferderal   State\r\n"
                + "-----------------  -----  ------ -------   ------   --------   -----  ";
        output.println(Line);     // Output to the output file
        System.out.println(Line); // Echo to the console
    } // End heading

    //****************************************************************************

    // Read data from the input file
    public static int ReadData(Scanner input, String[] names, double[][] values) {
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
    public static double CalcGrossPay(double[][] values, int nNames) {
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
    public static double CalcFedTax(double[][] values, int nNames) {
        int i; // array's index
        for (i = 0; i < nNames; i++) {
            values[i][4] = values[i][2] * 0.18;
            values[i][4] = tools.roundNumber(values[i][4], 2);
        }
        return values[i][4];
    } // End CalcFedTax

    //****************************************************************************

    // Calculate the state tax
    public static double CalcStateTax(double[][] values, int nNames) {
        int i; // array's index
        for (i = 0; i < nNames; i++) {
            values[i][5] = values[i][2] * 0.45;
            values[i][5] = tools.roundNumber(values[i][5], 2);
        }
        return values[i][5];
    } // End CalcFedTax

    //****************************************************************************

    // Calculate the net pay
    public static double CalcNetPay(double[][] values, int nNames) {
        int i; // array's index
        for (i = 0; i < nNames; i++) {
            values[i][3] = values[i][2] - (values[i][4] + values[i][5]);
        }
        return values[i][3];
    } // End CalcNetPay

    //****************************************************************************

    // PrintDetail
    public static void PrintDetail(PrintWriter output, String[] names,
                                   double[][] values, int nNames) {

        String oneLine = ""; // information to output
        for (int i = 0; i < nNames; i++) {
            oneLine = tools.padString(names[i], 17, "", " ")
                    + tools.leftPad(values[i][0], 7, "0.00", " ")
                    + tools.leftPad(values[i][1], 7, "0.00", " ")
                    + tools.leftPad(values[i][2], 9, "0.00", " ")
                    + tools.leftPad(values[i][3], 9, "0.00", " ")
                    + tools.leftPad(values[i][4], 10, "0.00", " ")
                    + tools.leftPad(values[i][5], 10, "0.00", " ");
            System.out.println(oneLine); // Echo to the console
            output.println(oneLine);     //Output to the output file
        }
    }

    //****************************************************************************

    // Calculate the total of net pay
    public static double CalcNetPayTot(double[][] values, int nNames) {
        double totalNetPay = 0.0; // The total of net pay
        for (int i = 1; i <= nNames; i++) {
            totalNetPay += values[i][3];
        }
        return totalNetPay;
    } // End CalcNetPayTot

    //****************************************************************************

    // Calculate the total of gross pay
    public static double CalcGrossPayTot(double[][] values, int nNames) {
        double totalGrossPay = 0.0; // The total of gross pay
        for (int i = 1; i <= nNames; i++) {
            totalGrossPay += values[i][2];
        }
        return totalGrossPay;
    } // End CalcGrossPayTot

    //****************************************************************************

    // Calculate the total of federal tax
    public static double CalcFedTaxTot(double[][] values, int nNames) {
        double totalFedTax = 0.0; // The total of federal tax
        for (int i = 1; i <= nNames; i++) {
            totalFedTax += values[i][4];
        }
        return totalFedTax;
    } // End CalcFedTaxTot

    //****************************************************************************

    // Calculate the total of state tax
    public static double CalcStateTaxTot(double[][] values, int nNames) {
        double totalStateTax = 0.0; // The total of state tax
        for (int i = 1; i <= nNames; i++) {
            totalStateTax += values[i][5];
        }
        return totalStateTax;
    } // End CalcStateTaxTot

    //****************************************************************************

    // Calculate the average of pay rate
    public static double CalcRateAvg(double[][] values, int nNames) {
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
    public static double CalcHourAvg(double[][] values, int nNames) {
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
    public static void PrintSummary(PrintWriter output, double netPay,
                                    double gross, double fed,
                                    double state, double rate,
                                    double hour, int nNames) {
        String Line = ""; // information to output
        Line = "----------------------------------------------------------------------\r\n"
                + "Total: " + tools.leftPad(gross, 33, "0.00", " ")
                + tools.leftPad(netPay, 9, "0.00", " ")
                + tools.leftPad(fed, 10, "0.00", " ")
                + tools.leftPad(state, 10, "0.00", " ") + "\r\n"
                + "----------------------------------------------------------------------\r\n"
                + "Average: " + tools.leftPad(hour, 15, "0.00", " ")
                + tools.leftPad(rate, 7, "0.00", " ") + "\r\n"
                + "----------------------------------------------------------------------\r\n"
                + "The number of employees processed is: " + nNames + "\r\n"
                + "Program is written by ThienNgo N. Le\r\n";

        System.out.println(Line); // Echo to the console
        output.println(Line);     // Output to the output file

    }
} // End class