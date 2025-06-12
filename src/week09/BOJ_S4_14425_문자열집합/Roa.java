package BOJ.Silver;

/* ================================================================
 *
 * Problem  : BOJ 14425 - 문자열 집합
 * Author   : 김로아
 * Date     : 2025-06-12
 *
 * ================================================================
 * 📌 문제 분석 요약
 * 문자열 집합 S에 대해, 검사할 문자열이 S에 속하는지를 판단하는 문제.
 * 총 M개의 문자열에 대해, S에 포함된 문자열의 개수를 세어야 한다.
 *
 * # 입력
 * 첫 줄: 정수 N, M (1 ≤ N, M ≤ 10,000)
 * 다음 N줄: 집합 S에 포함된 문자열 (알파벳 소문자, 최대 길이 500)
 * 다음 M줄: 검사할 문자열
 *
 * # 출력
 * 집합 S에 포함된 검사 문자열의 개수 출력
 *
 * 💻 알고리즘 설계
 * - Trie 자료구조를 사용해 문자열 집합 S 저장
 * - 각 검사 문자열에 대해 Trie를 통해 포함 여부 탐색
 * - 포함되면 count 증가
 *
 * ⏰ 시간복잡도
 * - 문자열 삽입: O(N × L) — N개의 문자열, 길이 L까지
 * - 문자열 검색: O(M × L) — M개의 문자열, 길이 L까지
 * → 전체 시간복잡도: O((N + M) × L) (L은 최대 문자열 길이, 최대 500)
 *
 * ================================================================
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Roa {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            trie.insert(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            if (trie.search(br.readLine())) {
                count++;
            }
        }
        System.out.println(count);

    }

    static class Trie {
        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    return false;
                }
                node = node.children[idx];
            }
            return node.isEnd;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    return false;
                }
                node = node.children[idx];
            }
            return true;
        }
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }
}
