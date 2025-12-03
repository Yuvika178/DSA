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
// Definition for a binary tree node.
// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {

    private static class NodeInfo {
        int row;
        int val;
        NodeInfo(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, PriorityQueue<NodeInfo>> map = new TreeMap<>();
        dfs(root, 0, 0, map);

        List<List<Integer>> result = new ArrayList<>();
        for (var entry : map.entrySet()) {
            PriorityQueue<NodeInfo> pq = entry.getValue();
            List<Integer> colVals = new ArrayList<>();
            while (!pq.isEmpty()) {
                colVals.add(pq.poll().val);
            }
            result.add(colVals);
        }
        return result;
    }

    private void dfs(TreeNode node, int row, int col,
                     TreeMap<Integer, PriorityQueue<NodeInfo>> map) {
        if (node == null) return;

        map.putIfAbsent(col, new PriorityQueue<>(
            (a, b) -> a.row != b.row ? Integer.compare(a.row, b.row) : Integer.compare(a.val, b.val)
        ));

        map.get(col).offer(new NodeInfo(row, node.val));
        dfs(node.left,  row + 1, col - 1, map);
        dfs(node.right, row + 1, col + 1, map);
    }
}
