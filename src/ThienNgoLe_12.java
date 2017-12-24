/**
 * Convert to Word Program
 * This program convert a dollar amount to words as is done when writing checks.
 * Author: ThienNgo N. Le
 */

import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class ThienNgoLe_12 {

    static Toolkit tools = new Toolkit();
    // Ten names
    static final String[] TEN_NAMES = {"","Ten","Twenty","Thirty","Forty","Fifty",
            "Sixty","Seventy","Eighty","Ninety"};
    // Unit names
    static final String[] NUM_NAMES = {"","One","Two","Three","Four","Five","Six",
            "Seven","Eight","Nine","Ten","Eleven",
            "Twelve","Thirteen","Fourteen","Fifteen",
            "Sixteen","Seventeen","Eighteen","Nineteen"};

    public static void main (String[]args) throws IOException {

        // Define the file's names
        final String INPUT_FILE  =
                "input\\ThienNgoLe_5_12_Input.txt";
        final String OUTPUT_FILE =
                "output\\ThienNgoLe_5_12_Output.txt";

        int nNum = 0;            // The number of valid dollar amounts
        double total = 0.0;      // The total valid dollar amounts
        double largest = 0.0;    // The largest valid amount
        double values = 0.0;     // The values dollar amount read from input file
        int dollars = 0;         // The value of dollars
        int cents = 0;           // The value of cents
        int thousand = 0;
        int hundred = 0;
        String WordToPrint = ""; // dollar amounts form word

        // Access the input file
        File inputDataFile = new File(INPUT_FILE);
        Scanner inputFile  = new Scanner(inputDataFile);

        // Access the output file
        FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
        PrintWriter outputFile = new PrintWriter(outputDataFile);

        // Print the heading
        Heading( outputFile);

        // Read data from input file and convert to word
        while (inputFile.hasNext()) {
            values = inputFile.nextDouble();

            // Identify the range of values process
            if (values > 0 && values < 1000) {
                ++ nNum; // count the number of valid dollar amounts
                total += values; // calculate the total of valid dollar amounts

                // Find the largest valid dollar amount
                if (values > largest) {
                    largest = values;
                }

                dollars = (int)(values); // Get the value of dollars
                cents = ((int)(values * 100) - (dollars * 100)); // Get the value of cents

                // Convert the values from 0.01 to 999.99
                if (dollars < 1000) {
                    WordToPrint = convertLessThanThousand (dollars, cents);
                }

                // Convert the values from 1000 to 9999.99
                else {
                    thousand = (int) values / 1000;
                    hundred = (int) values - thousand;
                    // Convert to word
                    WordToPrint = NUM_NAMES[thousand] + " Thousand "
                            + convertLessThanThousand (hundred, cents);

                } // End else of "Convert the values from 1000 to 9999.99"

            }// End if of "Identify the range of values process"

            // For the values that is out of range
            else {
                WordToPrint = "*** Number out of range";
            } // End else of "For the values that is out of range"

            // Print the detail to the input file and acho to the console
            printDetail(outputFile, values, WordToPrint);

        } // End while

        // Print summary information to the input file and acho to the console
        printSummary(outputFile, total, nNum, largest);

        // Close the input file
        inputFile.close();

        // Close the output file
        outputFile.close();

        // Exit
        System.exit(0);
    } // End main

    //****************************************************************************

    // Print the heading
    public static void Heading( PrintWriter output) {
        String line = "";
        line = " Data         In Words                                          \r\n"
                + "-----------  ------------------------------------------------------";

        output.println(line);     // Output to the output file
        System.out.println(line); // Echo to the console
    } // End Heading

    //****************************************************************************

    // Convert less than thousand
    public static String convertLessThanThousand(int dollars, int cents) {

        String wordPrint = "";
        if ((dollars % 100) < 20) {
            wordPrint = NUM_NAMES[dollars % 100];
            dollars = dollars / 100;
        }
        else {
            if (dollars % 10 == 0) {
                dollars /= 10;
                wordPrint = TEN_NAMES[dollars % 10];
            }
            else {
                wordPrint = NUM_NAMES[dollars % 10];
                dollars /= 10;
                wordPrint = TEN_NAMES[dollars % 10] + "-" + wordPrint;
                dollars /= 10;
            }
        }
        if (dollars ==0) {
            return wordPrint + " and " + cents + "/100 dollars";
        }
        return NUM_NAMES[dollars] + " Hundred " + wordPrint
                + " and " + cents +"/100 dollars";
    } // End convertLessThanThousand

    //****************************************************************************

    // Print detail
    public static void printDetail(PrintWriter output, double values,
                                   String wordToPrint) {
        String line = "";
        line = tools.leftPad(values, 10, "$0.00", " ") + "   " +
                tools.padString(wordToPrint, 100, "", " ");

        output.println(line);     // Output to the output file
        System.out.println(line); // Echo to the console

    } // End printDetail

    //****************************************************************************

    // Print summary
    public static void printSummary(PrintWriter output, double total,
                                    int nNum, double largest) {
        String line = "";
        line = "\r\nThe number of valid dollars: " + nNum +
                "\r\nThe total valid dollar amounts printed: " + total +
                "\r\nThe largest valid amount: " + largest +
                "\r\nProgram is written by ThienNgo N. Le";
        output.println(line);     // Output to the output file
        System.out.println(line); // Echo to the console

    } // End printSummary

} // End class
