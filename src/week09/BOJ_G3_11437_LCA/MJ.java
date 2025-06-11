package week09.BOJ_G3_11437_LCA;

import java.io.*;
import java.util.*;

public class MJ {
    public static Map<Integer, List<Integer>> map = new HashMap<>();
    static int[][] tree;
    static boolean[] visited;
    public static void makeTree(int node, int depth){
        visited[node]=true;
        tree[node][1] = depth;
       if (map.containsKey(node)){
           for (int n: map.get(node)){
               if(!visited[n]){
                   tree[n][0] = node;
                   makeTree(n, depth + 1);
               }
           }
       }
    }
    public static int findSameA(int a, int b){
        while(tree[a][1] > tree[b][1]) {
            a = tree[a][0];
        }

        while(tree[b][1] > tree[a][1]) {
            b = tree[b][0];
        }

        while(a != b) {
            a = tree[a][0];
            b = tree[b][0];
        }

        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        tree = new int[n+1][2];
        visited = new boolean[n+1];

        for (int i = 1; i < n; i++) {
            int[] input =Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            List<Integer> list = map.getOrDefault(input[0], new ArrayList<>());
            list.add(input[1]);
            map.put(input[0], list);

            list = map.getOrDefault(input[1], new ArrayList<>());
            list.add(input[0]);
            map.put(input[1], list);
        }
        makeTree(1, 0);

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            int[] input =Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int result = findSameA(input[0], input[1]);
            bw.write(String.valueOf(result)+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
