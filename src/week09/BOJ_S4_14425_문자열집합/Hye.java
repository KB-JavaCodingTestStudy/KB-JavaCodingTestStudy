package week09.BOJ_S4_14425_문자열집합;

import java.io.*;
import java.util.*;

/* ================================================================
 *
 * Problem  : 문자열 집합_S4
 * Author   : 김혜지
 * Date     : 2025년 06월 11일
 *
 * ================================================================
 * 📌 문제 분석 요약
 * - N개의 문자열로 이루어진 집합 S
 *   입력으로 주어진 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성해야 한다.
 *
 * # 입력
 * - 1행 : 문자열의 개수 N과 M
 * - N행 : 집합 S에 포함되어 있는 문자열
 * - M행 : 검사해야 하는 문자열
 *
 * + 입력으로 주어지는 문자열을 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않는다.
 *    집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.
 *
 * # 출력
 * - M개의 문자열 중에 총 몇 개가 집합 S에 포함되어 있는지 출력
 *
 * ⏰ 시간복잡도
 * - O((N + M) × L)
     : (N개의 문자열을 각각 길이 L만큼 삽입하고, M개의 문자열을 각각 길이 L만큼 검색)
 * ================================================================
 */

public class Hye {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();
        for(int i = 0; i < N; i++){
            trie.insert(br.readLine());
        }

        int count = 0;
        for(int i = 0; i < M; i++){
            if(trie.search(br.readLine())){
                count++;
            }
        }

        System.out.println(count);

    }

    static class Node {
        Node[] children = new Node[26];
        boolean isEnd = false;
    }

    static class Trie {
        Node root = new Node();

        void insert(String word){
            Node node = root;
            for(char ch : word.toCharArray()){ // 문자열의 각 문자에 대해 반복
                int idx = ch - 'a';
                if(node.children[idx] == null) {
                    node.children[idx] = new Node(); // 해당 문자가 없으면 새 노드 생성
                }
                node = node.children[idx]; // 다음 노드로 이동
            }
            node.isEnd = true; // 마지막 문자에 도착하면 단어 끝 표시
        }

        boolean search(String word){
            Node node = root;
            for(char ch : word.toCharArray()){ // 문자열의 각 문자에 대해 반복
                int idx = ch - 'a';
                node = node.children[idx]; // 다음 노드로 이동
                if(node == null) return false; // 노드가 없으면 문자열 미포함
            }
            return node.isEnd; // 마지막 노드가 단어의 끝인지 확인
        }
    }
}
