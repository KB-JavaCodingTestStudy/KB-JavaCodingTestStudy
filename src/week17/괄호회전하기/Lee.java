import java.util.*;

class Solution {
    
    Map<Character, Character> pairs = Map.of(
        ')', '(',
        '}', '{',
        ']', '['
    );
    
    // 올바른 괄호 문자열인지 판단하는 함수
    public boolean isCorrect(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {

            // 닫는 괄호일 경우
            if (pairs.containsKey(c)) {
                // 스택이 비어있거나, top과의 짝이 맞지 않을 경우
                if (stack.isEmpty() || stack.peek() != pairs.get(c)) {
                    return false;
                }
                stack.pop();    // 짝이 맞으면 pop
            }
            // 여는 괄호일 경우
            else {
                stack.push(c);
            }
        }
        
        // 여는 괄호만 남아있는 경우 -> false
        if (!stack.isEmpty())
            return false;
        
        return true;
    }
    
    public int solution(String s) {

        int cnt = 0;
        
        // s를 회전시키면서 isCorrect에 넣어 모두 검사한다.
        for (int i = 0; i < s.length(); i++) {
            s = s.substring(1) + s.substring(0, 1); // ABCDE -> BCDEA 로 회전
            
            if (isCorrect(s))
                cnt++;
        }
        
        return cnt;
    }
}
