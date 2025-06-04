package week08.BOJ_G4_1197_최소스패닝트리;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MJ {
    public static  int[] visited;
    public static void union(int a, int b) {
       int rootA = findId(a);
       int rootB = findId(b);
       if (rootA < rootB) {
           visited[rootB] = rootA;
       }else{
           visited[rootA] = rootB;
       }
    }
    public static int findId(int a) {
        if(a==visited[a]){
            return a;
        }
        visited[a] = findId(visited[a]);
        return  visited[a];
    }

    public static boolean find(int a, int b) {
        return visited[findId(a)] == visited[findId(b)];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] ve = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new int[ve[0]+1];

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i <= ve[0]; i++) {
            visited[i] = i;
        }
        for (int i = 0; i < ve[1]; i++) {
            int[] edge = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            //정점, 정점, 가중치
            list.add(edge);
        }
        Collections.sort(list, (a,b)->a[2]-b[2]);
        int link = 0;
        int result = 0;
        for (int[] edge : list) {
            if(!find(edge[0], edge[1])){
                result+=edge[2];
                union(edge[0], edge[1]);
                link++;
            }
            if(link>=ve[0]-1){
                break;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
