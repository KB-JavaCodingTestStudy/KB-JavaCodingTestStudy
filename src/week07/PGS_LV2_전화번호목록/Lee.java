import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        
        int len = phone_book.length;
        
        for(int i = 0; i < len - 1; i++) {
            
            String prev = phone_book[i];
            String next = phone_book[i+1];
            
            if(prev.length() > next.length())
                continue;
            
            if(prev.equals(next.substring(0, prev.length())))
                return false;
        }
        
        return true;
    }
}
