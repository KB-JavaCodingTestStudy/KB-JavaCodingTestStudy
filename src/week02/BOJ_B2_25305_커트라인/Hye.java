package week02.BOJ_B2_25305_커트라인;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        String[] ns = br.readLine().split(" ");

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < ns.length; i++){
            list.add(Integer.parseInt(ns[i]));
        }

        list.sort((a, b) -> b - a);

        System.out.println(list.get(k-1));
    }
}
