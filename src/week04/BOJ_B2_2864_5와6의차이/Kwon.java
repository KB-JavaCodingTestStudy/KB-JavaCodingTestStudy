import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int minA;
        int maxA;
        int minB;
        int maxB;

        StringBuilder sb1 = new StringBuilder(st.nextToken());
        for(int i = 0; i < sb1.length(); i++) {
            if(sb1.charAt(i) == '6') {
                sb1.setCharAt(i,'5');
            }
        }
        minA = Integer.parseInt(sb1.toString());

        for(int i = 0; i < sb1.length(); i++) {
            if(sb1.charAt(i) == '5') {
                sb1.setCharAt(i,'6');
            }
        }
        maxA = Integer.parseInt(sb1.toString());

        StringBuilder sb2 = new StringBuilder(st.nextToken());
        for(int i = 0; i < sb2.length(); i++) {
            if(sb2.charAt(i) == '6') {
                sb2.setCharAt(i,'5');
            }
        }
        minB = Integer.parseInt(sb2.toString());

        for(int i = 0; i < sb2.length(); i++) {
            if(sb2.charAt(i) == '5') {
                sb2.setCharAt(i,'6');
            }
        }
        maxB = Integer.parseInt(sb2.toString());

        System.out.print(minA+minB);
        System.out.print(" ");
        System.out.print(maxA+maxB);
        
    }
}
