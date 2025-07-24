import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();  //압축이 하나도 안된 경우를 기본값으로 초기화
        
        //완전탐색
        for(int i=1; i<= s.length()/2; i++) {
            List<String> wordList = new ArrayList<>();
            
            for(int j=0; j<s.length(); j+=i) {
                int end = Math.min(j + i, s.length()); //처음에 놓친 부분!
                wordList.add(s.substring(j,end));
            }
            
            String prev = "";
            int count =1;
            StringBuilder sb = new StringBuilder();
            
            for(int j=0; j<wordList.size(); j++) {
            
                if(wordList.get(j).equals(prev)) {
                    count++;
                } else {
                    if(count != 1) {
                        sb.append(count);
                        sb.append(prev);
                    } else {
                        sb.append(prev);
                    }
                    prev = wordList.get(j);
                    count = 1;
                }
            }
            
            if(count >1) {
                sb.append(count);
            } sb.append(prev);
            
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}
