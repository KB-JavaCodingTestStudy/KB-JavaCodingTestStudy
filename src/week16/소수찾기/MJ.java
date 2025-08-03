package week16.소수찾기;

import java.util.HashSet;
import java.util.Set;

public class MJ {
    class Solution {
        //방문여부 확인하기 위한 배열
        boolean[] visited;
        //숫자 중복을 제거하기 위해 Set 생성(만들어지는 숫자 저장)
        public Set<Integer> set = new HashSet<>();
        //소수 판별을 위한 메소드
        public boolean isPrime(int n){
            //2보다 작으면 소수 아님
            if(n<2){
                return false;
            }
            //2~루트 n 값 중
            //<=에서 = 빠뜨리지 말기!!
            for(int i=2;i*i<=n;i++){
                //나누어떨어지는 것이 있으면
                if(n%i==0){
                    //소수 아님
                    return false;
                }
            }
            //위에서 나누어떨어지는 경우가 없으면 소수
            return true;
        }
        //숫자 만들기~
        public void dfs(String numbers, String cur){
            //""은 int 형으로 변경 불가능하므로 해당 경우 제거하기 위해
            if(cur.length()>0){
                //만들어진 숫자 set에 추가
                set.add(Integer.parseInt(cur));
            }

            //숫자를 돌면서~
            for(int i=0;i<numbers.length();i++){
                //방문한 적이 없으면
                if(!visited[i]){
                    //방문했어요!
                    visited[i] = true;
                    //해당 숫자 추가하고 다음으로 떠날래요!
                    dfs(numbers, cur+numbers.charAt(i));
                    //떠날게요!
                    visited[i] = false;
                }

            }
        }
        public int solution(String numbers) {
            //만들어진 수 중 소수 갯수
            int answer = 0;
            //방문 배열 초기화
            visited = new boolean[numbers.length()];
            //숫자 생성 시키도록!
            dfs(numbers, "");
            //민들어진 숫자 set을 모두 돌며
            for(int s:set){
                //소수인가?
                if(isPrime(s)){
                    //소수이면 answer 증가!
                    answer++;
                }
            }
            //정답을 반환합니다!
            return answer;
        }
    }
}
