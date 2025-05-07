import java.io.*;

public class Hong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        String A = input[0];
        String B = input[1];

        int minA = Integer.parseInt(A.replace('6', '5'));
        int minB = Integer.parseInt(B.replace('6', '5'));
        int minSum = minA + minB;

        int maxA = Integer.parseInt(A.replace('5', '6'));
        int maxB = Integer.parseInt(B.replace('5', '6'));
        int maxSum = maxA + maxB;

        System.out.println(minSum + " " + maxSum);
    }
}
