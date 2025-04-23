import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) {
                continue;
            }

            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }

        List<String> words = new ArrayList<>(map.keySet());

        Collections.sort(words, (a, b) -> {
            // 등장 횟수
            int countCompare = map.get(b) - map.get(a);
            if (countCompare != 0) {
                return countCompare;
            }
            // 길이가 길수록
            int lengthCompare = b.length() - a.length();
            if (lengthCompare != 0) {
                return lengthCompare;
            }
            // 사전 순
            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("\n");
        }
        System.out.print(sb);


    }
}
