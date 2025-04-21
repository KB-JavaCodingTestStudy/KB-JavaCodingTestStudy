package week03.BOJ_G3_10986_나머지합;

// ------------------------------------------------------------------------------------
// # 💡**문제 분석 요약**

// - **Input**
//     - 영어 지문에 나오는 단어의 개수(N)
//       - 1<=N<=100000
//     - 단어 길이의 기준(M)
//       - 1<=M<=10
//     - N개의 단어
// - **Output**
//     - M보다 긴 단어 중
//     - 우선 순위(앞에 나오도록): 
//      - 단어 빈도(많을수록)
//      - 단어 길이(길수록)
//      - 사전순(앞 단어일 수록)
//     - 우선 순위에 따라 단어장 목록 출력력

// # 💡**알고리즘 설계**

// - 단어 수 및 기준 길이 입력
// - 단어 수만큼 아래를 반복 
//     1. 단어(문자열) 입력  
//     2. 기준 길이보다 문자가 짧으면 continue -> 조건문으로 돌아감 = 단어 저장X
//     3. map에 입력한 단어 입력
//      - 이미 map에 있으면 해당 value+1
//      - 없으면 1
// - map의 keySet의 단어들을 List에 입력
// - 해당 단어들을 우선순위에 따라 정렬
// - 정렬된 단어들을 출력
// --------------------------------------------------------------------------

import java.io.*;
import java.util.*;

public class MJ{
    public static class Word{
        public String word;
        public int num;

        public Word(String word, int num){
            this.word=word;
            this.num=num;
        }
    
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new HashMap<>();

        String nums = br.readLine();
        StringTokenizer sb=new StringTokenizer(nums);
        int N = Integer.parseInt(sb.nextToken());
        int M = Integer.parseInt(sb.nextToken());

        for(int i=0;i<N;i++){
            String str = br.readLine();
            //기준 단어 길이 안되면 조건으로
            if(str.length()<M){
                continue;
            }
            // 이미 있으면 +1
            if(map.containsKey(str)){
                map.put(str, map.get(str) + 1);
            }
            // 없으면 1
            else{
                map.put(str, 1);
            }
        }

        List<Word> dictionary=new ArrayList<>();

        //입력된 단어들 리스트에 등록록
        for(String m:map.keySet()){
            dictionary.add(new Word(m, map.get(m)));
        } 
        
        //정렬
        dictionary.sort(Comparator
        .comparingInt((Word w) -> -w.num)
        .thenComparingInt((Word w) -> -w.word.length())
        .thenComparing(w -> w.word));

        //출력
        for (Word w : dictionary) {
            bw.write(w.word + "\n");
        }
        
        bw.flush();
    }
    

}
