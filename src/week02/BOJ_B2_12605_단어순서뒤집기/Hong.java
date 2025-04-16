package week02.BOJ_B2_12605_단어순서뒤집기;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Hong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Stack<String> stack = new Stack<>();

            while (st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }

            System.out.print("Case #" + i + ":");
            while (!stack.isEmpty()) {
                System.out.print(" " + stack.pop());
            }
            System.out.println();
        }



    }
}
