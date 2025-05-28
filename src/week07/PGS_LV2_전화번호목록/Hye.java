package week07.PGS_LV2_전화번호목록;

/* ================================================================
 *
 * Problem  : 전화번호목록_Lv2
 * Date     : 2025년 05월 28일
 * 
 * ================================================================
 */

import java.util.Arrays;

public class Hye {

    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            Arrays.sort(phone_book);

            for(int i=0; i<phone_book.length - 1; i++){

                int index = phone_book[i].length();
                int index2 = phone_book[i+1].length();

                if ( index <= index2){
                    if(phone_book[i].equals(phone_book[i+1].substring(0, index))){
                        answer = false;
                        return answer;
                    }
                }
            }

            return answer;
        }
    }
}
