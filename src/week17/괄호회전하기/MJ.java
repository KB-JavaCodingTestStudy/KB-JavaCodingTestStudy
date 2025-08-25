package week17.괄호회전하기;

import java.util.ArrayDeque;
import java.util.Deque;

public class MJ {
    class Solution {
        public boolean isPossible(String s) {
            Deque<Character> deque = new ArrayDeque<>();

            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                if (cur == '[' || cur == '{' || cur == '(') {
                    deque.addLast(cur);
                } else if (deque.isEmpty()) {
                    return false;
                } else if (cur == ']' && deque.removeLast() != '[') {
                    return false;
                } else if (cur == '}' && deque.removeLast() != '{') {
                    return false;
                } else if (cur == ')' && deque.removeLast() != '(') {
                    return false;
                }
            }
            return deque.isEmpty();
        }

        public int solution(String s) {
            int answer = 0;

            for (int i = 0; i < s.length(); i++) {
                String tmp = s.substring(i) + s.substring(0, i);
                if (isPossible(tmp)) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
