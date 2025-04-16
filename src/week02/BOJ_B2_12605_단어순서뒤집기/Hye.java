package week02.BOJ_B2_12605_단어순서뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<String>[] stack = new Stack[n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            stack[i] = new Stack<>();

            for (int j = 0; j < s.length; j++) {
                stack[i].push(s[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Case #" + (i + 1) + ":");
            while(!stack[i].isEmpty()){
                System.out.print(" " + stack[i].pop());
            }
            System.out.println();
        }
    }
}
