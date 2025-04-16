import java.util.*;
import java.io.*;

public class Kwon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        for(int i=0; i<n; i++) {
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
        }
        
        int idx = arr[n-1];
        int answer = 1;
        for(int i=n-2; i>=0; i--) {
            if(arr[i]>idx) {
                answer ++;
                idx = arr[i];
            }
        }
        System.out.println(answer);
    }
}
        
