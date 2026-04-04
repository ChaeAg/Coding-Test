class Solution {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> answer = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serialize(root);
        return answer;
    }

    String serialize(TreeNode node) {
        if (node == null) return "#";

        // 이 노드를 루트로 한 서브트리 전체를 문자열로 표현
        String s = node.val + "," + serialize(node.left) + "," + serialize(node.right);

        map.put(s, map.getOrDefault(s, 0) + 1);

        // 정확히 2번째 등장할 때만 추가 (3번 이상이면 이미 추가했으니 스킵)
        if (map.get(s) == 2) {
            answer.add(node);  // 원래 트리의 실제 노드를 추가
        }

        return s;
    }
}