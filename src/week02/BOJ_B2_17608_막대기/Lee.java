package week02.BOJ_B2_17608_막대기;

import java.util.*;
import java.io.*;

public class Lee {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> inputStack = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            inputStack.push(Integer.parseInt(br.readLine()));
        }

        while(!inputStack.isEmpty()) {
            int bar = inputStack.pop();

            if(resultStack.isEmpty() || resultStack.peek() < bar)
                resultStack.push(bar);
        }

        int cnt = 0;
        while(!resultStack.isEmpty()) {
            resultStack.pop();
            cnt++;
        }

        bw.write(String.valueOf(cnt));

        bw.flush();

        bw.close();
        br.close();
    }

}