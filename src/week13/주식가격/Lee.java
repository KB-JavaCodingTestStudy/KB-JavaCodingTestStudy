/*
  1. 가격 (price[i])이 오름차순을 유지하는 동안 스택에 인덱스 (i)를 쌓는다.
  2. 오름차순이 깨지게 된다면 스택 맨 위에서부터 값을 하나씩 pop 한다. (새로 쌓을 인덱스보다 작아질 때 까지)
  3. 스택에서 값을 빼면서, 결과 배열 (times)에 '가격이 떨어지지 않은 기간'을 기록한다. 
  4. 인덱스를 끝까지 넣으면서 2,3을 반복한다. 
  5. 그럼에도 스택에 값이 남아있다면, 이는 끝까지 가격이 떨어지지 않은 값들이다. 이를 결과 배열에 기록한다.
*/


import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int len = prices.length;
        
        int[] times = new int[len];
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < len; i++) {
            while(!stack.isEmpty()) {
                int top_i = stack.peek();
                
                if (prices[top_i] > prices[i]) {
                    times[top_i] = i - top_i;
                    stack.pop();
                }
                else {
                    break;
                }
            }
            
            stack.push(i);
        }
        
        while(!stack.isEmpty()) {
            int i = stack.pop();
            times[i] = len - 1 - i;
        }
        
        return times;
    }
}
