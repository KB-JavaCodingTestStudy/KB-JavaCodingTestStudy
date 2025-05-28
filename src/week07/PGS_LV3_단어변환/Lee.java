import java.util.*;
import java.io.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        
        Queue<WordCount> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        queue.add(new WordCount(begin, 0));
        
        while(!queue.isEmpty()) {
            WordCount cur = queue.remove();
            
            if(cur.word.equals(target))
                return cur.cnt;
            
            for(int i = 0; i < words.length; i++) {
                if(!visited[i] && isChangable(cur.word, words[i])) {
                    queue.add(new WordCount(words[i], cur.cnt + 1));
                    visited[i] = true;
                    
                }
            }
        }
        
        return 0;
    }
    
    class WordCount {
        String word;
        int cnt;
        
        public WordCount(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    public boolean isChangable(String before, String after) {
        int cnt = 0;
        
        for(int i = 0; i < before.length(); i++) {
            if(before.charAt(i) != after.charAt(i))
                cnt++;
        }
        
        if (cnt == 1)
            return true;
        
        return false;
    }
    
}
