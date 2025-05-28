
import java.util.*;

class Solution {
    class Word {
        int cnt;
        String word;

        Word(int cnt, String word){
            this.cnt = cnt;
            this.word = word;
        }
    }
    
    int goodChange(String word, String target){
        int diffCnt = 0 ;
        for(int i = 0; i<word.length(); i++){
            if(word.charAt(i) != target.charAt(i)) diffCnt++;
        }
        return diffCnt;
    }
    public int solution(String begin, String target, String[] words) {
        Queue<Word> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        
        queue.add(new Word(0, begin));
        
        while(!queue.isEmpty()){
            Word cur = queue.remove();
            
            if(cur.word.equals(target)){
                return cur.cnt;
            }
            
            
            for(int i = 0; i<words.length; i++){
                 if(!visited[i] && goodChange(cur.word, words[i]) == 1){
                    visited[i] = true;
                    queue.add(new Word(cur.cnt + 1, words[i]));
                }
            }
        }
        return 0;
                
    }
}
