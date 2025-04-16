package week02.BOJ_B2_17608_막대기;

import java.io.*;
import java.util.*;

// -----------------------------------------------------------------------------

// # 💡**문제 분석 요약**

// - **Input**
//     - 막대기 개수(n)
//     - n개의 막대기 길이(왼→오)
// - **Output**
//     - 가장 오른쪽에서 보았을 때 보이는 막대기 개수
// - **문제 분석**
//     - 오른쪽에 길이가 같거나 더 긴 막대기가 있으면 보이지 않는다.

// # 💡**알고리즘 설계**

// - 막대기 개수(n) 입력
// - 막대기 개수에 대하여 아래 반복(for 문)
//     1. 정수(막대기 길이)를 입력
//     2. 만약 Stack에 요소가 존재하면서 Stack의 마지막 요소가 작으면 반복
//         1. stack.pop()으로 보이지 않는 요소를 제거
//         2. 반복문으로 모든 작은 값들 제거
//     3. 새로운 막대기 추가
//     4. Stack의 길이 출력
//         1. 가려져서 보이지 않는 막대기의 pop()으로 제거되었으므로 보이는 막대기만이 Stack에 존재함으로 길이를 출력하면 보이는 막대기의 개수를 알 수 있다.
// # 💡시간복잡도

// - O(n): 제거를 n번 이상 불가

// --------------------------------------------------------------------------------------------------------------------


public class MJ {
    public static void main(String[] args) {
        try {
            // 빠른 입, 출력을 위한 BufferedReader, BufferedWriter 선언
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // 한 줄 읽어 정수로 변환 
            int n= Integer.parseInt(br.readLine());

			//정수 Stack 선언
			Stack<Integer> stack=new Stack<>();

			//막대기 개수만큼 반복
			for(int i=0; i<n; i++){
				
				//한 줄씩 읽어 정수로 변환 
				int num = Integer.parseInt(br.readLine()); 	
	 
				//Stack이 비어있지 않고 맨 위(나중)에 있는 요소가 num보다 작거나 같으면
				while(!stack.isEmpty() && stack.lastElement() <= num){
					//제거: 가려져서 보이지 않으므로
					stack.pop();
				} 

				//현재 값 추가
				stack.push(num); 	 
			}

			//보이지 않는 막대기는 제거되고 보이는 것들만 남았으므로 Stack에 존재하는 값 출력
           	bw.write(String.valueOf(stack.size())); //String.valueOf 안하면 출력이 안됨 
			//숫자만 있으면 유니코드 5번인 글자를 출력하려고 함
         	bw.flush();
			//출력
        } catch (IOException e) {
			System.exit(1);
        }
    }
}
