import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Arrays::compare);

        Deque<int[]> merged = Arrays.stream(intervals)
                .parallel()
                .collect(ArrayDeque<int[]>::new,
                         (acc, e) -> {
                             int[] head = acc.peekLast();
                             if (head != null && head[1] >= e[0]) {
                                 acc.removeLast();
                                 acc.addLast(new int[] {head[0], Math.max(head[1], e[1])});
                             } else
                                 acc.addLast(e);
                         },
                         (acc1, acc2) -> {
                             int[] last = acc1.peekLast();
                             int[] first = acc2.peekFirst();
                             while (first != null && last != null && last[1] >= first[0]) {
                                 acc1.removeLast();
                                 acc1.addLast(new int[] {last[0], Math.max(last[1], first[1])});
                                 acc2.removeFirst();

                                 last = acc1.peekLast();
                                 first = acc2.peekFirst();
                             }
                             acc1.addAll(acc2);
                         }
                        );

        return merged.toArray(new int[merged.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{2,3},{4,5},{6,7},{8,9},{1,10}};
        Solution sc = new Solution();
        System.out.println(Arrays.deepToString(sc.merge(intervals)));
    }
}