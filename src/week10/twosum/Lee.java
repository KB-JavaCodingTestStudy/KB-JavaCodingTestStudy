
/* ================================================================
 *
 * Author   : 이상명
 * Date     : 2025년 00월 00일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 배열에서, 합해서 target이 되는 두 원소의 인덱스를 찾아야 합니다.
 *  
 * # 입력
 *  - 배열 하나, target 
 *
 * # 반환
 *  - 합해서 target을 만들 수 있는 배열의 두 원소의 인덱스를 담은 배열  
 *
 * 💻 알고리즘 설계
 *  - 이중포문결사대
 *
 * ================================================================
 */

import java.util.*;
import java.io.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int len = nums.length;
        int[] ans = new int[2];

        for(int i = 0; i < len - 1; i++) {
            for(int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }

        return ans;
    }
}
