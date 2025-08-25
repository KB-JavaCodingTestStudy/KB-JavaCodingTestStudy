package week17.괄호회전하기;

import java.util.ArrayDeque; 
import java.util.Deque;

public class MJ {
    class Solution {
        public boolean isPossible(String s) {
            //deque 생성
            Deque<Character> deque = new ArrayDeque<>();

            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                //여는 괄호는 deque에 추가
                if (cur == '[' || cur == '{' || cur == '(') {
                    deque.addLast(cur);
                } 
                //여는 괄호가 아닐때 deque가 비어있으면 올바르지 않은 괄호
                else if (deque.isEmpty()) {
                    return false;
                } 
                //닫는 문자열일 시 가장 마지맞 여는 괄호가 자신과 일치하는 지 확인하여 아니면 올바르지 않은 문자열
                else if (cur == ']' && deque.removeLast() != '[') {
                    return false;
                } else if (cur == '}' && deque.removeLast() != '{') {
                    return false;
                } else if (cur == ')' && deque.removeLast() != '(') {
                    return false;
                }
            }
            //비어 있으면 올바르고 비어 있지 않으면 닫히지 않은 여는 괄호가 존재하므로 불가능
            return deque.isEmpty();
        }

        public int solution(String s) {
            int answer = 0;

            for (int i = 0; i < s.length(); i++) {
                //회전된 문자열 생성
                String tmp = s.substring(i) + s.substring(0, i);
                //올바른 문자열인지 확인
                if (isPossible(tmp)) {
                    //올바르면 증가
                    answer++;
                }
            }
            return answer;
        }
    }
}
