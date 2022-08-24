import java.util.*;

class Solution {
    record Cell(TreeNode node, int level) { }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return List.of();

        List<List<Integer>> res = new ArrayList<>();
        Deque<Cell> queue = new ArrayDeque<>();
        queue.add(new Cell(root, 0));

        while (!queue.isEmpty()) {
            Cell cell = queue.poll();
            TreeNode node = cell.node();
            int level = cell.level();

            if (level < res.size())
                res.get(level).add(node.val);
            else
                res.add(level, new ArrayList<>(Arrays.asList(node.val)));

            if (node.left != null) queue.add(new Cell(node.left, level + 1));
            if (node.right != null) queue.add(new Cell(node.right, level + 1));
        }

        return res;
    }
}
