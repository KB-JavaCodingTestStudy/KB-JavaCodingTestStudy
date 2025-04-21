package week03.BOJ_S2_12891_DNA비밀번호;

// ------------------------------------------------------------------------------------
// # 💡**문제 분석 요약** 

// - **Input**
//     - 임의 DNA 문자열 길이 (|S|)
//     - 비밀번호로 사용할 문자열의 길이(|P|)
//       - 1<=|P|<=|S|<=1000000
//     - 임의로 만든 DNA 문자열
//     - 부분 문자열에 포함되어야 하는 최소 개수
//      - {A, C, G, T} 순서
// - **Output**
//     - 만들 수 있는 비밀번호의 종류의 수

// # 💡**알고리즘 설계**

// - 임의 DNA 문자열의 길이 & 비밀번호로 사용할 문자열의 길이 입력
// - 임의로 만든 문자열 입력 
// - 부분 문자열에 포함되어야 하는 최소 개수 배열에 저장
// - 0번부터 비밀번호로 사용할 문자열의 길이만큼 아래 반복
//     1. A이면 A의 최소 개수 -1
//     2. C이면 C의 최소 개수 -1
//     3. G이면 G의 최소 개수 -1
//     4. T이면 T의 최소 개수 -1
// - 배열에서 0 초과 값 없으면 result(결과값) + 1
// - 마지막(문자열)까지 반복
// - 위의 배열에서 다음 문자열에 대하여 다음 switch 실행 
//     1. A이면 A의 최소 개수 -1
//     2. C이면 C의 최소 개수 -1
//     3. G이면 G의 최소 개수 -1
//     4. T이면 T의 최소 개수 -1
// - 위의 배열에서 현재 부분 문자열 첫 번째값에 대하여 다음 switch 실행 
//     1. A이면 A의 최소 개수 +1
//     2. C이면 C의 최소 개수 +1
//     3. G이면 G의 최소 개수 +1
//     4. T이면 T의 최소 개수 +1
//     5. 배열에서 0 초과 값 없으면 result(결과값) + 1
// - 결과값 출력 
// --------------------------------------------------------------------------

import java.io.*; 
import java.util.*;

public class MJ {
    public static boolean isPW(int[] array){
        for(int a:array){ 
            if(a>0){ 
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    
        String numString = br.readLine();
        StringTokenizer st=new StringTokenizer(numString);
    
        int S=Integer.parseInt(st.nextToken());
        int P=Integer.parseInt(st.nextToken());

        int result=0; 
        
        String DNAString = br.readLine();

        numString = br.readLine();
        st=new StringTokenizer(numString);
        int[] DNA = new int[4];

        int n=0;
        while (st.hasMoreTokens()) {
            DNA[n++]=Integer.parseInt(st.nextToken());
        } 

        int start = 0;
        int last = start + P;
        
        for(int i=start;i<last;i++){
            switch (DNAString.charAt(i)) {
                case 'A':
                    DNA[0]--;
                    break;
                case 'C':
                    DNA[1]--;
                    break;
                case 'G':
                    DNA[2]--;
                    break;
                case 'T':
                    DNA[3]--;
                    break;
            }
        }          

        if(isPW(DNA)){
            result++;
        }

        for(;last<S;last++,start++){
            switch (DNAString.charAt(last)) {
                case 'A':
                    DNA[0]--;
                    break;
                case 'C':
                    DNA[1]--;
                    break;
                case 'G':
                    DNA[2]--;
                    break;
                case 'T':
                    DNA[3]--;
                    break;
            }
            switch (DNAString.charAt(start)) {
                case 'A':
                    DNA[0]++;
                    break;
                case 'C':
                    DNA[1]++;
                    break;
                case 'G':
                    DNA[2]++;
                    break;
                case 'T':
                    DNA[3]++;
                    break;
            }
            if(isPW(DNA)){
                result++;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

}
