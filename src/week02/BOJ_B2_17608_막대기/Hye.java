package week02.BOJ_B2_17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Hye {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        for (int i = 0; i < number; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        int max = stack.pop();
        int count = 1;
        for (int i = 0; i < number-1; i++) {
            int next_right = stack.pop();
            if (max < next_right) {
                max = next_right;
                count++;
            }
        }
        System.out.println(String.valueOf(count));
    }
}
