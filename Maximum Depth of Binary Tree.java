/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxDepth = 0;

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;

        maxDepth = Math.max(maxDepth, depth);

        dfs(node.left, depth + 1);
        dfs(node.right, depth +1);
    }

    public int maxDepth(TreeNode root) {
        dfs(root, 1);
        return maxDepth;
    }
}
