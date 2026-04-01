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
    List<List<Integer>> answer = new ArrayList<>();
    int targetSum;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root != null) {
            this.targetSum = targetSum;
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            dfs(root, root.val, list);
        }
        return answer;
    }

    void dfs(TreeNode node, int currentSum, List<Integer> currentList) {
        if(node.left == null && node.right == null && currentSum == targetSum) {
            answer.add(List.copyOf(currentList));
            return;
        }

        if(node.left != null) {
            currentList.add(node.left.val);
            dfs(node.left, currentSum + node.left.val, currentList);
            currentList.remove(currentList.size()-1);
        }

        if(node.right != null) {
            currentList.add(node.right.val);
            dfs(node.right, currentSum + node.right.val, currentList);
            currentList.remove(currentList.size()-1);
        }
    }
}