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
    TreeNode current;
    
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        current = dummy;

        inOrder(root);
        return dummy.right;
    }
    
    private void inOrder(TreeNode node) {
        if (node == null) return;

        inOrder(node.left);

        // Current node visit
        node.left = null;
        current.right = node;
        current = node;

        inOrder(node.right);
    }
}
