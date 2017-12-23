/**
 * Java input/output Program
 * This program uses files for input and output to read a file of
 * numbers and sum and average them.
 * ThienNgo N. Le
 * Program #4, CS 1050, Section 5
 * Jre 1.8.0_31, windows8 64-bit
 * Wisdom: knowledge that is gained by having many experiances in life.
 * "Life isn't about finding yourself. Life is about creating yourself"
 * George Bernard Shaw(1856-1950)
 */

import java.util.Scanner;       // Access the Scanner class.
import java.io.*;               // Access PrintWriter and related classes.

public class ThienNgoLe_5_04 {

    static Toolkit tools = new Toolkit();

    public static void main(String[] args) throws IOException {

        // Define the file's names
        final String INPUT_FILE =
                "C:\\Users\\thienngo\\Desktop\\ThienNgoLe_5_04_Input.txt";
        final String OUTPUT_FILE =
                "C:\\Users\\thienngo\\Desktop\\ThienNgoLe_5_04_Output.txt";

        // Declare variables
        int numberOfNumbers = 0; // Number of numbers in the input file
        double sum = 0;             // The sum of the numbers
        double average = 0;      // The average of the numbers read
        double nextNumber;         // An individual number read from the file
        String oneLine;          // Fast output
        final String TWO_PLACES = "0.00";

        // Access the input file
        File inputDataFile = new File(INPUT_FILE);
        Scanner inputFile = new Scanner(inputDataFile);

        //Access the output file
        FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
        PrintWriter outputFile = new PrintWriter(outputDataFile);

        // Begin program execution
        oneLine = "Reading  file " + INPUT_FILE + "\r\n" +
                "Creating file " + OUTPUT_FILE + "\r\n" +
                "  Number     Running Total\r\n" +
                "---------   ---------------";
        outputFile.println(oneLine); // Output to the output file
        System.out.println(oneLine); // Output to the console

        // Read the input file and sum the numbers.
        while (inputFile.hasNext()) {
            numberOfNumbers++;
            nextNumber = inputFile.nextDouble();
            sum += nextNumber;// Add the next number to the running total

            oneLine = tools.leftPad(nextNumber, 9, TWO_PLACES, " ") +
                    tools.leftPad(sum, 15, TWO_PLACES, " ");
            outputFile.println(oneLine);// Output to the output file
            System.out.println(oneLine);// Output to the console

        } //End while

        //calculate the average
        if (numberOfNumbers > 0) {
            average = sum / numberOfNumbers;
        }
        oneLine =
                "Number of numbers in the input file is " + numberOfNumbers + "\r\n" +
                        "Their sum is " + tools.leftPad(sum, 2, TWO_PLACES, "") + "\r\n" +
                        "and their average is " + tools.leftPad(average, 2, TWO_PLACES, "");

        System.out.println(oneLine); // Output to the console
        outputFile.println(oneLine); // Output to the output file

        // Close the input file
        inputFile.close();

        // Close the output file
        outputFile.close();

        // Close file and exist
        System.exit(0);
    } // End main
} // End class