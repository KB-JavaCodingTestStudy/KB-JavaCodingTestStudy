
/**
 * 문제 설명
 1번 컴퓨터에 바이러스가 감염된 경우,
 1번 컴퓨터로 인해 바이러스에 걸리는 컴퓨터 개수 반환

 시간 복잡도
 내 생각: O(N+K) ✨
 
 풀이
 1번부터 BFS를 순회하면서 방문 가능한 정점을 QUE에 삽입하면서 count를 증가함.
 순회가 끝나면, count를 반환
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        List<List<Integer>> list =new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }
        System.out.println(bfs(1, list));

    }

    public static int bfs(int start, List<List<Integer>> list){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[list.size()];
        queue.add(start);
        visited[start] = true;
        int count =0;
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for(int i : list.get(cur)){
                if(!visited[i]){
                    queue.add(i);  
                    count ++;
                    visited[i] = true;
                }
            }
        }

        return count;
    }
}
