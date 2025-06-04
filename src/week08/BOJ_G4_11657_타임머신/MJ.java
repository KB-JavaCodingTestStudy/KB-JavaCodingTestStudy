package week08.BOJ_G4_11657_타임머신;

import java.io.*;
import java.util.*;

public class MJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<int[]> list = new ArrayList<>();

        long[] answer = new long[input[0]+1];

        for (int i = 2; i < answer.length; i++) {
            answer[i] = Long.MAX_VALUE;
        }
        for(long i = 0; i < input[1]; i++) {
            int[] route = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            //시작, 도착, 가중치
            list.add(route);
        }

        boolean loop =false;

        for (int i = 1; i <=input[0] ; i++) {
            for(int[] l : list){
                if(answer[l[0]]!=Long.MAX_VALUE && answer[l[0]]+l[2]<answer[l[1]]){
                    answer[l[1]]=answer[l[0]]+l[2];
                    if(i==input[0]){
                        loop=true;
                    }
                }
            }
        }


        if(loop){
            bw.write("-1");
        }
        else{
            for (int i = 2; i <answer.length ; i++) {
                long a=answer[i];
                if(a==Long.MAX_VALUE){
                    bw.write("-1\n");
                }else {
                    bw.write(String.valueOf(a) + "\n");
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
