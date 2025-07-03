
import java.util.*;
import java.io.*;

class Solution {
    
    Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        dfs("", new boolean[numbers.length()], numbers);
        
        return set.size();
    }
    
    public void dfs(String cur, boolean[] isUsed, String numbers) {
        
        if (cur.length() > 0 && isPrime(Integer.parseInt(cur))) {
            set.add(Integer.parseInt(cur));
        }
            
        
        if (cur.length() == isUsed.length)
            return;
        
        for(int i = 0; i < isUsed.length; i++) {
            
            if (isUsed[i]) continue;
            
            isUsed[i] = true;
            
            String next = cur + numbers.charAt(i);
            dfs(next, isUsed, numbers);
            
            isUsed[i] = false;
        }
        
        return;
    }
    
    boolean isPrime(int n) {
        
        if (n <= 1)
            return false;
        
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        
        return true;
    }
}
