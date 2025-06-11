package algorithm.BOJ1991_트리순회;

import java.util.*;
import java.io.*;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 트리 순회 문제
 *
 * # 입력
 *  - line 1: n (노드 개수)
 *  - line 2~n+1: C L R (C: 현재 노드, L: 왼쪽 자식 노드, R: 오른쪽 자식 노드)
 *
 * # 출력
 *  - 전위 순회, 중위 순회, 후위 순회 결과를 한줄에 하나씩 차례로 출력
 *
 * 💻 알고리즘 설계
 *  - 전형적인 순회 문제... 입니다. 알고리즘은 밑에 직접 보시면 됩니다.
 *
 * ================================================================
 */

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Node {
        String left, right;

        Node(String left, String right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {



        int n = Integer.parseInt(br.readLine());

        Map<String, Node> tree = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            tree.put(input[0], new Node(input[1], input[2]));
        }

        preorder(tree, "A");
        bw.write("\n");
        inorder(tree, "A");
        bw.write("\n");
        postorder(tree, "A");
        bw.write("\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void preorder(Map<String, Node> tree, String cur) throws IOException {

        if (cur.equals(".")) return;

        Node curNode = tree.get(cur);

        bw.write(cur);
        preorder(tree, curNode.left);
        preorder(tree, curNode.right);
    }

    static void inorder(Map<String, Node> tree, String cur) throws IOException  {

        if (cur.equals(".")) return;

        Node curNode = tree.get(cur);

        inorder(tree, curNode.left);
        bw.write(cur);
        inorder(tree, curNode.right);
    }

    static void postorder(Map<String, Node> tree, String cur) throws IOException  {

        if (cur.equals(".")) return;

        Node curNode = tree.get(cur);

        postorder(tree, curNode.left);
        postorder(tree, curNode.right);
        bw.write(cur);
    }

}
