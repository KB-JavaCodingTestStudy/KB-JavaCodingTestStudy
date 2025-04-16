package week02.BOJ_B2_25305_커트라인;

// ----------------------------------------------------------------------------------------------
// # 💡**문제 분석 요약**

// - **Input**
//     - 응시자 수 : N
//     - 상을 받는 사람 수: K
//     - 학생의 점수 N개(공백으로 구분)
// - **Output**
//     - 상을 받는 커트라인
    
// - **문제 분석**
//     - 정렬 후 뒤에서 K번째 사람 구하기

// # 💡**알고리즘 설계**

// - 응시자 수, 상을 받는 사람 수 입력
// - 학생의 점수 문자열 입력받기
// - StringTokenizer를 이용하여 공백으로 구분
// - hasMoreTokens()일 경우 반복(token이 있으면)
//     - 모든 토큰을 정수 리스트에 저장
// - 정수 리스트 정렬
// - 정수 리스트의 길이 - K(상을 받는 사람 수) 위치의 값 출력
//     - = 뒤에서 K번째 사람
// # 💡시간복잡도

// - O(nlogn) = sort() 함수 시간 복잡도
// ----------------------------------------------------------------------



import java.io.*; 
import java.util.*;

public class MJ {
    public static void main(String[] args) {
        try {
            // 빠른 입, 출력을 위한 BufferedReader, BufferedWriter 선언
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // test case 개수 받기 
            String nums=  br.readLine();
			String[] num = nums.split(" ");

			String scores=  br.readLine();

			//공백으로 구분
			StringTokenizer sb = new StringTokenizer(scores);
			//리스트 선언 
			List<Integer> score = new ArrayList<Integer>()  ;
			//정수 저장
			while (sb.hasMoreTokens()) {
				score.add(Integer.parseInt(sb.nextToken()));
			}
			
			//정렬
			score.sort(null);		

			//출력 
			bw.write(String.valueOf(score.get(score.size()-Integer.parseInt(num[1]))));
         	bw.flush();
        } catch (IOException e) {
			System.exit(1);
        }
    }

}

