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
class Solution { // 전위순회
    int low, high;
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.low = low;
        this.high = high;
        traversal(root);
        return sum;
    }

    public void traversal(TreeNode root) {
        if(root == null) return;

        traversal(root.left); // 왼쪽 노드로

        if(root.val >= low && root.val <= high) { // 본인 노드
            sum += root.val;
            if(root.val == high) return;
        }

        traversal(root.right); // 오른쪽 노드로
    }
}