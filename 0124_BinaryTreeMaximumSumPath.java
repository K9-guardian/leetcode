class Solution {
    public int maxPathSum(TreeNode root) {
        int[] res = { Integer.MIN_VALUE };
        maxPathSumRec(root, res);
        return res[0];
    }

    int maxPathSumRec(TreeNode node, int[] res) {
        if (node == null) return 0;

        int left = node.val + maxPathSumRec(node.left, res);
        int right = node.val + maxPathSumRec(node.right, res);
        int both = left + right - node.val;

        int compMax = Math.max(node.val, Math.max(left, right));
        res[0] = Math.max(compMax, Math.max(both, res[0]));
        return compMax;
    }
}
