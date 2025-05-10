class Solution(object):
    def increasingTriplet(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        # Start with min1, min2 = infinity
        # Iterate over nums - we then replace min1, min2 with nums values accordingly
        # If we can't find such a value, then we must have found a triplet subsequence
        min1, min2 = float('inf'), float('inf')
        for n in nums:
            if n < min1:
                min1 = n
            elif min1 < n < min2:
                min2 = n
            elif min1 < min2 < n:
                return True
        return False
