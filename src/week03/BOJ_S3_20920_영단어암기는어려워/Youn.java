package 정렬;

import java.io.*;
import java.util.*;

/** 풀이
📘문제 설명
화은이는 영어 시험에서 틀린 단어들을 모아서 암기용 단어장을 만들려고 해요.
단어장을 만들 때는 다음과 같은 우선순위 기준을 따라 정렬해야 합니다.(길이가 M이상인 단어만 암기)

✅ 단어 정렬 기준 (우선순위 순서대로)
등장 빈도가 높은 단어일수록 먼저
단어 길이가 긴 단어일수록 먼저
사전 순으로 앞선 단어일수록 먼저
 
전체 코드 요약
입력으로 문자열 n개를 받고, 길이 m 이상인 문자열만 처리
중복된 문자열은 Map<String, Integer>로 카운팅
카운트, 길이, 사전순 기준으로 PriorityQueue 정렬
우선순위 큐에서 정렬된 순서대로 꺼내 출력

우선 순위 큐 -> heap 자료구조
add () : O(logN)
poll () : O(logN)
peek () : O(1)

시간 복잡도: O(n + n log n) = O(n log n)
*/

public class N_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if(str.length() >= m) {
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
        }
      
          /** 람다식 미사용
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        if(o1.getValue().equals(o2.getValue())){
                            if(o1.getKey().length() == o2.getKey().length()){
                                return o1.getKey().compareTo(o2.getKey());
                            }
                            return o2.getKey().length() - o1.getKey().length();
                        }
                        return o2.getValue() - o1.getValue();
                    }
                }
        );
         */
          PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (o1,o2) -> {
            if (Objects.equals(o1.getValue(), o2.getValue())) {
                if(o1.getKey().length() == o2.getKey().length()){
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getKey().length() - o1.getKey().length();
            }
            return o2.getValue() - o1.getValue();
        });

        pq.addAll(map.entrySet());
        while (!pq.isEmpty()) {
            sb.append(pq.poll().getKey()).append("\n");
        }
        System.out.println(sb);
    }
}

    /** My Solve
    static class Word{
        String word;
        int count;
        public Word(String word, int count){
            this.word = word;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if(s.length()>=m){
                map.put(s, map.getOrDefault(s, 0)+1);
            }
        }

        Word[] words = new Word[map.size()];
        int idx = 0;
        for(String key: map.keySet()){
            words[idx++] = new Word(key, map.get(key));
        }
        Arrays.sort(words, new Comparator<Word>() {
            @Override
            public int compare(Word o1, Word o2) {
                if(o1.count==o2.count){
                    if(o1.word.length()==o2.word.length()){
                        return o1.word.compareTo(o2.word);
                    }
                    else{
                        return o2.word.length()-o1.word.length();
                    }
                }
                return o2.count-o1.count;
            }
        });

        for(Word word: words){
            bw.write(word.word+"\n");
        }
        bw.flush();
        bw.close();
    }
     */
  

    
