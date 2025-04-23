import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] num = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        long[] count = new long[M];
        long sum = 0;
        long result = 0;

        count[0] = 1;

        for (int i = 0; i < N; i++) {
            sum += num[i];
            int div = (int)(sum % M);

            result += count[div];
            count[div]++;
        }

        System.out.println(result);

    }
}
