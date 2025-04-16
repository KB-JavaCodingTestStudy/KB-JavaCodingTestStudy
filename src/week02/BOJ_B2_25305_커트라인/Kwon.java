import java.util.*;
import java.io.*;

public class Kwon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());  //응시자 수
        int k = Integer.parseInt(st.nextToken());  //상 받는 사람 수
        int[] score = new int[n];  //점수 배열 
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(score); //점수 정렬, 오름차순으로 정렬됨 주의
                            //내림차순으로 하려면 Integer타입으로 바꿔서 Integer로 변환 후 Collections.reverseOrder 사용
        System.out.println(score[n-k]);
    }
}
