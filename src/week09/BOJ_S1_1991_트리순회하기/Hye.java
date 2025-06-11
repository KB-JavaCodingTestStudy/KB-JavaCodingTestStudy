package week09.BOJ_S1_1991_트리순회하기;

/* ================================================================
 *
 * Problem  : 트리 순회_S1
 * Author   : 김혜지
 * Date     : 2025년 06월 11일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - 이진 트리를 입력받아 전위 순회, 중위 순회, 후위 순회한 결과를 출력하는 프로그램을 작성해야 한다.
 *
 * # 입력
 * - 1행 : 이진 트리의 노드의 개수 N
 * - N행 : 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드
 *
 * # 출력
 * - 1행 : 전위 순회 결과
 * - 2행 : 중위 순회 결과
 * - 3행 : 후위 순회 결과
 *
 *
 * ⏰ 시간복잡도
 * - O(N)
 * ================================================================
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Hye {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            char root = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);
            tree.put(root, new Node(left, right));
        }

        StringBuilder sb = new StringBuilder();
        preorder('A', sb);
        sb.append("\n");
        inorder('A', sb);
        sb.append("\n");
        postorder('A', sb);
        System.out.println(sb);
    }

    static class Node {
        char left;
        char right;

        Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }

    static Map<Character, Node> tree = new HashMap<>();

    // 전위 순회 : 루트 -> 왼쪽 -> 오른쪽
    static void preorder(char current, StringBuilder sb){
        if(current == '.') return;
        sb.append(current);
        preorder(tree.get(current).left, sb);
        preorder(tree.get(current).right, sb);
    }

    // 중위 순회 : 왼쪽 -> 루트 -> 오른쪽
    static void inorder(char current, StringBuilder sb){
        if(current == '.') return;
        inorder(tree.get(current).left, sb);
        sb.append(current);
        inorder(tree.get(current).right, sb);
    }

    // 후위 순회 : 왼쪽 -> 오른쪽 -> 루트
    static void postorder(char current, StringBuilder sb){
        if(current == '.') return;
        postorder(tree.get(current).left, sb);
        postorder(tree.get(current).right, sb);
        sb.append(current);
    }
}

