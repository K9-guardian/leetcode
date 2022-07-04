import java.util.*;

class Solution {
    static final int MOD = 1000000007;

    int dieSimulatorRec(int[][][] memo, int[] rollMax, int prev, int cnt, int i, int n) {
        if (memo[prev][cnt][i] != 0) {
            return memo[prev][cnt][i];
        }
        else if (i == n) {
            return 1;
        }
        else {
            int res = 0;

            for (int j = 1; j <= 6; j++) {
                if (j == prev && cnt > 1)
                    res = (res + dieSimulatorRec(memo, rollMax, j, cnt - 1, i + 1, n)) % MOD;
                else if (j != prev)
                    res = (res + dieSimulatorRec(memo, rollMax, j, rollMax[j - 1], i + 1, n)) % MOD;
            }

            memo[prev][cnt][i] = res;
            return res;
        }
    }

    public int dieSimulator(int n, int[] rollMax) {
        int[][][] memo = new int[7][16][5001];
        return dieSimulatorRec(memo, rollMax, 0, 0, 0, n);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] rollMax = {1, 1, 1, 2, 2, 3};
        System.out.println(sol.dieSimulator(3, rollMax));
    }
}