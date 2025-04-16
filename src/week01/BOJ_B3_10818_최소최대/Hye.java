package week01.BOJ_B3_10818_최소최대;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        String[] tokens = br.readLine().split(" ");

        ArrayList<Integer> intArr = new ArrayList<>();
        for(int i = 0; i < num; i++){
            intArr.add(Integer.parseInt(tokens[i]));
        }

        intArr.sort(null);

        System.out.println(intArr.get(0) + " " + intArr.get(num-1));
    }
}
