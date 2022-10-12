import java.util.*;

class Solution {
    public static final int MOD = 1000000007;

    public int numPrimeArrangements(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[1] = false;

        int p = 2;
        while (p * p <= n) {
            for (int i = p * p; i <= n; i += p)
                primes[i] = false;
            do p++; while (p * p <= n && primes[p] == false);
        }

        int numPrimes = 0;
        for (int i = 1; i < primes.length; i++)
            if (primes[i])
                numPrimes++;

        long res = 1;
        for (int i = numPrimes; i > 0; i--) res = (res * i) % MOD;
        for (int i = n - numPrimes; i > 0; i--) res = (res * i) % MOD;

        return (int) res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numPrimeArrangements(100));
    }
}
