import java.util.*;
import java.io.*;

class Solution {
    public int solution(String s) {
        
        char[] pars = s.toCharArray();
        int n = pars.length;
        int cnt = 0;
        
        for(int start = 0; start < n; start++) {
            
            Stack<Character> stack = new Stack<>();
            
            for(int i = 0; i < n; i++) {
                char par = pars[(start + i) % n];
                
                if (par == ')') {
                    if (!stack.empty() && stack.peek() == '(')
                        stack.pop();
                    else
                        stack.push(par);
                }
                else if (par == '}') {
                    if (!stack.empty() && stack.peek() == '{')
                        stack.pop();
                    else
                        stack.push(par);
                }
                else if (par == ']') {
                    if (!stack.empty() && stack.peek() == '[')
                        stack.pop();
                    else
                        stack.push(par);
                }
                else {
                    stack.push(par);
                }

            }
            
            if (stack.empty())
                cnt++;
        }
        
        return cnt;
    }
}
