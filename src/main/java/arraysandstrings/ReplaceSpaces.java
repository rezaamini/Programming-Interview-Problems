/*

   Write a method to replace all spaces in a string with '%20'.

 */

package arraysandstrings;

import java.util.Scanner;
/**
 *
 * @author Reza Amini
 */
public class ReplaceSpaces {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        
        System.out.println(replaceSpaces1(str));
    }
    
    /* Assuming all the characters are ASCII
     * Time complexity: O(n)
     */
    public static String replaceSpaces1(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) == ' ')
                sb.append("%20");
            else
                sb.append(str.charAt(i));
        }

        return new String(sb);
    }

    /*
     * Time complexity: O(n)
     */
    public static String replaceSpaces2(String str) {
        int num_spaces = 0;
        for (int i = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) == ' ')
                num_spaces++;
        }

        char[] newString = new char[str.length() + num_spaces * 2];
        
        for (int i = 0, pointer = 0 ; i < str.length() ; i++) {
            if (str.charAt(i) == ' ') {
                newString[pointer] = '%';
                newString[pointer+1] = '2';
                newString[pointer+2] = '0';
                pointer += 3;
            }
            else {
                newString[pointer] = str.charAt(i);
                pointer++;
            }
        }

        return new String(newString);
    }
}
