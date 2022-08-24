import java.util.*;

class Solution {
    void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    public void rotate(int[][] matrix) {
        int left = 0, top = 0;
        int right = matrix.length - 1, bottom = matrix.length - 1;

        while (left <= right) {
            for (int i = 0; i < right - left; i++) {
                swap(matrix, top, left + i, bottom - i, left);
                swap(matrix, bottom - i, left, bottom, right - i);
                swap(matrix, bottom, right - i, top + i, right);
            }

            left += 1;
            top += 1;
            right -= 1;
            bottom -= 1;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        Solution sol = new Solution();
        sol.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
