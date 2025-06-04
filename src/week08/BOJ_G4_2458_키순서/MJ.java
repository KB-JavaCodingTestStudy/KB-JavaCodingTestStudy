package week08.BOJ_G4_2458_키순서;

import java.io.*;
import java.util.Arrays;

public class MJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] answer = new int[nm[0]][nm[0]];

        for (int i = 0; i <nm[1] ; i++) {
            int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            answer[xy[0]-1][xy[1]-1] = 1;
            answer[xy[1]-1][xy[0]-1] = -1;
        }

        for (int k = 0; k <nm[0] ; k++) {
            for (int s = 0; s < nm[0]; s++) {
                for (int e = 0; e <nm[0] ; e++) {
                    if(answer[s][k]==1 && answer[k][e]==1){
                        answer[s][e]=1;
                    }
                    else if(answer[s][k]==-1 && answer[k][e]==-1){
                        answer[s][e]=-1;
                    }
                }
            }
        }

        for (int i = 0; i < nm[0] ; i++) {
            answer[i][i]=1;
        }

        int result=0;
        for (int i = 0; i <  nm[0]; i++) {
            boolean can = true;
            for (int j = 0; j < nm[0]; j++) {
                if(answer[i][j]==0){
                    can = false;
                    break;
                }
            }
            if(can){
                result++;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
