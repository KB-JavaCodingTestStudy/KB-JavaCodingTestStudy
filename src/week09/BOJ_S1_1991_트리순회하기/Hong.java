import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        char left;
        char right;

        Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }

    static HashMap<Character, Node> tree = new HashMap<>();
    static StringBuilder preorderResult = new StringBuilder();
    static StringBuilder inorderResult = new StringBuilder();
    static StringBuilder postorderResult = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.put(root, new Node(left, right));
        }

        preorder('A');
        inorder('A');
        postorder('A');

        System.out.println(preorderResult);
        System.out.println(inorderResult);
        System.out.println(postorderResult);
    }

    static void preorder(char current) {
        if (current == '.') return;
        preorderResult.append(current);
        preorder(tree.get(current).left);
        preorder(tree.get(current).right);
    }

    static void inorder(char current) {
        if (current == '.') return;
        inorder(tree.get(current).left);
        inorderResult.append(current);
        inorder(tree.get(current).right);
    }

    static void postorder(char current) {
        if (current == '.') return;
        postorder(tree.get(current).left);
        postorder(tree.get(current).right);
        postorderResult.append(current);
    }
}
