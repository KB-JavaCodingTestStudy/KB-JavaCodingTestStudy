package week02.BOJ_B1_2309_일곱난쟁이;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();
        int sum = 0;

        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(br.readLine());
            list.add(n);
            sum += n;
        }

        int fake = sum - 100;
        int a = 0, b = 0;

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) + list.get(j) == fake) {
                    a = list.get(i);
                    b = list.get(j);
                    break;
                }
            }
        }

        list.remove(Integer.valueOf(a));
        list.remove(Integer.valueOf(b));

        Collections.sort(list);

        for (int h : list) {
            System.out.println(h);
        }

    }
}
