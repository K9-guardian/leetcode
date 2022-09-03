import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Arrays::compare);
        Deque<int[]> merged = new ArrayDeque<>();

        for (int[] range : intervals) {
            int[] head = merged.peek();
            if (head != null && head[1] >= range[0]) {
                merged.pop();
                merged.push(new int[] { head[0], Math.max(head[1], range[1]) });
            } else
                merged.push(range);
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = { { 2, 3 }, { 4, 5 }, { 6, 7 }, { 8, 9 }, { 1, 10 } };
        System.out.println(Arrays.deepToString(sol.merge(intervals)));
    }
}
