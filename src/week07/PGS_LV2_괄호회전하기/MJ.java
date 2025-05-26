package week07.PGS_LV2_괄호회전하기;

import java.util.ArrayDeque;
import java.util.Deque;

public class MJ {
    class Solution {
        public boolean correct(String str){
            Deque<Character> deque = new ArrayDeque<>();
            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if(c=='[' || c=='{' || c=='('){
                    deque.addLast(c);
                }else if (c==']' || c=='}' || c==')'){
                    if(deque.isEmpty()){
                        return false;
                    }
                    char tmp = deque.removeLast();
                    if(c==']' && tmp!='['){
                        return false;
                    }else if(c=='}' && tmp!='{'){
                        return false;
                    }else if(c==')' && tmp!='('){
                        return false;
                    }
                }
            }
            if(!deque.isEmpty()){
                return false;
            }
            return true;
        }
        public int solution(String s) {
            int answer = 0;

            for(int i=0; i<s.length(); i++){
                String str = s.substring(i, s.length()) + s.substring(0, i);
                if(correct(str)){
                    answer++;
                }
            }

            return answer;
        }
    }
}
