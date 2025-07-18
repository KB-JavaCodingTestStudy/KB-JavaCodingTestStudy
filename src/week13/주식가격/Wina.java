package week13.주식가격;

class Wina {
	
	public int[] solution(int[] prices) {
		int[] answer = new int[prices.length];  // 각 주식 가격이 떨어지지 않은 시간을 저장할 배열
		
		// 주식 가격 배열을 순회
		for (int i = 0; i < prices.length; i++) {
			int time = 0;  // 시간을 초기화
			for (int j = i + 1; j < prices.length; j++) {  // 현재 가격 이후의 가격들과 비교
				time++;  // 시간이 지남
				if (prices[i] > prices[j]) {  // 가격이 떨어진 경우
					break;  // 루프를 종료
				}
			}
			answer[i] = time;  // 해당 인덱스에 시간을 저장
		}
		return answer;
	}
}
