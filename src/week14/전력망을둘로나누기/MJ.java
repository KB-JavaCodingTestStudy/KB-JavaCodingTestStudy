package week14.전력망을둘로나누기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//visited를 먼저하고 이후에 재귀를 돌아야 방문 여부가 정상적으로 반영된다!(주의)
public class MJ {
    class Solution {
        //이어진 전깃줄 정보를 저장할 Map
        Map<Integer, List<Integer>> map = new HashMap<>();
        //방문 여부를 확인할 visited 배열(input 최대값으로 생성)
        boolean[] visited = new boolean[101];
        //input 값 총 전봇대 개수
        int total = 0;
        //답(차이가 가장 적은)을 저장할 변수(input 최대값으로 초기화)
        int min = 100;
        //자식 개수를 반환하는 메소드
        public int getchild(int n){
            //나 자신 포함이므로 1로 시작
            int count = 1;
            //전깃줄로 이어진 전봇대들에 대하여
            for(int c: map.getOrDefault(n, new ArrayList<>())){
                //방문한 적 없으면(부모?가 아니면)
                if(!visited[c]){
                    //방문 여부 업데이트
                    visited[c]=true;
                    //해당 자식의 개수들을 더함
                    count+=getchild(c);
                }
            }
            //현재 값과 저장된 값 중 차이가 적은 값으로 업데이트
            min = Math.min(min, Math.abs((total - count) -count));
            //자신의 자식 개수 반환
            return count;
        }
        
        public int solution(int n, int[][] wires) {
            //연결된 전깃줄의 정보 저장
            for(int[] wire: wires){
                map.computeIfAbsent(wire[0], k->new ArrayList<>()).add(wire[1]);
                map.computeIfAbsent(wire[1], k->new ArrayList<>()).add(wire[0]);
            }
            //총 개수로 업데이트
            total = n;

            //1 방문 여부 업데이트
            visited[1]=true;
            //1부터 확인
            getchild(1);

            //결과 반환
            return min;
        }
    }
}
