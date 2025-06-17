package week10.소수찾기;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MJ {
    class Solution {
        List<List<Integer>> checkList = new ArrayList<>();
        boolean[] visited;
        public void makeNumber(String numbers, List<Integer> list){
            checkList.add(new ArrayList<>(list));
            for(int i=0;i<numbers.length();i++){
                if(!visited[i]){
                    visited[i]=true;
                    list.add(Integer.parseInt(""+numbers.charAt(i)));
                    makeNumber(numbers, list);
                    list.remove(list.size()-1);
                    visited[i]=false;
                }
            }
        }
        public int solution(String numbers) {
            visited = new boolean[numbers.length()];
            int answer = 0;
            Set<Integer> set = new HashSet<>();
            makeNumber(numbers, new ArrayList<>());
            for(List<Integer> list:checkList){

                int size = (int)Math.pow(10, list.size()-1);
                int n=0;
                for(int i: list){
                    n+=size*i;
                    size/=10;
                }
                set.add(n);

            }
            for(int n:set){
                if(isPrinme(n)){
                    answer++;
                }
            }
            return answer;
        }
        public boolean isPrinme(int num){
            if(num<2){
                return false;
            }
            for(int i=2; i<=Math.sqrt(num);i++){
                if(num%i==0){
                    return false;
                }
            }
            return true;
        }
    }
}
