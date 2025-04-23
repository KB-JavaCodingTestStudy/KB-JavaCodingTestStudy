import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
      
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
      
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if(word.length()>=m) {  //영단어의 길이가 m 이상일 경우 암기 리스트에 추가
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<String> sorted = new ArrayList<>(map.keySet());  //map의 키셋 즉 영단어를 리스트로 저장
      
        sorted.sort((a,b)-> {
            int frea = map.get(a);
            int freb = map.get(b);

            if (frea != freb) {                       //빈도수가 다르면
                return Integer.compare(freb, frea);  //내림차순
            } else {                                //빈도수가 같으면
                if (a.length() != b.length()) {   //길이순
                    return b.length() - a.length();
                } else {                        //빈도수가 같고 길이도 같다면
                    return a.compareTo(b);      //사전순
                }
            }
        });
        
        StringBuilder sb = new StringBuilder();  //출력문을 많이 쓰면 시간 초과 -> 스트링 빌더에 담아서 한번만 출력하기

        for (String word : sorted) {
            sb.append(word).append("\n");
        }
        System.out.print(sb);
    }
}
