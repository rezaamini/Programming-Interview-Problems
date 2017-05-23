package bitmanipulation;

import org.junit.Assert;
import org.junit.Test;

/**
 * Write a method that checks if an integer number is palindrome.
 *
 * Created by rezaamini on 2/12/17.
 */
public class PalindromeInteger {
    // Time complexity: O(n), where n is the number of digits
    public static boolean isPalindrome(int a) {
        if (a < 0) {
            return false;
        }

        // Mask LSD (least significant digit) and MSD (most significant digit) and check if they are equal
        int numDigits = (int)Math.floor(Math.log10(a)) + 1;
        int msdMask = (int)Math.pow(10, numDigits - 1);
        for (int i = 0; i < numDigits / 2; i++) {
            if (a / msdMask != a % 10) {
                return false;
            }
            a %= msdMask; // Remove msd
            a /= 10; // remove lsd
            msdMask /= 100; // because two digits are removed
        }

        return true;
    }

    // Time complexity: O(n), where n is the number of digits
    public static boolean isPalindrome2(int a) {
        // Revert the number and check of they are equal
        if (a < 0) {
            return false;
        }

        int reverse = Reverse.reverse(a);
        return a == reverse;
    }

    @Test
    public void testIsPalindrome() {
        Assert.assertTrue(isPalindrome(1234321));
        Assert.assertTrue(isPalindrome(123444321));
        Assert.assertTrue(isPalindrome(123321));

        Assert.assertFalse(isPalindrome(-1234321));
        Assert.assertFalse(isPalindrome(1321));
        Assert.assertFalse(isPalindrome(12345));
    }

    @Test
    public void testIsPalindrome2() {
        Assert.assertTrue(isPalindrome2(1234321));
        Assert.assertTrue(isPalindrome2(123444321));
        Assert.assertTrue(isPalindrome2(123321));

        Assert.assertFalse(isPalindrome2(-1234321));
        Assert.assertFalse(isPalindrome2(1321));
        Assert.assertFalse(isPalindrome2(12345));
    }
}
