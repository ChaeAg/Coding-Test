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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        dfs(root, sb);
        return sum;
    }

    void dfs(TreeNode node, StringBuilder sb) {
        if(node.left == null && node.right == null) {
            sum += Integer.parseInt(sb.toString());
            return;
        }

        if(node.left != null) {
            sb.append(node.left.val);
            dfs(node.left, sb);
            sb.deleteCharAt(sb.length()-1);
        }

        if(node.right != null) {
            sb.append(node.right.val);
            dfs(node.right, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}