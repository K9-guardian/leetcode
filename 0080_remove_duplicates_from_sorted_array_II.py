#!/usr/bin/env python
from typing import List

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        j = 2

        for i in range(2, len(nums)):
            if nums[i] != nums[j-2]:
                nums[j] = nums[i]
                j += 1

        return j

s = Solution()

nums = [1,1,2]
s.removeDuplicates(nums)
print(nums)

nums = [0,0,1,1,1,2,2,3,3,4]
s.removeDuplicates(nums)
print(nums)
