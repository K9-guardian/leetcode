import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                res.add(newInterval);
                for (int j = i; j < intervals.length; j++) res.add(intervals[j]);
                return res.stream().toArray(int[][]::new);
            } else if (newInterval[0] > intervals[i][1])
                res.add(intervals[i]);
            else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        res.add(newInterval);
        return res.stream().toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 5 } };
        int[] newInterval = { 0, 1 };
        Solution sc = new Solution();
        System.out.println(Arrays.deepToString(sc.insert(intervals, newInterval)));
    }
}
