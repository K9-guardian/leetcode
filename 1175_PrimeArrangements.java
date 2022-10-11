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
            do
                p++;
            while (p * p <= n && primes[p] == false);
        }
        System.out.println(Arrays.toString(primes));
        return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numPrimeArrangements(100));
    }
}
