public class Solution {
    // https://en.wikipedia.org/wiki/Cycle_detection#Floyd's_tortoise_and_hare
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode tort = head.next, hare = head.next.next;

        while (tort != hare) {
            if (hare == null || hare.next == null) return false;

            tort = tort.next;
            hare = hare.next.next;
        }

        return true;
    }
}