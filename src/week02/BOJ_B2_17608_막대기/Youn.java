package week02.BOJ_B2_17608_막대기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Youn{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();
        int count= Integer.parseInt(br.readLine());
        while (count -- >0){
            int heigh = Integer.parseInt(br.readLine());
            if(stack.isEmpty() || stack.peek()>heigh){
                stack.push(heigh);
            }else{
                while (!stack.isEmpty() && stack.peek()<=heigh){
                    stack.pop();
                }
                stack.push(heigh);
            }
        }
        System.out.println(stack.size());
    }
}
