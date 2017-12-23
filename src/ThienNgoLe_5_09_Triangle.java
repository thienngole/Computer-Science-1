/**
 * ThienNgoLe_5_09_Triangle - acquire and calculate area of a triangle
 * As of this writing, the area of a triangle is calculated. Its sides are
 * stored in three private instance variables, num1, num2, and num3.
 * <p>
 * Methods used:
 * ThienNgoLe_5_09_Triangle() - Default constructor initializes
 * side1, side2, and side3 to 0
 * ThienNgoLe_5_09_Triangle(double value1, double value2, double value3) -
 * Constructor that initializes side1 to value1,
 * side2 to value2, and side3 to value3
 * getSides() - prompts the user to input three sides of triangle to
 * side1, side2, and side3
 * getOneSide() - prompts the user to enter one side of a triangle
 * calPerimeter() - returns the perimeter of the triangle which has
 * sides1, sides2, and sides3
 * calcArea() - returns the area of the triangle which has length
 * side1, side2, and side3
 * outputSides () - outputs the value of side1, side2, and side3
 * <p>
 * ThienNgo N. Le
 * Program #9, CS 1050, Section 5
 * Jre 1.8.0_31, windows8 64-bit
 * postprandial: heppening after a meal
 * "You need to overecome the tug of people against you
 * as you reach for high goals." George S. Patton(1885-1945)
 */

import java.util.Scanner;

import java.text.DecimalFormat;

public class ThienNgoLe_5_09_Triangle {
    private double side1, side2, side3;
    Scanner console = new Scanner(System.in);
    static Toolkit tools = new Toolkit();

    //****************************************************************************

    // Default constructor - initialize side1, side2, and side3 to 0
    public ThienNgoLe_5_09_Triangle() {
        side2 = 0;
        side2 = 0;
        side3 = 0;
    } // End ThienNgoLe_5_09_Triangle()

    //****************************************************************************

    // Constructor initialize side1 to value1, side2 to value2, and side3 to value3
    public ThienNgoLe_5_09_Triangle(double value1, double value2, double value3) {
        side1 = value1;
        side2 = value2;
        side3 = value3;
    } // End ThienNgoLe_5_09_Triangle(double value2, double value2, double value3)

    //****************************************************************************

    // Get values of side1, side2 and side3 from the user
    public void getSides() throws Exception {
        side1 = getOneSide("first");
        side2 = getOneSide("second");
        side3 = getOneSide("third");
    }  // End getSides

    //****************************************************************************

    // Get a single side
    public double getOneSide(String which) throws Exception {
        double oneSide = 0.0;
        while (oneSide <= 0) {
            System.out.print("Enter your " + which + " side: ");
            oneSide = console.nextDouble();
            if (oneSide <= 0) {
                System.out.println("The value of oneSide must be greater than 0.");
            }  // End if
        }  // End while
        return oneSide;
    } // End getOneSide

    //****************************************************************************

    // Return the perimeter of the triangle
    public double calcPerimeter() {
        double p = 0.0; // The perimeter of the triangle

        // Calculate the perimeter of the triangle
        p = side1 + side2 + side3;
        return p;
    } // End calcPerimeter

    //****************************************************************************

    // Return the area of the triangle
    public double calcArea() {
        double s;     // half of the perimeter
        double area;  // The area of the triangle

        // Calculate half perimeter of the triangle
        s = calcPerimeter() / 2.0;

        // Calculate the area of the triangle
        area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return area;
    } // End calcArea

    //****************************************************************************

    // Output the value of the sides with a message
    public void outputSides() {
        System.out.print("The lengths of the sides of the triangle are: "
                + tools.leftPad(side1, 5, "0.00", " ")
                + ", " + tools.leftPad(side2, 5, "0.00", " ")
                + ", and " + tools.leftPad(side3, 5, "0.00", " "));
    } // End outputSides
} // End class
