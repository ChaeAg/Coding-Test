import java.io.*;
import java.util.*;
public class Main {
    static StringBuilder sb = new StringBuilder();
    static Map<String, String> leftChild = new HashMap<>();
    static Map<String, String> rightChild = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            if (!left.equals(".")) {
                leftChild.put(root, left);
            }
            if (!right.equals(".")) {
                rightChild.put(root, right);
            }
        }

        for (int i = 0; i < 3; i++) {
            dfs(i, "A");
            sb.append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int cond, String nowNode) {
        String leftNode, rightNode;
        switch (cond) {
            case 0:
                sb.append(nowNode);
                leftNode = leftChild.get(nowNode);
                if (leftNode != null) {
                    dfs(cond, leftNode);
                }

                rightNode = rightChild.get(nowNode);
                if (rightNode != null) {
                    dfs(cond, rightNode);
                }
                return;
            case 1:
                leftNode = leftChild.get(nowNode);
                if (leftNode != null) {
                    dfs(cond, leftNode);
                }

                sb.append(nowNode);

                rightNode = rightChild.get(nowNode);
                if (rightNode != null) {
                    dfs(cond, rightNode);
                }
                return;
            case 2:
                leftNode = leftChild.get(nowNode);
                if (leftNode != null) {
                    dfs(cond, leftNode);
                }

                rightNode = rightChild.get(nowNode);
                if (rightNode != null) {
                    dfs(cond, rightNode);
                }

                sb.append(nowNode);
        }
    }
}