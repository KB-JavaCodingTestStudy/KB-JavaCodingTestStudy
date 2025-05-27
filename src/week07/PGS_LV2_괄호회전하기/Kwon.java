import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        if(check(s)) {answer++;}
        
        for(int i=1; i<s.length(); i++) {
            char c = s.charAt(0);
            s = s.substring(1);
            s += c;
            if(check(s)) {answer++;}
        }
        return answer;
    }
    
    public boolean check(String s) {
        Deque<Character> st = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') {
                st.push(')');
            }
            if(s.charAt(i)=='[') {
                st.push(']');
            }
            if(s.charAt(i)=='{') {
                st.push('}');
            }
            if(s.charAt(i)==')') {
                if(st.isEmpty()) {
                    return false;
                } else {
                    char c = st.pop();
                    if(c != s.charAt(i)) {return false;}
                }   
            }
            if(s.charAt(i)=='}') {
                if(st.isEmpty()) {
                    return false;
                } else {
                    char c = st.pop();
                    if(c!=s.charAt(i)) {return false;}
                }
            }
            if(s.charAt(i)==']') {
                if(st.isEmpty()) {
                    return false;
                } else {
                    char c = st.pop();
                if(c!=s.charAt(i)) {return false;}
                }
                
            }
        }
        if(st.isEmpty()) {
            return true;
        } else {
            return false;
        }
        
    }
}
