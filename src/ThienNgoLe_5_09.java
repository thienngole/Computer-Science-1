/**
 * ThienNgoLe_5_09 - Calculate area of a triangle using class
 * This program asks the user  to input three sides of a triangle
 * and print the results.
 * It uses the class ThienNgoLe_5_09_Triangle to hold the length of sides.
 * <p>
 * Methods used:
 * explain() - expalin the program to the user
 * outputResults(ThienNgoLe_5_09_Triangle theSides, double area) - output
 * sides of a triangle and its area
 * <p>
 * Class methods used
 * getSides() - get valuas for the sides obtained from the user
 * calcArea() - return the area of the triangle
 * outputSides() - ouput the values of the sides and message
 * <p>
 * ThienNgo N. Le
 * Program #9, CS 1050, Section 5
 * Jre 1.8.0_31, windows8 64-bit
 * postprandial: heppening after a meal
 * "Accept the challenges so that you can feel the exhilaration of victory."
 * George S. Patton(1885-1945)
 */

public class ThienNgoLe_5_09 {
    static Toolkit tools = new Toolkit();

    public static void main(String[] argc) throws Exception {
        ThienNgoLe_5_09_Triangle theSides = new ThienNgoLe_5_09_Triangle();
        double area;        // The area of the triangle
        double perimeter;   // The perimeter of the triangle

        // Explain the program to the user
        explain();

        // Input the sides
        theSides.getSides();

        // Determine the perimeter of the triangle
        perimeter = theSides.calcPerimeter();

        // Determine the area of the triangle
        area = theSides.calcArea();

        // Output the result
        outputResults(theSides, perimeter, area);
    }  // End main

    //****************************************************************************

    // Explain the program to the user
    public static void explain() {
        System.out.println(
                "This program calculates the area of a triangle." +
                        "\nThe output is the sides, the perimeter and the area" +
                        " of the triangle." +
                        "\nClass ThienNgoLe_5_09_Triangle is used in this program." +
                        "\nThienNgoLe.");
    }  // End explain

    //****************************************************************************

    // Output the values of the sides of the triangle and its area
    public static void outputResults(ThienNgoLe_5_09_Triangle sides,
                                     double perimeter, double area) {
        sides.outputSides();
        System.out.println("\nThe perimeter of the triangle is: "
                + tools.leftPad(perimeter, 8, "0.00", " ")
                + "\nThe area of the triangle is: "
                + tools.leftPad(area, 8, "0.00", " "));
    }  // End outputResults
}  // End class3


