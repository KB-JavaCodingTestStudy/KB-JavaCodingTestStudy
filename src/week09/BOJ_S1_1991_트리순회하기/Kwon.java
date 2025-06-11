import java.io.*;
import java.util.*;

public class Main {

    static char[][] tree = new char[26][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree[parent - 'A'][0] = left;
            tree[parent - 'A'][1] = right;
        }

        // 전위, 중위, 후위 순회
        StringBuilder sb = new StringBuilder();
        preorder('A', sb);
        sb.append("\n");
        inorder('A', sb);
        sb.append("\n");
        postorder('A', sb);
        System.out.println(sb);
    }

    static void preorder(char node, StringBuilder sb) {
        if (node == '.') return;
        sb.append(node);
        preorder(tree[node - 'A'][0], sb);
        preorder(tree[node - 'A'][1], sb);
    }

    static void inorder(char node, StringBuilder sb) {
        if (node == '.') return;
        inorder(tree[node - 'A'][0], sb);
        sb.append(node);
        inorder(tree[node - 'A'][1], sb);
    }

    static void postorder(char node, StringBuilder sb) {
        if (node == '.') return;
        postorder(tree[node - 'A'][0], sb);
        postorder(tree[node - 'A'][1], sb);
        sb.append(node);
    }
}
