package week06.BOJ_S1_2529_부등호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Wina {
	
	// 초기 설정
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	//	변수
	static int k;
	//	부등호 배열
	static char[] equals;
	static boolean[] visited = new boolean[10];
	static List<String> results = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		equals = new char[k];
//		부등호 입력 받기
		for (int i = 0; i < k; i++) {
			equals[i] = st.nextToken().charAt(0);
		}

//		dfs
		dfs("", 0);

//		사전순 정렬 후 출력
		Collections.sort(results);
		System.out.println(results.get(results.size() - 1));
		System.out.println(results.get(0));
		
		//	종료 설정
		br.close();
	}
	
	static void dfs(String num, int depth) {
//		종료조건
		if (depth == k + 1) {
			results.add(num);
			return;
		}
//		0부터 9까지의 숫자를 시도
		for (int i = 0; i <= 9; i++) {
			if (visited[i]) {
				continue;
			}
//			첫 숫자이거나, 부등호 조건을 만족하면
			if (depth == 0 || check(num.charAt(depth - 1) - '0', i, equals[depth - 1])) {
				visited[i] = true;
				dfs(num + i, depth + 1);
				visited[i] = false; //백트래킹
			}
		}
	}
	
	static boolean check(int a, int b, char equal) {
		if (equal == '<') {
			return a < b;
		}
		if (equal == '>') {
			return a > b;
		}
		return false;
		
	}
	
}
