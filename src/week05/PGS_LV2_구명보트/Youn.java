import java.util.*;

/*
문제 설명:
한 보트에는 최대 2명까지만 탈 수 있고, 무게 제한을 넘지 않아야 합니다.
사람들의 몸무게 배열과 보트의 무게 제한이 주어집니다.
모든 사람을 구출하는 데 필요한 최소 보트 개수를 구해야 합니다.

- 시간 복잡도: O(NLogN)

- 접근
보트의 수를 최소로 하려면, 2명씩 태우는 게 이상적
하지만, 현재 가장 가벼운 사람과 무거운 사람을 비교했을 때 LIMIT을 초과한다면,
무거운 사람은 혼자서 이동
LIMIT 이내라면 두 명 태우고 출발
= 투 포인터 & 그리디
*/
public class 구명보트 {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int min = 0;
        int max = people.length - 1;

        int count = 0;
        while (min <= max) {
            if (people[min] + people[max] <= limit) {
                min++;
            }
            max--;
            count++;
        }
        return count;
    }
}
