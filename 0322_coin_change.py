#!/usr/bin/env python
from typing import List
import math

class Solution:
    def memoCoinChange(self, memo, coins, amount) -> float:
        if memo[amount] is not None:
            return memo[amount]
        if amount == 0:
            return 0
        res = min([math.inf]
                + [1 + self.memoCoinChange(memo, coins, amount - coin) 
                   for coin in coins 
                   if amount - coin >= 0])
        memo[amount] = res
        return res

    def coinChange(self, coins: List[int], amount: int) -> int:
        memo = [None] * (amount + 1)
        num_coins = self.memoCoinChange(memo, coins, amount)
        if num_coins == math.inf:
            return -1
        else:
            return int(num_coins)

s = Solution()
print(s.coinChange([1,2,5], 11))
print(s.coinChange([2], 3))
print(s.coinChange([1], 0))
