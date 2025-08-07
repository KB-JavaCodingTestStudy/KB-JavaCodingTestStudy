import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> set = new HashSet<>();
        makeNumbers("", numbers, set);

        int count = 0;
        for (int num : set) {
            if (isPrime(num)) count++;
        }

        return count;
    }

    // 숫자 조합 만들기 (모든 순열)
    void makeNumbers(String current, String remaining, Set<Integer> set) {
        if (!current.isEmpty()) {
            set.add(Integer.parseInt(current));
        }

        for (int i = 0; i < remaining.length(); i++) {
            // i번째 문자 제외하고 나머지로 재귀 호출
            makeNumbers(
                current + remaining.charAt(i), // current에 새로운 숫자 한 글자를 덧붙이는 것
                remaining.substring(0, i) + remaining.substring(i + 1), // i번째 문자를 제외한 나머지 문자들로 새 문자열 만들기
                set
            );
        }
    }

    // 소수 판별 함수 (2 이상, √n까지 나눠서 확인)
    boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
