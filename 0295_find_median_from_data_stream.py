#!/usr/bin/env python
from heapq import *

class MedianFinder:

    def __init__(self):
        self.bottom_half = [10e5] # max heap
        self.top_half = [10e5]    # min heap

    def addNum(self, num: int) -> None:
        bottom_max = -1 * self.bottom_half[0]
        top_min = self.top_half[0]

        if num < bottom_max:
            if len(self.top_half) == len(self.bottom_half):
                heappush(self.top_half, -1 * heapreplace(self.bottom_half, -1 * num))
            else:
                heappush(self.bottom_half, -1 * num)
        elif num > top_min:
            if len(self.top_half) == len(self.bottom_half):
                heappush(self.top_half, num)
            else:
                heappush(self.bottom_half, -1 * heapreplace(self.top_half, num))
        elif len(self.top_half) > len(self.bottom_half):
            heappush(self.bottom_half, -1 * num)
        else:
            heappush(self.top_half, num)

    def findMedian(self) -> float:
        print(self.bottom_half, self.top_half)
        if len(self.top_half) > len(self.bottom_half):
            return self.top_half[0]
        else:
            return (-1 * self.bottom_half[0] + self.top_half[0]) / 2
        
obj = MedianFinder()
obj.addNum
obj.addNum(1)
obj.addNum(2)
print(obj.findMedian())
obj.addNum(3)
print(obj.findMedian())

# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()
