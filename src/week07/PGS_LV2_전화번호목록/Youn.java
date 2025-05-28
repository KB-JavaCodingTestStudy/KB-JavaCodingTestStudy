/**

문제 설명
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.


시간 복잡도: O(NlogN) -> 정렬

문자열을 정렬하면 인접한 문자열이 가장 유사도가 높다.
문자열이 직전이 문자열을 접두로 갖는 경우 false를 반환한다. (startsWith 함수로 접두어인지 판별한다.)
*/
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);    
        for(int i=0;i<phone_book.length-1;i++){
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }
}
