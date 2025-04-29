/**
 문제 설명
 두 개의 숫자가 주어짐, 5는 6으로, 6은 5로 착각 가능
 가능한 모든 합의 경우 中 최솟값, 최댓값 출력

 시간 복잡도
 내 생각: O(N+M)

 풀이 설명
 replaceAll 함수를 통해 6 → 5, 5 → 6으로 변경
 변경한 값은 계산한 값을 min, max에 저장 후 반환
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        String minA = a.replaceAll("6","5");
        String minB = b.replaceAll("6","5");

        String maxA = a.replaceAll("5","6");
        String maxB = b.replaceAll("5","6");

        int min = Integer.parseInt(minA)+Integer.parseInt(minB);
        int max = Integer.parseInt(maxA)+Integer.parseInt(maxB);

        System.out.println(min+" "+max);

    }
}
