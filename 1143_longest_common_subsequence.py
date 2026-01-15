#!/usr/bin/env python
class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        memo = [[None] * len(text2) for _ in range(len(text1))]

        def memoLCS(memo, idx1, idx2):
            if idx1 >= len(text1) or idx2 >= len(text2):
                return 0
            if memo[idx1][idx2] is not None:
                return memo[idx1][idx2]
            res = None
            if text1[idx1] == text2[idx2]:
                res = 1 + memoLCS(memo, idx1+1, idx2+1)
            else:
                res = max(memoLCS(memo, idx1+1, idx2), memoLCS(memo, idx1, idx2+1))
            assert res is not None
            memo[idx1][idx2] = res
            return res

        return memoLCS(memo, 0, 0)

s = Solution()
print(s.longestCommonSubsequence("abcde", "ace"))
