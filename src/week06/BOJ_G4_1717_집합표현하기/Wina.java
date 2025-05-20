package week06.BOJ_G4_1717_집합표현하기;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Wina {
	
	// 초기 설정
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static StringTokenizer st;
	
	//	변수
	static int n, m;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
//		자기 자신으로 초기화
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int uf = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (uf == 0) {
//				union 연산
				union(a, b);
				
			} else {
//				find 연산
				if (find(a) == find(b)) {
					bw.write("YES\n");
				} else {
					bw.write("NO\n");
				}
			}
		}
		
		//	종료 설정
		br.close();
		bw.flush();
		bw.close();
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
//		같은 대표노드가 아니라면 b의 대표노드를 a로 설정
		if (a != b) {
			parent[b] = a;
		}
	}
	
	static int find(int a) {
//		현재 노드가 대표노드라면 반환
		if (a == parent[a]) {
			return a;
		}
//		부모를 따라 올라가서 대표 노드를 찾아서 반환
		else {
			return parent[a] = find(parent[a]);
		}
	}
	
}
