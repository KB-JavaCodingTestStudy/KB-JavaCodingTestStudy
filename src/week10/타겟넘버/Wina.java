package week10.타겟넘버;

public class Wina {
	
	static int targetN;
	static int[] numbersN;
	static int answer;
	
	static void recursion(int idx, int num, int sum) {
//	반드시 실행
		sum += num;
//		탈출조건
		if (idx == numbersN.length - 1) {
			if (sum == targetN) {
				answer++;
			}
			return;
		}

//		탈출 안 할시 실행하는 로직
//		재귀
		recursion(idx + 1, numbersN[idx + 1], sum);
		recursion(idx + 1, -numbersN[idx + 1], sum);
//		백트래킹
	}
	
	public int solution(int[] numbers, int target) {
		answer = 0;
		targetN = target;
		numbersN = numbers;
		recursion(0, numbersN[0], 0);
		recursion(0, -numbersN[0], 0);
		return answer;
	}
}
