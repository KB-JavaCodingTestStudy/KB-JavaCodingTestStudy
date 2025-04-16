import java.io.*;
import java.util.*;

// --------------------------------------------------------------
// # 💡**문제 분석 요약**

// - **Input**
//     - 난쟁이의 키(9개)
// - **Output**
//     - 일곱 난쟁이의 키 (오름차순으로)
// - **문제 분석**
//     - 키의 합: 100
//     - 2명의 가짜 난쟁이 제거

// # 💡**알고리즘 설계**

// - 9명의 난쟁이의 키를 입력
//     - 입력 시 모든 난쟁이의 키 합을 구함
//     - 합에서 -100하여 초과량을 구함
// - 난쟁이 2명의 합을 brute-force로 확인
//     1.  초과량과 같으면 해당 난쟁이 2명 제거
// - 난쟁이 키 정렬
// - 출력

// # 💡시간복잡도

// - O(n^2)
// -------------------------------------------------------------------

public class MJ {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            List<Integer> heightList = new ArrayList<>();
            int totalSum = 0;

			//입력 및 추가
            for (int i = 0; i < 9; i++) {
                int tmp = Integer.parseInt(br.readLine());
                heightList.add(tmp);
                totalSum += tmp;
            }

            // 초과되는 값 
            int target = totalSum - 100;
 

            // 두 명의 인덱스 찾기(합이 초과되는 값을 가지는)
            outer:
            for (int i = 0; i < 9; i++) {
                for (int j = i + 1; j < 9; j++) {
                    if (heightList.get(i) + heightList.get(j) == target) {
						heightList.remove(j);
						heightList.remove(i);
                        break outer;
                    }
                }
            } 

            // 오름차순 정렬
            heightList.sort(null);

            // 출력
            for (int h : heightList) {
                bw.write(h + "\n");
            }

            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
