#!/usr/bin/env python
from typing import List

# https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        m, c = nums[0], 0

        for n in nums:
            if c == 0:
                m = n
                c = 1
            elif m == n:
                c += 1
            else:
                c -= 1
        
        return m

s = Solution()

print(s.majorityElement(nums = [3,2,3]))
print(s.majorityElement(nums = [2,2,1,1,1,2,2]))
