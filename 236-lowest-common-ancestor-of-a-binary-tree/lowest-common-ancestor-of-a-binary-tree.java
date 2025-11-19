/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base case
        if (root == null) {
            return null;
        }
        // If root is p or q, return root
        if (root == p || root == q) {
            return root;
        }
        
        // Recurse on left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // If both sides are non-null, root is LCA
        if (left != null && right != null) {
            return root;
        }
        
        // Otherwise return whichever side is non-null (or null)
        return (left != null) ? left : right;
    }
}
