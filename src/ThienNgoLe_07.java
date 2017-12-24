/**
 * Process grades and names from an input file
 * This program produces a report in an output file
 * based on the range of grades
 * Author: ThienNgo N. Le
 */

import java.util.*;
import java.io.*;

public class ThienNgoLe_07 {

    static Toolkit tools = new Toolkit();

    public static void main(String[] args) throws IOException {

        int grade = 0;          // The grades of students
        int nNumbers = 0;       // The number of students
        int nNum70_89 = 0;      // The number of grade between 70 and 89
        double sum70_89 = 0.0;  // Total grade of all grade between 70 and 89
        double average = 0.0;   // The average of grade between 70 and 89
        String name = "";       // The name of students
        String message = "";    // The message about student
        String oneLine = "";    // Information to output

        // Define the file's names
        final String INPUT_FILE =
                "input\\ThienNgoLe_5_07_Input.txt";
        final String OUTPUT_FILE =
                "output\\ThienNgoLe_5_07_Output.txt";

        // Access the input file
        File inputDataFile = new File(INPUT_FILE);
        Scanner inputFile = new Scanner(inputDataFile);

        // Access the output file
        FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
        PrintWriter outputFile = new PrintWriter(outputDataFile);

        // Print the heading to the output file and echo to console
        heading(outputFile);

        // Reproting
        while (inputFile.hasNext()) {
            ++nNumbers;
            grade = inputFile.nextInt();
            name = inputFile.nextLine();
            name = name.trim();

            if (grade < 70) {
                message = "FAILING";
            } else if (grade <= 89) {
                message = "Satisfactory";

                // Count the number of students have grade between 70 and 89
                ++nNum70_89;

                // Calculate average of the grades between 70 and 89
                sum70_89 += grade;

            } else {
                message = "OUTSTANDING";
            }
            oneLine = tools.padString(name, 18, "", " ") +
                    tools.leftPad(grade, 10, "0", " ") + "        " +
                    tools.padString(message, 15, "", " ");
            outputFile.println(oneLine); // Output to the output file
            System.out.println(oneLine); // Echo output to the console
        } // End while
        if (nNum70_89 > 0) {
            average = sum70_89 / nNum70_89;
        }
        // output result
        outputResult(outputFile, nNumbers, nNum70_89, average);

        // Close the input file
        inputFile.close();

        // Close the output file
        outputFile.close();

        // Exit
        System.exit(0);

    } // End main

    //****************************************************************************

    // Heading method
    public static void heading(PrintWriter output) {
        String oneLine;
        oneLine = "       Name              Grade        Message\r\n" +
                "-------------------   ----------  ---------------";
        output.println(oneLine);     // Output to the output file
        System.out.println(oneLine); // Echo output to the console
    } // End heading

    //****************************************************************************

    // Output result method
    public static void outputResult(PrintWriter output, int nNumbers,
                                    int nNum70_89, double average) {
        String oneLine;
        oneLine = "\r\nThe number of students is: " +
                tools.leftPad(nNumbers, 5, "0", " ") +
                "\r\nThe number of students have grade between 70 and 89 is: " +
                tools.leftPad(nNum70_89, 5, "0", " ") +
                "\r\nThe average of the grade between 70 and 89 is: " +
                tools.leftPad(average, 5, "0.0", " ") +
                "\r\nProgram is written by ThienNgo N. Le";
        output.println(oneLine);     // Output to the output file
        System.out.println(oneLine); // Echo output to the console
    } // End outputResult
} // End class
