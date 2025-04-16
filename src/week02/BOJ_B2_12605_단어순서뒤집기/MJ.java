package week02.BOJ_B2_12605_단어순서뒤집기;
import java.io.*;
import java.util.*;

// ------------------------------------------------------------------------------------
// # 💡**문제 분석 요약**

// - **Input**
//     - 테스트 케이스 개수 (n)
//     - n개의 문장(문자열)
// - **Output**
//     - 테스트 케이스 번호 + 각 문장의 단어를 거꾸로 출력
// - **문제 분석**
//     - 공백으로 구분하고 반대로 출력

// # 💡**알고리즘 설계**

// - 테스트 케이스 개수 (n) 입력
// - 테스트 케이스 개수만큼 아래 반복
//     1.  문자열 Stack 선언 
//     2. 한 줄씩 읽기
//     3. 공백을 기준으로 문장을 나누어서 문자열 배열에 저장
//         1. 문자열 배열을 처음부터 끝까지 stack에 넣기
//     4. 테스트 케이스 번호 출력
//     5. Stack에 값이 없을 때 까지 pop()하여 끝부터 출력
//         1. 값 출력 후 공백 및 문장 끝마다 \n을 함께하여 올바르게 출력되도록 함
//  # 💡시간복잡도

//  - 테스트 케이스 마다
//     - O(n) : n = 문장 당 단어(공백으로 구분)의 개수
// --------------------------------------------------------------------------


public class MJ {
    public static void main(String[] args) {
        try {
            // 빠른 입, 출력을 위한 BufferedReader, BufferedWriter 선언
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
 
            // test case 개수 받기 
            int n= Integer.parseInt(br.readLine());

			//테스트 케이스만큼 반복
			for(int i=0; i<n; i++){
				// 문자열 Stack 선언
				Stack<String> stack=new Stack<>();
				//한 줄씩 읽기
				String str =br.readLine(); 	

				//공백으로 구분하여 배열에 저장 
				String[] strs = str.split(" ");
				
				//분리된 값 처음 부터 끝까지 
				for(String s:strs){
					// stack에 추가 
					stack.push(s); 	 
				}		

				bw.write("Case #"+ (i + 1) + ": "); 
				while(!stack.isEmpty()){
					//마지막에 추가된 값 부터 출력되도록
					bw.write(stack.pop()+" "); 
				}
				bw.write("\n"); 
			} 

			//출력 
         	bw.flush();
        } catch (IOException e) {
			System.exit(1);
        }
    }

}