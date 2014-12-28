/*
 
   Assume you have a method isSubstring which checks if one word is a substring
   of another. Given two strings, s1 and s2, write code to check if s2 is a
   rotation of s1 using only one call to isSubstring
   (i.e., “waterbottle” is a rotation of “erbottlewat”).
 
 */

package ArraysAndStrings;

import java.util.Scanner;

/**
 *
 * @author Reza Amini
 */
public class IsRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        String s2 = scanner.next();

        System.out.println(isRotation(s1, s2));
    }

    // We concatinate s1 with itself. All possible rotations of s1 are in the new string.
    public static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;

        return isSubstring(s2, s1 + s1);
    }

    public static boolean isSubstring(String s1, String s2) {
        return s2.indexOf(s1) >= 0;
    }
}
