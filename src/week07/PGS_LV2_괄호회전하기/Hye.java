package week07.PGS_LV2_괄호회전하기;

/* ================================================================
 *
 * Problem  : 괄호 회전하기_Lv2
 * Date     : 2025년 05월 28일
 *
 * ================================================================
 */

import java.util.*;

public class Hye {
    class Solution {
        public int solution(String s) {
            int answer = 0;

            outer:
            for(int i = 0; i < s.length(); i ++){
                Deque<Character> stack = new ArrayDeque<>();
                String temp = s.substring(i) + s.substring(0,i);
                char[] cs = temp.toCharArray();

                for(char c : cs){
                    if(c == '[' || c == '{' || c == '('){
                        stack.push(c);
                    }else{
                        if(stack.isEmpty()){
                            continue outer;
                        }
                        char n = stack.pop();
                        if((n == '[' && c!= ']') || (n == '{' && c!='}') || ( n=='(' && c !=')')){
                            continue outer;
                        }
                    }

                }
                if(stack.isEmpty()){
                    answer++;
                }
            }
            return answer;
        }
    }
}
