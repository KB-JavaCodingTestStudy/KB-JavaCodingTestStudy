package week03.BOJ_S3_20920_영단어암기는어려워;

/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 04월 20일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 단어를 빈도 순 -> 길이 순 -> 사전 순으로 정렬한다.
 *
 *  # 입력
 *  - 첫번째 줄 : n m    // n : 단어의 수, m : 단어의 최소 길이
 *  - 2~n+1 번째 줄 : n개의 단어 (각 줄마다 하나씩)
 *
 *  # 출력
 *  - 단어를 빈도 순 -> 길이 순 -> 사전 순으로 정렬한다.
 *
 *
 * 💻 알고리즘 설계
 * - 각 단어의 빈도수를 <String, Integer> 해시맵에 저장한다. (길이가 m 미만인 단어는 무시한다.)
 * - 단어와 빈도를 저장할 클래스를 설계하고 Comparable<> 인터페이스를 구현한다.
 * - 단어들이 빈도 순 - 길이 순 - 사전 순으로 정렬되도록 compareTo 메소드를 적당히 정의한다.
 *
 * - 커밋 한글깨짐 테스트
 * ================================================================
 */

import java.util.*;
import java.io.*;

public class Lee {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 첫번째 줄 입력
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        // 2~n+1번째 줄 입력
        for(int i = 0; i < n; i++) {
            String word = br.readLine();

            if(word.length() < m)   // 길이가 m보다 짧으면 무시
                continue;

            // word의 개수를 map에 저장
            if(map.containsKey(word))
                map.replace(word, map.get(word) + 1);
            else
                map.put(word, 1);
        }


        Word[] words = new Word[map.size()];
        int idx = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            words[idx++] = new Word(entry.getKey(), entry.getValue());
        }

        Arrays.sort(words);

        for(Word word : words) {
            bw.write(word.word + "\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }
}

class Word implements Comparable<Word> {
    String word;    // 단어
    int count;      // 단어의 수

    Word(String word, int count) {
        this.word = word;
        this.count = count;
    }

    @Override
    public int compareTo(Word other) {
        if (this.count == other.count) {
            if(this.word.length() == other.word.length()) {
                return this.word.compareTo(other.word);
            }
            return other.word.length() - this.word.length();
        }
        return other.count - this.count;
    }
}



