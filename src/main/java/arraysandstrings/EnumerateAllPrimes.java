package arraysandstrings;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Write a method that enumerates all prime numbers to a given n.
 *
 * Created by rezaamini on 2/26/17.
 */
public class EnumerateAllPrimes {

    // Time complexity: O(n/2 + n/3 + n/5 + n/7 + n/11 + ...) = O(nloglogn), space complexity: O(n)
    public static List<Integer> enumerateAllPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(n + 1, true));

        isPrime.set(0, false);
        isPrime.set(1, false);
        for (int prime = 2; prime <= n; prime++) {
            if (isPrime.get(prime)) {
                primes.add(prime);
                for (int i = prime; i <= n; i += prime) {
                    isPrime.set(i, false);
                }
            }
        }

        return primes;
    }

    // We can remove non-prime numbers from P^2 instead of p, and ignore all even numbers
    // Asymptotic time complexity: O(nloglogn), asymptotic space complexity: O(n)
    public static List<Integer> enumerateAllPrimes2(int n) {
        // i-th element in isPrime represents number (2i + 3)
        final int size = (int)Math.floor(0.5 * (n - 3)) + 1;
        List<Integer> primes = new ArrayList<>();
        primes.add(2);

        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(size, true));
        for (int i = 0; i < size; i++) {
            if (isPrime.get(i)) {
                int prime = (i * 2) + 3; // prime^2 = 4i^2 + 12i + 9
                primes.add(prime);
                // We use long because it might overflow int
                // isPrime represents 2i + 3, so j = (prime * prime - 3) / 2
                for (long j = 2 * i * i + 6 * i + 3; j < size; j += prime) {
                    isPrime.set((int)j, false);
                }
            }
        }

        return primes;
    }

    @Test
    public void testEnumerateAllPrimes() {
        Assert.assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19), enumerateAllPrimes(22));
        Assert.assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29), enumerateAllPrimes(30));
    }

    @Test
    public void testEnumerateAllPrimes2() {
        Assert.assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19), enumerateAllPrimes2(22));
        Assert.assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29), enumerateAllPrimes(30));
    }
}
