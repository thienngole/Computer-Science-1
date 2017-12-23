/**
 * Interactive The Area of a Triangle Program Using JOptionPane
 * This program asks the user to input three sides of a triangle,
 * calculates the perimeter and the area of the triangle and displays the results.
 * Author: ThienNgo N. Le
 */

import java.util.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class ThienNgoLe_03 {

    public static void main(String[] args) {
        DecimalFormat twoPlaces = new DecimalFormat("0.00");
        DecimalFormat onePlaces = new DecimalFormat("0.0");
        double a, b, c;         // sides of a triangle
        double perimeter;       // perimeter is the sum of the sides
        double s = 0;           // s is half of the perimeter
        double area;            // the area of the triangle
        String inputStr;        // hold the line that is input from the user
        StringTokenizer st;


        inputStr = JOptionPane.showInputDialog("Enter sides of a triangle separated by spaces");
        st = new StringTokenizer(inputStr);
        a = Double.parseDouble(st.nextToken());
        b = Double.parseDouble(st.nextToken());
        c = Double.parseDouble(st.nextToken());

        perimeter = a + b + c;
        s = perimeter / 2.0;


        area = Math.sqrt(s * (s - a) * (s - b) * (s - c));


        JOptionPane.showMessageDialog(null, "The three sides of the triangle are: "
                + twoPlaces.format(a) + ", " + twoPlaces.format(b) + ", " +
                twoPlaces.format(c) + "\n" +
                "The perimeter of the triangle is: " + onePlaces.format(perimeter) + "\n" +
                "The area of the triangle is: " + onePlaces.format(area) + "\n" +
                "The unformated area of the triangle is: " + area + "\n" +
                "Program is written by ThienNgo N. Le");


        System.exit(0);
    } // End main
} // End class
      