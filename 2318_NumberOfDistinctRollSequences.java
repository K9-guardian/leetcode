import java.util.*;

class Solution {
    static final int MOD = 1000000007;

    void deepArrayCopy(int[][] xs, int[][] ys) {
        for (int i = 0; i < xs.length; i++)
            System.deepArrayCopy(xs[i], 0, ys[i], 0, xs[i].length);
    }

    public int distinctSequences(int n) {
        if (n == 1) return 6;

        int[][] table = {{0, 1, 1, 1, 1, 1},
                         {1, 0, 1, 0, 1, 0},
                         {1, 1, 0, 1, 1, 0},
                         {1, 0, 1, 0, 1, 0},
                         {1, 1, 1, 1, 0, 1},
                         {1, 0, 0, 0, 1, 0}};
        int[][] newTable = new int[6][6];

        for (int i = 2; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (table[j][k] != 0) {
                        for (int l = 0; l < 6; l++)
                            if (l != j)
                                newTable[j][k] = (newTable[j][k] + table[k][l]) % MOD;
                    }
                }
            }
            deepArrayCopy(newTable, table);
            Arrays.stream(newTable).forEach(arr -> Arrays.fill(arr, 0));
        }

        return Arrays.stream(table)
                     .flatMapToInt(arr -> Arrays.stream(arr))
                     .reduce(0, (x, y) -> (x + y) % MOD);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.distinctSequences(20));
    }
}
