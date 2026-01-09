#!/usr/bin/env python
from typing import Optional

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        self.k = k
        self.kth = -1
        def inorderTraversal(node):
            if node is None:
                return
            inorderTraversal(node.left)
            self.k -= 1
            if self.k == 0:
                self.kth = node.val
            inorderTraversal(node.right)
        inorderTraversal(root)
        return self.kth
