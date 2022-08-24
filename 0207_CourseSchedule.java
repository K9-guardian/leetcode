import java.util.*;
import java.util.stream.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        // TODO: Clean this up with streams or smth.
        for (int[] dep : prerequisites)
            if (graph.containsKey(dep[1]))
                graph.get(dep[1]).add(dep[0]);
            else
                graph.put(dep[1], new HashSet<>(List.of(dep[0])));

        return acyclic(graph);
    }

    enum Mark { NONE, TEMPORARY, PERMANENT }

    // Simplification of https://en.wikipedia.org/wiki/Topological_sorting#Depth-first_search
    <T> boolean acyclic(Map<T, Set<T>> graph) {
        Map<T, Mark> marks = new HashMap<>();
        graph.forEach((key, val_) -> marks.put(key, Mark.NONE));

        try {
            while (marks.values().contains(Mark.NONE)) {
                T node = marks.entrySet()
                              .stream()
                              .filter(e -> e.getValue() == Mark.NONE)
                              .map(e -> e.getKey())
                              .findFirst()
                              .orElseThrow();
                visit(marks, graph, node);
            }
        } catch (IllegalArgumentException e) {
            return false;
        }

        return true;
    }

    <T> void visit(Map<T, Mark> marks, Map<T, Set<T>> graph, T node) {
        switch (marks.getOrDefault(node, Mark.NONE)) {
            case PERMANENT: return;
            case TEMPORARY: throw new IllegalArgumentException("Not a DAG");
            case NONE:
                marks.put(node, Mark.TEMPORARY);
                graph.getOrDefault(node, Set.of()).forEach(t -> visit(marks, graph, t));
                marks.put(node, Mark.PERMANENT);
        }
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1,0},{0,1}};
        Solution sol = new Solution();
        System.out.println(sol.canFinish(2, prerequisites));
    }
}
