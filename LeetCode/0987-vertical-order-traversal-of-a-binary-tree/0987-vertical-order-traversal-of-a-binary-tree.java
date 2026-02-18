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
import java.util.*;
class Solution {
    Map<Integer, List<int[]>> map = new HashMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        search(root, 0, 0);

        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        List<List<Integer>> result = new ArrayList<>();
        for(int key : keySet) {
            List<Integer> tmp = new ArrayList<>();
            List<int[]> list = map.get(key);

            Collections.sort(list, (o1, o2) -> {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            });

            for(int[] arr : list) tmp.add(arr[1]);

            result.add(tmp);
        }

        return result;
    }

    public void search(TreeNode node, int row, int col) {
        if(node == null) return;
        map.computeIfAbsent(col, n -> new ArrayList<>()).add(new int[]{row, node.val});

        search(node.left, row+1, col-1);
        search(node.right, row+1, col+1);
    }
}