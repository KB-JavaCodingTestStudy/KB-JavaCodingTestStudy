package week04.BOJ_S3_2606_바이러스;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MJ {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<List<Integer>> list = new ArrayList<>();

        int num = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[num+1];

        int answer = 0;

        for(int i=0;i<=num;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<line;i++){
            String str = br.readLine();
            String[] strs = str.split(" ");

            int x = Integer.parseInt(strs[0]);
            int y = Integer.parseInt(strs[1]);

            list.get(x).add(y);
            list.get(y).add(x);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        visited[1]=true;
        
        while(!deque.isEmpty()){
            int now = deque.poll();
            for(int i: list.get(now)){
                if(!visited[i]){
                    deque.add(i);
                    visited[i]=true;
                    answer++;
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
    }
}
