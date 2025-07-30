package week15.네트워크;

import java.util.*;

public class MJ {
    class Solution {
        //방문여부 배열(입력 최대값으로 설정)
        public boolean[] visited = new boolean[201];
        //연결 정보 저장할 map
        public Map<Integer, List<Integer>> map = new HashMap<>();
        public int solution(int n, int[][] computers) {
            int answer = 0;
            //연결된 값들 업데이트
            for(int i=0; i<n;i++){
                for(int j=i; j<n;j++){
                    //연결된 경우
                    if(computers[i][j]==1){
                        //연결 map에 추가
                        map.computeIfAbsent(i, k->new ArrayList<>()).add(j);
                        map.computeIfAbsent(j, k->new ArrayList<>()).add(i);
                    }
                }
            }

            //처음 값부터
            for(int i=0; i<n;i++){
                //방문한 적이 없으면
                if(!visited[i]){
                    //이제 방문했어요!
                    visited[i]=true;
                    //이전까지 연결되어 온 적이 없으므로 네트워크 개수 증가
                    answer++;

                    // 남은 값 저장할 deque
                    Deque<Integer> deque = new ArrayDeque<>();
                    //초기값 넣기
                    deque.add(i);

                    //비어있지 않으면 돌아갑니다~
                    while(!deque.isEmpty()){
                        //하나 꺼내서
                        int cur = deque.remove();

                        //연결된 모든 컴퓨터를 확인
                        for(int v: map.getOrDefault(cur, new ArrayList<>())){
                            //이미 방문한적 있으면
                            if(visited[v]){
                                //PASS~~
                                continue;
                            }
                            //아니면
                            //방문했어요!
                            visited[v]=true;
                            //이따 해당 컴퓨터 연결된 것도 돌아야 하니까 값 넣어두기
                            deque.add(v);
                        }
                    }
                }
            }
            //값 반환!
            return answer;
        }
    }
}
