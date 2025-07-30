package week15.네트워크;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Wina {
	
	Map<Integer, List<Integer>> graph = new HashMap<>();
	Set<Integer> isVisited = new HashSet<>();
	
	//	dfs 탐색
	public void dfs(int curV) {
//		방문 표시
		isVisited.add(curV);
//		현재 노드의 인접 노드들에 대해서 전체 방문
		for (int nextV : graph.get(curV)) {
//			방문한적이 없다면
			if (!isVisited.contains(nextV)) {
//				인접 노드로 이동
				dfs(nextV);
			}
		}
	}
	
	public void makeGraph(int n, int[][] computers) {
		//	인접리스트 생성
		for (int i = 0; i < n; i++) {
//			새로운 행 생성
			graph.put(i, new ArrayList<>());
//			해당 행의 배열을 순회하면서 추가
			for (int j = 0; j < n; j++) {
				if (computers[i][j] == 1) {
					graph.get(i).add(j);
				}
			}
		}
	}
	
	
	public int solution(int n, int[][] computers) {
//		인접리스트 생성
		makeGraph(n, computers);

//		네트워크 수
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
//			방문한적이 없다면 dfs 탐색
			if (!isVisited.contains(i)) {
//				한개의 네트워크 탐색 완료
				dfs(i);
				answer++;
			}
		}
		return answer;
	}
}

