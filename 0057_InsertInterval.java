import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = Arrays.binarySearch(intervals, newInterval, (xs, ys) -> xs[1] - ys[0]);
        int j = Arrays.binarySearch(intervals, newInterval, (xs, ys) -> xs[0] - ys[1]);

        int fst = i < 0 ? ~i : i;
        int snd = j < 0 ? ~j : j;

        int[][] merged = new int[intervals.length - (snd - fst) + (j < 0 ? 1 : 0)][2];
        System.arraycopy(intervals, 0, merged, 0, fst);
        System.arraycopy(intervals, j < 0 ? ~j : j + 1, merged, fst + 1, merged.length - (fst + 1));

        int lower = Math.min(newInterval[0],
                             fst == intervals.length ? Integer.MAX_VALUE : intervals[fst][0]);
        int upper = Math.max(newInterval[1],
                             j < 0 && snd == 0
                           ? Integer.MIN_VALUE
                           : intervals[j < 0 ? snd - 1 : snd][1]);

        merged[fst] = new int[] { lower, upper };

        return merged;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,5}};
        int[] newInterval = {0,1};
        Solution sc = new Solution();
        System.out.println(Arrays.deepToString(sc.insert(intervals, newInterval)));
    }
}