package week01.PGS_120826_특정문자제거하기;

public class Hye {
    public static void main(String[] args) {
        Solution s = new Solution();
        String answer = s.solution("testword", "t");
        System.out.println(answer);
    }
}


class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";

        String[] temp = my_string.split("");

        for(int i = 0; i<temp.length; i++){
            if(!temp[i].equals(letter)) {
                answer += temp[i];
            }

        }
        return answer;
    }
}