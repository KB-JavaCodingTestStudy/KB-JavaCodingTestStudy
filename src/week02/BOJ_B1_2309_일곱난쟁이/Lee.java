package week02.BOJ_B1_2309_일곱난쟁이;

import java.util.*;
import java.io.*;

public class Lee{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> list = new ArrayList<>();
        int diff = -100;

        for(int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());
            list.add(height);
            diff += height;
        }

        Collections.sort(list);

        int s = 0;
        int e = list.size() - 1;

        while(s < e) {
            if(list.get(s) + list.get(e) == diff)
                break;

            if(list.get(s) + list.get(e) > diff)
                e--;
            else
                s++;
        }

        list.remove(e);
        list.remove(s);

        for(int i = 0; i < 7; i++) {
            bw.write(String.valueOf(list.get(i)) + "\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}