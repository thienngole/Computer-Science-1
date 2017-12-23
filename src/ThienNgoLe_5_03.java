/*
Jeff Rowell
Multiple lines on same line
This is a test file with multiple lines of code on the same line errors.
Multiple lines of code on the same line errors: line 27 and line 40
*/

import java.util.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class ThienNgoLe_5_03 {

    public static void main(String[] args) {
        DecimalFormat twoPlaces = new DecimalFormat("0.00");
        DecimalFormat onePlaces = new DecimalFormat("0.0");
        double a, b, c;
        double perimeter;
        double s = 0;
        double area;
        String inputStr;
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
                "The unformated area of the triangle is: " + area + "\n");


        System.exit(0);
    }
}
      