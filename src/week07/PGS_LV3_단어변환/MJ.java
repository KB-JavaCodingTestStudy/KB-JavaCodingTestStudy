package week07.PGS_LV3_단어변환;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class MJ {
    class Solution {
        public int diff(String str1, String str2){
            int count = 0;
            for(int i=0;i<str1.length();i++){
                if(str1.charAt(i)!=str2.charAt(i)){
                    count++;
                }
            }
            return count;
        }
        public class Node{
            public String str;
            public int depth;
            Node(String str, int depth){
                this.str = str;
                this.depth = depth;
            }
        }
        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            Deque<Node> deque = new ArrayDeque<>();
            Map<String, Boolean> visited = new HashMap<>();

            deque.addLast(new Node(begin, 0));
            visited.put(begin, true);

            while(!deque.isEmpty()){
                Node cur = deque.removeFirst();
                if(cur.str.equals(target)){
                    answer = cur.depth;
                    break;
                }
                for(String word : words){
                    if(
                            diff(cur.str, word)==1
                                    && !visited.getOrDefault(word, false)
                    ){
                        deque.addLast(new Node(word, cur.depth + 1));
                        visited.put(word, true);
                    }
                }

            }
            return answer;
        }
    }
}
