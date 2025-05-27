import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        HashSet<String> word = new HashSet<>();   //visited 배열 역할
        Queue<String> q = new ArrayDeque<>();
        int round = 0;
        
        q.add(begin);
        word.add(begin);
        
        while(!q.isEmpty()) {
            
            int count = q.size();
            
            for(int i=0; i<count; i++) {
                String cur = q.remove();
                if(cur.equals(target)) {
                    return round;
                }
                
                for(int j=0; j<words.length; j++) {
                    if(wordCheck(cur, words[j])==1 && !word.contains(words[j])) {
                            q.add(words[j]);
                        word.add(words[j]);   
                        
                    }
                }
            }
            round++;
        }      
        return answer;
    }
    
    public int wordCheck(String a, String b) {
        int notSame = 0;
        for(int i=0; i<a.length(); i++) {
            if(a.charAt(i)!=b.charAt(i)) {
                notSame++;
            }
        }
        return notSame;
    }
}
