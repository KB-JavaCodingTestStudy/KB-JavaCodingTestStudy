package week04.PGS_Lv02_타겟넘버;

import java.util.Stack;

class Wina {
	
	public static int cnt;
	
	static int dfs(int[] numbers, int target) {
		int cnt = 0;

//		스택에는 현재 인덱스, 현재까지의 합 정보 저장
		Stack<int[]> stk = new Stack<>();
		stk.push(new int[]{0, 0}); //depth,sum

//		스택이 빌 때까지 반복
		while (!stk.isEmpty()) {
			int[] cur = stk.pop(); //현재 상태 꺼내기
			int idx = cur[0];
			int sum = cur[1];

//			종료조건
			if (idx == numbers.length) {
//				target과 동일한지 확인
				if (sum == target) {
					cnt++;
				}
				continue;
			}
//			다음 숫자를 더하거나 뺀 상태를 스택에 저장
			stk.push(new int[]{idx + 1, sum + numbers[idx]});
			stk.push(new int[]{idx + 1, sum - numbers[idx]});
		}
		return cnt;
	}
	
	public int solution(int[] numbers, int target) {
		int answer = 0;
		answer = dfs(numbers, target);
		return answer;
	}
}
