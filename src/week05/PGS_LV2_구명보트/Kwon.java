import java.util.*;
//GPT가 알려준 문제 속 그리디 접근 방법을 떠올릴 수 있는 힌트
// 최소 , 최대 횟수/비용/개수 등의 표현 => 구명 보트 개수의 최솟값
// 정렬 가능한 정보 => 몸무게 배열 정렬 가능
// 선택을 반복하며 조건 만족 여부만 따지면 되는 경우 => LIMIT 값을 초과하지는 않는지만 체크
class Solution1 {
    public int solution1(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people); //오름차순 정렬임에 유의

        //직접 people 배열의 값을 삭제하지 않고 인덱스 이동으로 체크
        int start = 0;
        int end = people.length-1;
        
        while(start<=end) {
            if(people[start] + people[end] <= limit) { //몸무게가 가장 큰 사람이 보트를 탈 때 몸무게가 가장 작은 사람도 함께 태울 수 있다면
                start++;                               //앞쪽 인덱스 하나 증가
            }
            answer++;     //보트 수 더하기
            end--;        //맨 뒤의 사람 보트에 태웠으니 인덱스 하나 앞으로
        }
        return answer;
    }
}

//================= 처음 시도 ====================
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people); //오름차순 정렬임
        int start = 0;
        int end = people.length-1
        
        while(start<=end) {
            if(start==end) {
                answer++;
                start++;
                end--;
            } else {
                if(people[start] + people[end] <= limit) {
                    answer++;
                    start++;
                    end--;
                } else {
                    answer++;
                    end--;
                }
            }
        }
        return answer;
    }
}
