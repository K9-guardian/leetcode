from typing import List

class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        i = 0

        for j in range(len(nums)):
            if nums[j] != val:
                nums[i] = nums[j]
                i += 1

        return i

s = Solution()

nums = [3,2,2,3]
print(s.removeElement(nums, val = 3))
print(nums)

nums = [0,1,2,2,3,0,4,2]
print(s.removeElement(nums, val = 2))
print(nums)
