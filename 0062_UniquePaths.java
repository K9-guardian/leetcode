import java.util.*;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] table = new int[m][n];

        // Precomputed paths for right column and bottom row.
        table[m - 1][n - 1] = 1;
        for (int i = 0; i < n - 1; i++)
            table[m - 1][i] = 1;
        for (int i = 0; i < m - 1; i++)
            table[i][n - 1] = 1;

        for (int i = m - 2; i >= 0; i--)
            for (int j = n - 2; j >= 0; j--)
                table[i][j] = table[i + 1][j] + table[i][j + 1];

        return table[0][0];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.uniquePaths(3, 7));
    }
}