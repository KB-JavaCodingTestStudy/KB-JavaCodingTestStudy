
import java.util.*;

class Solution {
    public int solution(String s) {
        String sb = s + s;
        int answer = 0;
        for(int i = 0; i<s.length(); i++){
            if (isValid(sb.substring(i, s.length() + i))) answer++;
        }
        return answer;
    }
    
    boolean isValid(String s){
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char cur : s.toCharArray()){
            if (cur == '(' || cur == '{' || cur == '['){
                stack.push(cur);
            } else {
                if(stack.isEmpty()) return false;
                
                char target = stack.pop();
                if((target == '(' && cur != ')') ||
                   (target == '[' && cur != ']') ||
                   (target == '{' && cur != '}')){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
