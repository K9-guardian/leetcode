import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }
        else {
            List<int[]> result = Arrays.stream(intervals).collect(Collectors.toList());

            // 2 pass solution for simplicity.
            // First, insert newInterval right before range[0] > newInterval[0].
            for (int i = 0; i <= result.size(); i++) {
                if (i == result.size()) {
                    result.add(newInterval);
                    break;
                }
                else if (result.get(i)[0] > newInterval[0]) {
                    result.add(i, newInterval);
                    break;
                }
            }

            // Next, scan over every consecutive pair and resolve overlaps.
            for (int i = 0; i < result.size() - 1; i++) {
                int[] left = result.get(i);
                int[] right = result.get(i + 1);

                if (left[1] >= right[0]) {
                    int[] range = new int[] { left[0], Math.max(left[1], right[1]) };
                    result.remove(i);
                    result.remove(i);
                    result.add(i, range);
                    i--;
                }
            }

            return result.toArray(new int[result.size()][]);
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInterval = {4,8};
        Solution sc = new Solution();
        System.out.println(Arrays.deepToString(sc.insert(intervals, newInterval)));
    }
}