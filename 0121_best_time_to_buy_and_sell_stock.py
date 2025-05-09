from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        i, j = 0, 0
        m = 0
        while j < len(prices):
            m = max(m, prices[j] - prices[i])
            if i == j:
                j += 1
            elif prices[j] < prices[i]:
                i += 1
            else:
                j += 1
        return m
