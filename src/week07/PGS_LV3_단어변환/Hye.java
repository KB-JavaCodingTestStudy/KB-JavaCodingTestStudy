package week07.PGS_LV3_단어변환;

/* ================================================================
 *
 * Problem  : 단어변환_Lv3
 * Date     : 2025년 05월 28일
 * 
 * ================================================================
 */

import java.util.ArrayDeque;
import java.util.Queue;

public class Hye {
    class Solution {
        class Node {
            String word;
            int dist;

            Node(String word, int dist){
                this.word = word;
                this.dist = dist;
            }
        }
        public int solution(String begin, String target, String[] words) {
            int answer = 0;

            int len = words.length;

            Queue<Node> que = new ArrayDeque<>();
            boolean[] visited = new boolean[len];

            Node node = new Node(begin, 0);
            que.offer(node);

            while(!que.isEmpty()){
                Node curNode = que.poll();
                String cw = curNode.word;
                int dist = curNode.dist;

                if(cw.equals(target)){
                    return dist;
                }
                for(int i = 0;  i < len; i ++){
                    String nw = words[i];
                    if(!visited[i] && calc(cw, nw) == 1){
                        que.offer(new Node(nw, dist + 1));
                        visited[i] = true;
                    }
                }
            }
            return 0;
        }

        private int calc(String a, String b){
            int len = a.length();
            int count = 0;

            for(int i=0; i < len; i ++){
                if(a.charAt(i) != b.charAt(i)){
                    count++;
                }
            }
            return count;
        }
    }

}
