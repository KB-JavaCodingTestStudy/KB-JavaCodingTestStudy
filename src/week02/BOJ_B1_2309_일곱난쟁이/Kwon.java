import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;

        for(int i=0; i<9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        outer: // label 사용
        for (int i = 0; i < 8; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum - arr[i] - arr[j] == 100) {
                    // 두 명 제외하고 리스트 만들기
                    List<Integer> result = new ArrayList<>();
                    for (int k = 0; k < 9; k++) {
                        if (k != i && k != j) {
                            result.add(arr[k]);
                        }
                    }
                    Collections.sort(result);
                    for (int height : result) {
                        System.out.println(height);
                    }
                    break outer;
                }
            }
        }
    }
}
