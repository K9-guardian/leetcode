#!/usr/bin/env python
from typing import List

class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        res = nums[0]
        max_prod = min_prod = 1
        for x in nums:
            max_prod, min_prod = \
                    max(max_prod * x, min_prod * x, x), \
                    min(max_prod * x, min_prod * x, x)
            res = max(res, max_prod)
        return res
