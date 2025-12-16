#!/usr/bin/env python
from typing import List

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:

        def reverse(left, right):
            right -= 1
            while left < right:
                nums[left], nums[right] = nums[right], nums[left]
                left += 1
                right -= 1

        k %= len(nums)
        nums.reverse()
        reverse(0, k)
        reverse(k, len(nums))

s = Solution()

nums = [1,2,3,4,5,6,7]
s.rotate(nums, k = 3)
print(nums)
