import java.util.*;
import java.io.*;
//자바 매개변수의 기본 전달 방식 => 값 복사 방식
//전달하는 값이 객체의 참조인 경우는 참조가 전달되는 것처럼 동작 => 참조 복사라고 함

class Solution {
    int answer = 0;  //int는 값복사 방식을 사용하므로 매개변수로 전달 불가 -> 클래스 변수로 선언 후 사용
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }
    
    public void dfs(int[] numbers, int idx, int a, int target) {
        if(idx ==  numbers.length) {    //numbers 배열의 마지막 수까지 계산 완료하면
            if(a == target) {           //계산 결과가 타겟넘버와 일치하는 지 확인
                answer++;
            }
            return;
        }
        dfs(numbers, idx+1, a+numbers[idx], target);  //+를 붙이는 경우
        dfs(numbers, idx+1, a-numbers[idx], target);  //-를 붙이는 경우 2방법으로 재귀 호출
    }
}
