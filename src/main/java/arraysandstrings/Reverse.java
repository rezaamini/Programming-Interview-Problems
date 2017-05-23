/*

  Write code to reverse a C-Style String.
  (C-String means that “abcd” is represented as five characters,
  including the null character.)

 */

package arraysandstrings;

import java.util.Scanner;

/**
 *
 * @author Reza Amini
 */
public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        if (scanner.hasNext())
            input = scanner.next();

        System.out.println(reverseString(input));
    }

    // Time complexity: O(n/2), Space complexity: O(n)
    public static String reverseString(String str) {
        char[] reverseChars = new char[str.length()];
        int len = str.length();
        for(int i = 0 ; i < len/2 ; i++) {
            char temp = str.charAt(i);
            reverseChars[i] = str.charAt(len-1-i);
            reverseChars[len-1-i] = temp;
        }

        return new String(reverseChars);
    }
}
