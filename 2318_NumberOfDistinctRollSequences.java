import java.util.*;

class Solution {
    boolean validAdjacency(int i, int j) {
        // Precomputed gcd(i, j) = 1 for 1 <= i, j = 6.
        boolean[][] adjacencies =
          {{true, true,  true,  true,  true,  true},
           {true, false, true,  false, true,  false},
           {true, true,  false, true,  true,  false},
           {true, false, true,  false, true,  false},
           {true, true,  true,  true,  false, true},
           {true, false, false, false, true,  false}};
        return adjacencies[i - 1][j - 1];
    }

    int distinctSequencesRec(int[][][] memo, int pprev, int prev, int i, int n) {
        if (memo[pprev][prev][i] != 0)
            return memo[pprev][prev][i];
        else if (i == n)
            return 1;
        else {
            int res = 0;

            switch (i) {
                case 0 -> {
                    for (int j = 1; j <= 6; j++)
                        res = (res + distinctSequencesRec(memo, j, prev, i + 1, n)) % 1000000007;
                }
                case 1 -> {
                    for (int j = 1; j <= 6; j++) {
                        if (pprev != j && validAdjacency(pprev, j)) {
                            res = (res + distinctSequencesRec(memo, pprev, j, i + 1, n))
                                 % 1000000007;
                        }
                    }
                }
                default -> {
                    for (int j = 1; j <= 6; j++) {
                        if (pprev != j && prev != j && validAdjacency(prev, j)) {
                            res = (res + distinctSequencesRec(memo, prev, j, i + 1, n))
                                 % 1000000007;
                        }
                    }
                }
            }

            memo[pprev][prev][i] = res;
            return res;
        }
    }

    public int distinctSequences(int n) {
        int[][][] memo = new int[7][7][10001];
        return distinctSequencesRec(memo, 0, 0, 0, n);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.distinctSequences(20));
    }
}