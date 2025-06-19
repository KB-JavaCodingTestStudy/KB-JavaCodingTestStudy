import java.util.*;

class Solution {
    static boolean[] visited;
    static Set<Integer> primes;
    public int solution(String numbers) {
        int [] nums = new int[numbers.length()];
        visited = new boolean[numbers.length()];
        primes = new HashSet<>();
        
        int i=0;
        for(char ch : numbers.toCharArray()){
            nums[i++] = ch-'0';
        }
            
        makeNumber(nums, 0);
        
        return primes.size();
    }
    public static void makeNumber(int[] digit, int num){
        if(isPrime(num)){
            primes.add(num);
        }
        for(int i=0;i<digit.length;i++){
            if(!visited[i]){
                visited[i]=true;
                makeNumber(digit, num*10+digit[i]);            
                visited[i]=false;
            }
        }
    }
    public static boolean isPrime(int num){
        if(num ==0 || num ==1 )return false;
        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}
