package week09.BOJ_S1_1991_트리순회하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Wina {
	
	// 초기 설정
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	//	자료구조
	static Map<Character, Node> tree;
	
	public static void main(String[] args) throws IOException {
		final int N = Integer.parseInt(br.readLine());
		
		tree = new HashMap<>();
//		트리 구성
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

//			현재 노드가 없으면 생성
			tree.putIfAbsent(parent, new Node(parent));

//			왼쪽 자식
			if (left != '.') {
				tree.putIfAbsent(left, new Node(left));
				tree.get(parent).left = tree.get(left);
			}
			//			오른쪽 자식
			if (right != '.') {
				tree.putIfAbsent(right, new Node(right));
				tree.get(parent).right = tree.get(right);
			}
		}

//		초기값
		Node root = tree.get('A');

//		순회
		preOrder(root);
		System.out.println();
		inOrder(root);
		System.out.println();
		postOrder(root);
		System.out.println();
		
		//	종료 설정
		br.close();
	}
	
	//	전위순회
	static void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	//	중위순회
	static void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data);
		inOrder(node.right);
	}
	
	//	후위순회
	static void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data);
	}
	
	static class Node {
		
		char data;
		Node left, right;
		
		public Node(char data) {
			this.data = data;
		}
	}
	
}
