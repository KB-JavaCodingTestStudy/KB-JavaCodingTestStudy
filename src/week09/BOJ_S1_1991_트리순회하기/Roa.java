package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* ================================================================
 *
 * Problem  : BOJ 1991 - 트리 순회
 * Author   : 김로아
 * Date     : 2025-06-12
 *
 * ================================================================
 * 📌 문제 분석 요약
 * 주어진 이진 트리 구조에 대해 전위, 중위, 후위 순회를 각각 수행하고,
 * 해당 순서대로 노드를 출력하는 문제.
 *
 * # 입력
 * 첫 줄: 노드 개수 N (1 ≤ N ≤ 26)
 * 다음 N줄: 각 노드에 대한 정보 (부모 노드, 왼쪽 자식, 오른쪽 자식)
 * - 노드는 대문자 알파벳(A~Z), 없으면 '.'
 *
 * # 출력
 * 첫 줄: 전위 순회 결과
 * 둘째 줄: 중위 순회 결과
 * 셋째 줄: 후위 순회 결과
 *
 * 💻 알고리즘 설계
 * - 노드는 최대 26개이므로 배열 또는 Map으로 노드 관계 저장 가능
 * - TreeNode 클래스를 정의해 트리 구성
 * - 전위/중위/후위 순회 각각 재귀로 구현
 *
 * ⏰ 시간복잡도
 * - 트리 순회: O(N), N은 노드 수 (최대 26)
 *
 * ================================================================
 */

public class Roa {

    // 노드 정보 저장용 클래스
    static class Node {
        char left;
        char right;

        public Node(char left, char right) {
            this.left = left;
            this.right = right;
        }
    }

    static Node[] tree = new Node[26]; // A~Z : 최대 26개 노드

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 트리 구성
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            tree[parent - 'A'] = new Node(left, right);
        }

        // 전위 순회
        preorder('A');
        System.out.println();

        // 중위 순회
        inorder('A');
        System.out.println();

        // 후위 순회
        postorder('A');
        System.out.println();
    }

    // 전위 순회 (루트 → 왼쪽 → 오른쪽)
    public static void preorder(char current) {
        if (current == '.') return;

        System.out.print(current);
        preorder(tree[current - 'A'].left);
        preorder(tree[current - 'A'].right);
    }

    // 중위 순회 (왼쪽 → 루트 → 오른쪽)
    public static void inorder(char current) {
        if (current == '.') return;

        inorder(tree[current - 'A'].left);
        System.out.print(current);
        inorder(tree[current - 'A'].right);
    }

    // 후위 순회 (왼쪽 → 오른쪽 → 루트)
    public static void postorder(char current) {
        if (current == '.') return;

        postorder(tree[current - 'A'].left);
        postorder(tree[current - 'A'].right);
        System.out.print(current);
    }
}
