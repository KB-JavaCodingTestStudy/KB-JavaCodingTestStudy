import java.io.*;
import java.util.*;

public class Main {
    static int[] current = new int[4];  //현재 배열
    static int[] required = new int[4]; //문제에서 요구하는 충족해야하는 갯수 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken()); //입력
        int p = Integer.parseInt(st.nextToken()); //입력

        char[] str = br.readLine().toCharArray(); //문자열

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            required[i] = Integer.parseInt(st.nextToken()); //필수 개수 입력
        }

        int answer = 0;

        // 초기 윈도우
        for (int i = 0; i < p; i++) {  //인덱스 0부터 길이 p 
            if(str[i] == 'A') current[0]++; 
            if(str[i] == 'C') current[1]++;
            if(str[i] == 'G') current[2]++;
            if(str[i] == 'T') current[3]++;
        }

        if(checkDna()) {   //dna부분문자열인지 체크
            answer++;
        }

        // 슬라이딩 윈도우
        for (int j = p; j < s; j++) {  //슬라이딩 윈도우 => 한 칸씩 밀어가면서 체크
            int i = j - p;
            // 빠지는 문자
            if(str[i] == 'A') current[0]--;
            if(str[i] == 'C') current[1]--;
            if(str[i] == 'G') current[2]--;
            if(str[i] == 'T') current[3]--;

            // 새로 들어오는 문자
            if(str[j] == 'A') current[0]++;
            if(str[j] == 'C') current[1]++;
            if(str[j] == 'G') current[2]++;
            if(str[j] == 'T') current[3]++;

            if(checkDna()) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean checkDna() {
        for (int i = 0; i < 4; i++) {
            if(current[i] < required[i]) return false;
        }
        return true;
    }
    
}
