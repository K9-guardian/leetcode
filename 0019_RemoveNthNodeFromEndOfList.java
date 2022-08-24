class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fst = head, snd = head;

        for (int i = 0; i < n; i++)
            snd = snd.next;

        if (snd == null) return head.next;

        while (snd.next != null) {
            fst = fst.next;
            snd = snd.next;
        }

        fst.next = fst.next.next;

        return head;
    }
}
