#!/usr/bin/env python
from typing import List

class Solution:
    def dfs(self, heights, visited, row, col):
        visited[row][col] = True
        for (row_delta, col_delta) in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
            adj_row, adj_col = row + row_delta, col + col_delta
            if 0 <= adj_row < len(heights) \
                    and 0 <= adj_col < len(heights[0]) \
                    and not visited[adj_row][adj_col] \
                    and heights[row][col] <= heights[adj_row][adj_col]:
                self.dfs(heights, visited, adj_row, adj_col)

    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        pacific_flow = [[False] * len(heights[0]) for _ in range(len(heights))]
        for i in range(len(heights)):
            self.dfs(heights, pacific_flow, i, 0)
        for i in range(len(heights[0])):
            self.dfs(heights, pacific_flow, 0, i)
        
        atlantic_flow = [[False] * len(heights[0]) for _ in range(len(heights))]
        for i in range(len(heights)):
            self.dfs(heights, atlantic_flow, i, len(heights[0])-1)
        for i in range(len(heights[0])):
            self.dfs(heights, atlantic_flow, len(heights)-1, i)

        return [[i, j] for i in range(len(heights)) for j in range(len(heights[0])) 
                        if pacific_flow[i][j] and atlantic_flow[i][j]]

s = Solution()
print(s.pacificAtlantic([[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]))
