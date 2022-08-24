import java.util.*;
import java.util.stream.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0), merged = dummy;
        Queue<ListNode> pq = new PriorityQueue<>((x, y) -> x.val - y.val);
        Arrays.stream(lists).filter(Objects::nonNull).forEach(e -> pq.add(e));

        while (!pq.isEmpty()) {
            ListNode list = pq.poll();
            merged.next = new ListNode(list.val);
            merged = merged.next;

            if (list.next != null)
                pq.add(list.next);
        }

        return dummy.next;
    }
}
