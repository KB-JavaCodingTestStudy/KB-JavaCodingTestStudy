package week09.BOJ_S1_1991_트리순회하기;

/* ================================================================
 *
 * Problem  : 트리순회하기
 * Author   : 최승아
 * Date     : 2025-06-10
 *
 * ================================================================
 * 📌 문제 분석 요약
 * 이진트리를 구성하는 값들을 줬을 때
 * 전위/중위/후위 순회의 순서를 각각 출력하는 문제
 *
 * # 입력
 * N: 노드의 개수
 * for(N)
 *  부모노드 왼쪽자식노드 오른쪽자식노드
 *
 * # 출력
 * 전위/중위/후위 순회 결과
 *
 * 💻 알고리즘 설계
 * 이진트리 알고리즘을 그대로 사용하면 된다.
 * - 각 노드를 저장하는 클래스를 생성한다.
 * - 트리를 입력 받으면서 트리를 구성한다.
 * -- 이진트리에 같은 값은 한번만 존재하기 때문에 Map으로 구성한다.
 * -- parent가 없다면 새로 생성한다
 * -- .이 아닌 값들에 자식관계를 연결한다.
 * - root는 A임을 설정한다.
 * - 전위 중위 후위를 결정한다
 * -- 부모노드를 언제 방문하는지에 따라서 순회 결과가 발생된다.
 * -- 노드가 값을 가질 때까지 재귀과정을 거친다.
 *
 * ⏰ 시간복잡도
 * O(N)
 * ================================================================
 */

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
