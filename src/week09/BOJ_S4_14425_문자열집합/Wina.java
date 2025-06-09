package week09.BOJ_S4_14425_문자열집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Wina {
	
	// 초기 설정
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	static Node root;
	
	public static void main(String[] args) throws IOException {
		int cnt = 0;
//		입력
		st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());

//		초기화
		root = new Node();

//		삽입
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			insert(word);
		}
//		검색
		for (int i = 0; i < M; i++) {
			String word = br.readLine();
			if (search(word)) {
				cnt++;
			}
		}

//		출력
		System.out.println(cnt);
		//	종료 설정
		br.close();
	}
	
	static void insert(String word) {
		Node node = root;
		for (char ch : word.toCharArray()) {
			int idx = ch - 'a';
			if (node.children[idx] == null) {
				node.children[idx] = new Node();
			}
			node = node.children[idx];
		}
		node.isEnd = true;
	}
	
	static boolean search(String word) {
		Node node = root;
		for (char ch : word.toCharArray()) {
			int idx = ch - 'a';
			if (node.children[idx] == null) {
				return false;
			}
			node = node.children[idx];
		}
		return node.isEnd;
	}
	
	
	static class Node {
		
		Node[] children = new Node[26];
		boolean isEnd = false;
	}
}

