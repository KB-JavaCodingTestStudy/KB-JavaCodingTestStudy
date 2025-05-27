import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);   //접두어는 반드시 인접해있을 것 -> 정렬
        int n = phone_book.length;
        
        for(int i=0; i<n-1; i++) {
            String a = phone_book[i];
            String b = phone_book[i+1];
            if(b.startsWith(a)) {    //접두어를 체크하는 startsWith 사용
                return false;
            }
        }
        
        return answer;
    }
}
