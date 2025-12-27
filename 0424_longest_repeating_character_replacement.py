#!/usr/bin/env python
class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        def char_to_idx(c):
            return ord(c) - ord('A')

        start, end = 0, 1
        freqs = [0] * 26
        freqs[char_to_idx(s[0])] += 1
        maxLen = k

        while start < end and end <= len(s):
            if (end - start) - max(freqs) <= k:
                maxLen = max(maxLen, end - start)
                if end < len(s):
                    freqs[char_to_idx(s[end])] += 1
                    end += 1
                else:
                    break
            else:
                freqs[char_to_idx(s[start])] -= 1
                start += 1
        
        return maxLen

s = Solution()
print(s.characterReplacement("ABAB", 2))
print(s.characterReplacement("AABABBA", 1))
print(s.characterReplacement("AAAA", 0))
