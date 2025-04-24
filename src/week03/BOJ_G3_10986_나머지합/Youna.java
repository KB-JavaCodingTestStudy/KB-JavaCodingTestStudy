import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
public class Main{
    public static <Set> void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] remain = new int[m];
        st = new StringTokenizer(br.readLine());
        long prev =0;
        for(int i = 0; i < n; i++) {
            int cur =Integer.parseInt(st.nextToken());
            remain[(int) ((prev + cur)%m)]++;
            prev +=cur;
        }
        long count = remain[0];
        for(int i = 0; i < m; i++) {
            count+= (long) remain[i] *(remain[i]-1) / 2;
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
    }
}
