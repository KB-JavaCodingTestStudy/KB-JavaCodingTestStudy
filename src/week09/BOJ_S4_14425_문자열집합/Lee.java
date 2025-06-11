package algorithm.BOJ14425_문자열집합;

import java.util.*;
import java.io.*;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 집합 S에 속한 단어 N개가 주어지고, 확인할 단어 M개가 주어진다.
 *  - M개의 단어 중에서 집합 S에 속해있는 단어의 개수를 카운트하여 출력한다.
 *
 * # 입력
 *  - line 1: N M (N: 집합 S에 속한 단어 개수, M: 확인할 단어 개수)
 *  - line N줄: 집합 S에 속한 단어가 한줄에 하나씩
 *  - line M줄: 확인할 단어가 한줄에 하나씩
 *
 * # 출력
 *  - M개 단어 중에서 집합 S에 속한 단어의 개수
 *
 * 💻 알고리즘 설계
 *  - 집합 S에 속한 단어로 trie를 구성한다.
 *  - 이후 M개 단어를 차례로 확인하면서 trie에 있는지 확인한다.
 *
 * ================================================================
 */

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Node {
        Node children[] = new Node[26];
        boolean isEnd;
    }

    static class Trie {
        Node root = new Node();

        void insert(String word) {

            Node cur = root;

            for (char c : word.toCharArray()) {

                int i = c - 'a';

                if (cur.children[i] == null)
                    cur.children[i] = new Node();

                cur = cur.children[i];
            }

            cur.isEnd = true;
        }

        boolean search(String word) {

            Node cur = root;

            for (char c : word.toCharArray()) {
                int i = c - 'a';

                if (cur.children[i] == null)
                    return false;

                cur = cur.children[i];
            }

            return cur.isEnd;
        }
    }

    public static void main(String[] args) throws IOException {

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        Trie trie = new Trie();

        for(int i = 0; i < n; i++) {
            String word = br.readLine();
            trie.insert(word);
        }

        int cnt = 0;
        for(int i = 0; i < m; i++) {
            String word = br.readLine();
            if(trie.search(word)) {
                cnt++;
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
