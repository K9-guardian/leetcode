#!/usr/bin/env python
from typing import List

class Solution:
    def dfs(self, grid, row, col):
        if (not (0 <= row < len(grid))) \
                or (not (0 <= col < len(grid[0]))) \
                or grid[row][col] != "1":
            return
        grid[row][col] = "x"
        self.dfs(grid, row-1, col)
        self.dfs(grid, row+1, col)
        self.dfs(grid, row, col-1)
        self.dfs(grid, row, col+1)

    def numIslands(self, grid: List[List[str]]) -> int:
        islands = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1":
                    self.dfs(grid, i, j)
                    islands += 1
        return islands

s = Solution()
print(s.numIslands([
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]))
print(s.numIslands([
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]))
