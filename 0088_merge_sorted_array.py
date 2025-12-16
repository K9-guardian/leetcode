#!/usr/bin/env python
from typing import List

class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        i, j, k = m - 1, n - 1, m + n - 1

        while j >= 0:
            if i >= 0 and nums2[j] < nums1[i]:
                nums1[k] = nums1[i]
                i -= 1
            else:
                nums1[k] = nums2[j]
                j -= 1
            k -= 1

s = Solution()

nums1 = [1,2,3,0,0,0]
s.merge(nums1, m = 3, nums2 = [2,5,6], n = 3)
print(nums1)

nums1 = [1]
s.merge(nums1, m = 1, nums2 = [], n = 0)
print(nums1)

nums1 = [0]
s.merge(nums1, m = 0, nums2 = [1], n = 1)
print(nums1)
