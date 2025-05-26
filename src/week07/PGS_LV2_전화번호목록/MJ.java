package week07.PGS_LV2_전화번호목록;

import java.util.HashMap;
import java.util.Map;

public class MJ {
    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            Map<String, Boolean> phoneList = new HashMap<>();

            for(String phone: phone_book){
                phoneList.put(phone, true);
            }

            for(String phone: phone_book){
                String tmp = "";
                for(int i=0;i<phone.length()-1;i++){
                    tmp+=phone.charAt(i);
                    if(phoneList.getOrDefault(tmp, false)){
                        return false;
                    }

                }
            }

            return answer;
        }
    }
}
