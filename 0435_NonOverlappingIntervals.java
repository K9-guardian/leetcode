import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[1] - y[1]);

        int count = 1, end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++)
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println(sol.eraseOverlapIntervals(intervals));
    }
}
