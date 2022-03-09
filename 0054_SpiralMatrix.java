import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length;
        int top = 0, bottom = matrix.length;
        List<Integer> result = new ArrayList<>();

        while (left < right && top < bottom) {
            for (int i = left; i < right; i++)
                result.add(matrix[top][i]);
            top++;

            for (int i = top; i < bottom; i++)
                result.add(matrix[i][right - 1]);
            right--;

            if (!(left < right && top < bottom))
                break;

            for (int i = right - 1; i > left - 1; i--)
                result.add(matrix[bottom - 1][i]);
            bottom--;

            for (int i = bottom - 1; i > top - 1; i--)
                result.add(matrix[i][left]);
            left++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        Solution sc = new Solution();
        System.out.println(sc.spiralOrder(matrix));
    }
}