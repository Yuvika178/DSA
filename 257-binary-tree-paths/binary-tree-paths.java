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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) {
            return;
        }
        // Build the new path string
        // If path is empty, don't add "->"; otherwise, add "->" + current node value
        String newPath = path.isEmpty() ? 
                         Integer.toString(node.val) : 
                         path + "->" + node.val;

        // If leaf, add the path to results
        if (node.left == null && node.right == null) {
            result.add(newPath);
            return;
        }

        // Recurse on left and right
        if (node.left != null) {
            dfs(node.left, newPath, result);
        }
        if (node.right != null) {
            dfs(node.right, newPath, result);
        }
    }
}
