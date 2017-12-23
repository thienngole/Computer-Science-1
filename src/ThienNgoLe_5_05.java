/**
 * Interactive The Area of a Triangle Program
 * This program calculates area of a triangle using method
 * ThienNgo n. Le
 * Program #5, CS 1050, Section 5
 * Jre 1.8.0_31, windows8 64-bit
 * ornithology: a branch of science that deals with the study of birds
 * "Coming together is a beginning; keeping together is progress;
 * working together is success." Henry Ford(1863-1947)
 */

import java.util.*;

import java.text.DecimalFormat;

public class ThienNgoLe_5_05 {

    static Scanner console = new Scanner(System.in);
    static Toolkit tools = new Toolkit();

    public static void main(String[] args) {

        double side1, side2, side3;       // sides of a triangle
        double perimeter;                 // Perimeter is the sum of the sides
        double area;                      // area of the triangle

        // Explain the program to the user
        explain();

        // Input three sides of the triangle
        side1 = getOneSide(1);
        side2 = getOneSide(2);
        side3 = getOneSide(3);

        // Determine the perimeter of the triangle
        perimeter = calculatePerimeter(side1, side2, side3);

        // Determine the area of the triangle
        area = calculateArea(side1, side2, side3);

        // Output the results
        outputResults(side1, side2, side3, perimeter, area);

        System.exit(0);
    }  // End main

    //*****************************************************************************

    // Explain program to the user method
    public static void explain() {
        System.out.println("This program calculates the area of a triangle"
                + " entered by the user. \n"
                + "The output are the three sides of a triangle, the perimeter \n"
                + "and the area of the triangle, \n"
                + "Note: methods are used. \n"
                + "ThienNgo Le");
    }  // End Explain method

    //*****************************************************************************

    // Return the number input by the user
    public static double getOneSide(int whichSide) {
        double side;   // number input by the user
        System.out.print("Enter input value of side" + whichSide + ": ");
        side = console.nextDouble();
        return side;
    }  // End getOneSide method

    //*****************************************************************************

    // Determine the perimeter method
    public static double calculatePerimeter(double a, double b, double c) {
        return (a + b + c);
    }  // End calculatePerimeter method

    //*****************************************************************************

    // Determine the area method
    public static double calculateArea(double side1, double side2, double side3) {
        double s;
        s = calculatePerimeter(side1, side2, side3) / 2.0;
        return (Math.sqrt(s * (s - side1) * (s - side2) * (s - side3)));
    }  // End calculateArea method

    //*****************************************************************************

    // Out put the result method
    public static void outputResults(double value1, double value2, double value3,
                                     double perimeter, double area) {
        String side1Str, side2Str, side3Str;
        String perimeterStr;
        String areaStr;

        side1Str = tools.leftPad(value1, 8, "0.00", " ");
        side2Str = tools.leftPad(value2, 8, "0.00", " ");
        side3Str = tools.leftPad(value3, 8, "0.00", " ");
        perimeterStr = tools.leftPad(perimeter, 10, "0.00", " ");
        areaStr = tools.leftPad(area, 15, "0.00", " ");

        System.out.println("The lengths of the sides are : " +
                side1Str + side2Str + side3Str + "\n The perimeter is:" +
                perimeterStr + "\n The area is:" + areaStr);

        // Exit
        System.exit(0);
    }  // End outputResults method
} // End class
      