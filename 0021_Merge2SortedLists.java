class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode fst = list1, snd = list2;
        ListNode dummy = new ListNode(0), merged = dummy;

        while (fst != null && snd != null) {
            if (fst.val < snd.val) {
                merged.next = new ListNode(fst.val);
                fst = fst.next;
            }
            else {
                merged.next = new ListNode(snd.val);
                snd = snd.next;
            }
            merged = merged.next;
        }

        while (fst != null) {
            merged.next = new ListNode(fst.val);
            fst = fst.next;
            merged = merged.next;
        }

        while (snd != null) {
            merged.next = new ListNode(snd.val);
            snd = snd.next;
            merged = merged.next;
        }

        return dummy.next;
    }
}
