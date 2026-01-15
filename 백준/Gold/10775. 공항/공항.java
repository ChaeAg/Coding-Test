import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parents = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            parents[i] = i;
        }

        int cnt = 0;
        for (int i = 1; i <= P; i++) {
            int g = Integer.parseInt(br.readLine());

            int root = rootFind(g);

            if (root == 0) {
                break;
            }

            cnt++;
            union(root, root - 1);
        }

        System.out.print(cnt);
    }

    static int rootFind(int x) {
        if (parents[x] != x) {
            parents[x] = rootFind(parents[x]);
        }
        return parents[x];
    }

    static void union(int x, int y) {
        int xRoot = rootFind(x);
        int yRoot = rootFind(y);

        if (xRoot != yRoot) {
            parents[x] = y;
        }
    }
}