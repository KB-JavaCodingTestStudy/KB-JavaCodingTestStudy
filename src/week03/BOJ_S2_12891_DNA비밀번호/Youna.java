/**

📘 문제 설명
민호는 DNA 문자열의 부분문자열을 비밀번호로 사용하고 싶어함.
비밀번호는 특정 길이를 가지며, ‘A’, ‘C’, ‘G’, ‘T’ 각각이 최소한 주어진 횟수 이상 등장해야 함.
조건을 만족하는 부분문자열의 개수를 세는 프로그램을 작성해야 함.

📌 주요 변수 설명:
n: 전체 DNA 문자열의 길이
p: 조건을 만족해야 하는 부분 문자열의 길이
arr: DNA 문자열을 문자 배열로 변환한 것
key[4]: 조건으로 주어지는 A, C, G, T 각각의 최소 개수
count: 조건을 만족하는 부분 문자열의 개


시간복잡도: O(N)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        char [] arr = br.readLine().toCharArray();

        int [] key= new int[4];
        st = new StringTokenizer(br.readLine());

       // A, C, G, T 각각에 대한 최소 개수를 배열 key에 저장
        for(int i=0;i<4;i++){
            key[i] = Integer.parseInt(st.nextToken());
        }


        int count =n-p+1; // 전체 가능하다고 가정
        int start = 0, end =p-1;
        for (int i = start; i <= end; i++){
            int idx =-1;
            switch (arr[i]){
                case 'A':idx=0; break;
                case 'C':idx=1; break;
                case 'G':idx=2; break;
                case 'T':idx=3; break;
            }
            if(idx >=0){
                key[idx]--;
            }
        }
        for(int k: key){
            if(k>0){
                count--;
                break;
            }
        }

        key[getIdx(arr[start])]++;
        start++;end++;
        while (end <n){
            key[getIdx(arr[end])]--;

            for(int k: key){
                if(k>0){
                    count--;
                    break;
                }
            }
            // 원복
            key[getIdx(arr[start])]++;
            start++; end++;
        }
        System.out.println(count);
    }
    public static int getIdx(char ch){
        switch (ch){
            case 'A':return 0;
            case 'C':return 1;
            case 'G':return 2;
            case 'T':return 3;
        }
        return -1;
    }
}

