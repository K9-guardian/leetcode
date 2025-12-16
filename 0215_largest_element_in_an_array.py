#!/usr/bin/env python
from typing import List
import heapq

class Solution(object):
    def findKthLargest(self, nums: List[int], k: int) -> int:
        # Add all nums to a min heap
        # Iteratively remove k elements - kth element removed will be our kth largest
        heapq.heapify(nums)
        for _ in range(len(nums) - k):
            heapq.heappop(nums)
        return heapq.heappop(nums)
