#!/usr/bin/env python
class Solution:
    def countSubstrings(self, s: str) -> int:
        res = 0
        for i in range(len(s)):
            start, end = i, i
            while 0 <= start <= end < len(s) and s[start] == s[end]:
                res += 1
                start -= 1
                end += 1

            start, end = i, i+1
            while 0 <= start <= end < len(s) and s[start] == s[end]:
                res += 1
                start -= 1
                end += 1
        return res

s = Solution()
print(s.countSubstrings("abc"))
print(s.countSubstrings("aaa"))
