package week12.타겟넘버;


class Wina {
	
	static int[] NUMBERS;
	static int TARGET;
	static int answer;
	
	static void recursion(int now, int idx) {
//		반드시 실행
		if (idx == NUMBERS.length) {
			//		탈출 조건
			if (now == TARGET) {
				answer++;
			}
			return;
		}
		int num = NUMBERS[idx];
//		재귀
		recursion(now + num, idx + 1);
		recursion(now - num, idx + 1);
	}
	
	public int solution(int[] numbers, int target) {
//		초기화
		answer = 0;
		TARGET = target;
		NUMBERS = numbers;
//		재귀함수 호출
		recursion(0, 0);
		return answer;
	}
}
