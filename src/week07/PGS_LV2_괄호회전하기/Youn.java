/**
- 입력 문자열이 홀수면 절대 올바른 괄호가 될 수 없으므로 바로 `0` 리턴
- 각 회전마다 문자열을 검사하여 유효하면 `count++`
- 최종적으로 유효한 회전의 개수를 반환

시간 복잡도:  O(N^2)
*/

import java.util.*;
class Solution {
    public int solution(String s) {
        if(s.length()%2!=0) return 0;
        StringBuilder sb =new StringBuilder(s);
        int count =0;        
        for(int i=0;i<s.length();i++){
           String ch = sb.substring(0, 1); 
            sb.delete(0, 1);              
            sb.append(ch);   
            if(isOk(sb.toString())){
                count++;
            }
        }
        return count;
    }
    static boolean isOk(String str){
        ArrayDeque<Character> stack = new ArrayDeque<>(); 
        int idx =0;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            
            if(ch == '(' || ch=='{' || ch=='['){
                stack.offer(ch);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }
                if(!isMatched(stack.pollLast(), ch)){
                    return false;
                }                
            }
        }
        
        return stack.isEmpty();
    }
    static boolean isMatched(char open, char close){
        return 
            (open == '(' && close == ')') ||
            (open == '{' && close == '}') ||
            (open == '[' && close == ']');
    }
}
