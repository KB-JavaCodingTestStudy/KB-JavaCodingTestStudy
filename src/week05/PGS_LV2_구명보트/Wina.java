package week05.PGS_LV2_구명보트;

import java.util.Arrays;

class Wina {
	
	public int solution(int[] people, int limit) {
		int answer = 0;
//		오름차순 정렬
		Arrays.sort(people);
		
		int lightIdx = 0;
		int heavyIdx = people.length - 1;
		
		while (lightIdx <= heavyIdx) {
//			마지막 남은 인덱스일 때
			if (lightIdx == heavyIdx) {
				return ++answer;
			}
			
			int sum = people[lightIdx] + people[heavyIdx];
			if (sum <= limit) {
				lightIdx++;
			}
			
			heavyIdx--;
			answer++;
		}
		
		return answer;
	}
}
