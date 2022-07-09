import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] { newInterval };
        }
        else {
            Deque<int[]> lst = new ArrayDeque<>();

            // 2 pass solution for simplicity.
            // First, insert newInterval right before range[0] > newInterval[0].
            for (int i = 0; i <= intervals.length; i++) {
                if (i == intervals.length) {
                    lst.add(newInterval);
                }
                else if (intervals[i][0] > newInterval[0]) {
                    lst.add(newInterval);
                    lst.add(intervals[i]);
                }
                else {
                    lst.add(intervals[i]);
                }
            }

            Deque<int[]> result = new ArrayDeque<>();
            result.addLast(lst.getFirst());
            lst.removeFirst();

            // Next, scan over every interval and resolve conflicts while adding.
            for (int[] range : lst) {
                int[] prev = result.peekLast();

                if (prev[1] >= range[0]) {
                    int[] merge = new int[] { prev[0], Math.max(prev[1], range[1]) };
                    result.removeLast();
                    result.addLast(merge);
                }
                else {
                    result.addLast(range);
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