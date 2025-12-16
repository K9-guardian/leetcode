#!/usr/bin/env python
from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        i, j = 0, 0
        m = 0
        prices.append(0)
        while j < len(prices):
            if prices[j-1] >= prices[j]:
                m += prices[j-1] - prices[i]
                i = j
            j += 1
        return m

s = Solution()

print(s.maxProfit([7,1,5,3,6,4]))
print(s.maxProfit([1,2,3,4,5]))
print(s.maxProfit([7,6,4,3,1]))
print(s.maxProfit([6,1,3,2,4,7]))
