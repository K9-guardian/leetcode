#!/usr/bin/env python
from typing import List

class Solution:
    def dfs(self, board, visited, row, col, word):
        if word == "":
            return True
        visited[row][col] = True
        for (row_delta, col_delta) in [(1, 0), (-1, 0), (0, 1), (0, -1)]:
            adj_row, adj_col = row + row_delta, col + col_delta
            if 0 <= adj_row < len(board) \
                    and 0 <= adj_col < len(board[0]) \
                    and not visited[adj_row][adj_col] \
                    and board[adj_row][adj_col] == word[0] \
                    and self.dfs(board, visited, adj_row, adj_col, word[1:]):
                return True
        visited[row][col] = False
        return False

    def exist(self, board: List[List[str]], word: str) -> bool:
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    visited = [[False] * len(board[0]) for _ in range(len(board))]
                    if self.dfs(board, visited, i, j, word[1:]):
                        return True
        return False

s = Solution()
print(s.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCCED"))
print(s.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "SEE"))
print(s.exist([["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], "ABCB"))
