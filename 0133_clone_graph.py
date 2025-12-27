#!/usr/bin/env python
from typing import Optional

class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []

    def __str__(self) -> str:
        return f"{self.val} -> {[neighbor.val for neighbor in self.neighbors]}"

class Solution:
    def dfs(self, node, visited, adjacency_matrix):
        if node is None:
            return
        elif visited[node.val]:
            return
        visited[node.val] = True
        for neighbor in node.neighbors:
            adjacency_matrix[node.val][neighbor.val] = True
            adjacency_matrix[neighbor.val][node.val] = True
            self.dfs(neighbor, visited, adjacency_matrix)

    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        visited = [False] * 101
        adjacency_matrix = [[False] * 101 for _ in range(101)]
        self.dfs(node, visited, adjacency_matrix)

        nodes = [None] * (101)
        for i in range(len(visited)):
            if visited[i]:
                nodes[i] = Node(i)

        for i in range(len(adjacency_matrix)):
            if visited[i]:
                nodes[i].neighbors = [nodes[j] for j in range(len(adjacency_matrix[i])) 
                                      if adjacency_matrix[i][j]]

        return nodes[1]

s = Solution()
nodes = [Node(i) for i in range(5)]
for [i, j] in [[1,2],[2,3],[3,4],[4,1]]:
    nodes[i].neighbors.append(nodes[j])
    nodes[j].neighbors.append(nodes[i])
print([str(node) for node in nodes])
copy = s.cloneGraph(nodes[1])
print(copy)
