import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        String A = input[0];
        String B = input[1];

        // 최소값: 6을 5로
        int minA = Integer.parseInt(A.replace('6', '5'));
        int minB = Integer.parseInt(B.replace('6', '5'));

        // 최대값: 5를 6으로
        int maxA = Integer.parseInt(A.replace('5', '6'));
        int maxB = Integer.parseInt(B.replace('5', '6'));

        System.out.println((minA + minB) + " " + (maxA + maxB));
    }
}
