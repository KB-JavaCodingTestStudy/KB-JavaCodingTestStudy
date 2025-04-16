import java.util.*;
import java.io.*;

public class Kwon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  //테스트 케이스 입력
        
        for(int i=0; i<n; i++) {           //테스트 케이스만큼 반복
            String s = br.readLine();      //한 라인 입력
            String[] word= s.split(" ");   //하나의 스페이스로 구분되는 각 단어 분리 
            
            System.out.print("Case #"+(i+1)+": ");
            for(int j=word.length-1; j>=0; j--) {  //단어 목록의 뒤에서부터 출력(stack.pop()같은 작업)
                System.out.print(word[j]+" ");
            }
            System.out.println();
        }
    }
}
