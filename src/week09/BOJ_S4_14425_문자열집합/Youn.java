package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class N_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        TreeSet<String> tree = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            tree.add(br.readLine());
        }
        System.out.println(tree);
        int count = 0;
        for (int i = 0; i < M; i++) {
            if(tree.contains(br.readLine())) {
                count++;
            }
        }
        System.out.println(count);

    }
}
