#!/usr/bin/env python
from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __str__(self) -> str:
        node = self
        acc = ""
        while node != None:
            acc += f"{node.val}"
            node = node.next
            if node != None:
                acc += ", "
        return f"[{acc}]"

class Solution:
    def interleave(self, head0, head1) -> None:
        if head0 is None or head1 is None:
            return
        next0 = head0.next
        next1 = head1.next
        head0.next = head1
        if next0 is not None:
            head1.next = next0
        self.interleave(next0, next1)

    def reorderList(self, head: Optional[ListNode]) -> None:
        length = 0
        node = head
        while node is not None:
            length += 1
            node = node.next

        if length < 2:
            return

        # Reverse the order of the second half of the list
        node0 = head
        node1 = head.next
        for _ in range(1, length // 2):
            node0 = node1
            node1 = node1.next

        node0.next = None
        tmp = node1.next
        node1.next = None
        node0 = node1
        node1 = tmp

        for _ in range(length // 2 + 1, length):
            tmp = node1.next
            node1.next = node0
            node0 = node1
            node1 = tmp

        # Interleave the lists
        self.interleave(head, node0)

s = Solution()

head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, None))))
s.reorderList(head)
print(head)

head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, None)))))
s.reorderList(head)
print(head)

head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6, None))))))
s.reorderList(head)
print(head)

head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6, ListNode(7, None)))))))
s.reorderList(head)
print(head)

head = ListNode(1, ListNode(2, ListNode(3, ListNode(4, ListNode(5, ListNode(6, ListNode(7, ListNode(8, None))))))))
s.reorderList(head)
print(head)
