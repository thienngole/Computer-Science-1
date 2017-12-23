/**
 * Jeff Rowell
 * Line Length
 * Errors at lines: 27, 29, 31, 45
 */

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.*;

public class ThienNgoLe_5_02 {

    public static void main(String[] args) {
        DecimalFormat twoPlaces = new DecimalFormat("0.00");
        DecimalFormat onePlaces = new DecimalFormat("0.0");
        Scanner scnr = new Scanner(System.in);
        double a, b, c;                   // sides of a triangle
        double perimeter;                 // Perimeter is the sum of the sides
        double s = 0;                     // s is half of the perimeter
        double area;                      // The area of the triangle

        // Explain the program to the user
        System.out.println("This program calculates the area of a triangle");

        // Input three sides of the triangle
        System.out.print("Input the length of the first side of the triangle a: ");
        a = scnr.nextDouble();
        System.out.print("Input the length of the second side of the triangle b: ");
        b = scnr.nextDouble();
        System.out.print("Input the length of the third side of the triangle c: ");
        c = scnr.nextDouble();

        // Calculate the perimeter of the triangle
        perimeter = a + b + c;

        // Calculate half perimeter of the triangle
        s = perimeter / 2.0;

        // Calculate the area of the triangle
        area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

        // Output results
        System.out.print("The lengths of the sides of the triangle are ");
        System.out.println(twoPlaces.format(a) + ", " + twoPlaces.format(b) + ", " + twoPlaces.format(c));
        System.out.print("The perimeter of the triangle is: ");
        System.out.println(onePlaces.format(perimeter));
        System.out.print("The area of the triangle is: ");
        System.out.println(onePlaces.format(area));
        System.out.println("ThienNgo N. Le");

        // Close file and exist
        scnr.close();
        System.exit(0);
    } // End main
} // End class
      