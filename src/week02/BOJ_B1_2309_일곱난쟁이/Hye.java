package week02.BOJ_B1_2309_일곱난쟁이;

/* ================================================================
 *
 * Author   : 김혜지
 * Date     : 2025년 04월 16일
 *
 * ================================================================
 * 📌 문제 분석 요약
 *  - 아홉 명 중에 일곱 난쟁이 찾기
 *  -> 일곱 난쟁이의 키의 합 = 100
 *
 *  # 입력
 *  - 각 줄에 난쟁이들의 키 입력 ( 총 아홉 줄 )
 *  - 아홉 난쟁이의 키는 모두 다르며, 경우의 수가 여러 개일 경우 아무거나 출력
 *
 *  # 출력
 *  - 일곱 난쟁이의 키를 오름차순 출력
 *
 * 💻 알고리즘 설계
 * - 일곱 난쟁이의 키의 합이 100
 * -> (아홉 명의 키 총합) - (일곱 난쟁이가 아닌 2명의 키 합) = 100
 * -> 일곱 난쟁이가 아닌 두 명을 찾아내면 해결
 * = 투 포인터 사용
 *
 * ================================================================
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Hye {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        int sumH = 0;

        for(int i=0; i<9; i++){
            int h = Integer.parseInt(br.readLine());
            list.add(h);
            sumH += h;
        }
        int target = sumH - 100;

        list.sort(null);

        int left = 0;
        int right = list.size() - 1;
        while(left < right){
            int temp = list.get(left) + list.get(right);
            if(temp == target){
                break;
            }else if(temp > target){
                right--;
            }else{
                left++;
            }
        }
        list.remove(right);
        list.remove(left);

        for(int i=0; i<7; i++){
            System.out.println(list.get(i));
        }
    }
}

/* ================================================================
 * ⏰ 시간복잡도
 * - O(n log n)
 *
 * -> 정렬 - O(n log n)
 * -> 투 포인터 탐색 - O(n)
 * -> remove - O(n)
 * ================================================================
 */
