package week01.BOJ_B1_10798_세로읽기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] arr = new char[5][15];
        for (int i=0; i<5; i++){
            String temp = br.readLine();
            for(int j=0; j < temp.length(); j++){
                arr[i][j] = temp.charAt(j);
            }

        }

        for(int i =0; i<15; i++){
            for(int j=0; j<5; j++){
                if(arr[j][i] != '\0'){
                    System.out.print(arr[j][i]);
                }

            }
        }
    }
}
