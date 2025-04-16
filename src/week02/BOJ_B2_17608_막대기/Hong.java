package week02.BOJ_B2_17608_막대기;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Hong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < N; i++) {
            int cStack = stack.pop();
            if (cStack > max) {
                cnt++;
                max = cStack;
            }
        }

        System.out.println(cnt);

    }
}
