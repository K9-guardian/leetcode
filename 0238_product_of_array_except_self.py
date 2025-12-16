from typing import List

class Solution(object):
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        # Create 2 new arrays pre and suf
        # pre[i] = pre[i - 1] * a[i - 1]
        # suf[i] = suf[i + 1] * a[i + 1]
        # Loop over input and multiply pre[i] * suf[i]

        # We can improve this solution by holding the precomputations in the output array
        out, val = [1] * len(nums), 1
        for i in range(0, len(nums)):
            out[i] *= val
            val *= nums[i]
        val = 1
        for i in range(len(nums) - 1, -1, -1):
            out[i] *= val
            val *= nums[i]
        return out
