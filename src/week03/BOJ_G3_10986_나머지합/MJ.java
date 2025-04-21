package week03.BOJ_G3_10986_나머지합;

import java.io.*;
import java.util.*; 

public class MJ {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        String numString = br.readLine();
        StringTokenizer st = new StringTokenizer(numString);
        
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        String AString = br.readLine();
        st = new StringTokenizer(AString);

        int[] sums = new int[M];

        int sum=0;
        while(st.hasMoreTokens()){
            sum+= Integer.parseInt(st.nextToken());
            sums[sum % M]++;
        }

        long result=sums[0];
        for(int i=0;i<M;i++){
            int tmp=sums[i];
            result+=tmp*(tmp-1)/2;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }
}
