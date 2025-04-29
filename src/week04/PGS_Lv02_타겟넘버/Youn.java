import java.util.HashMap;
import java.util.Map;

/**
 문제 설명
 주어진 숫자 배열에서 각 숫자 앞에 + 또는 -를 붙여 계산해,
 주어진 타겟 숫자를 만들 수 있는 경우의 수 구하기.
 숫자는 최대 20개이므로, 완전탐색을 해도 시간 내에 해결 가능

 시간 복잡도
 내 생각 : O(2ⁿ) && O(N*T) T: 가능한 target의 범위

 */
    static int count;
    static Map<String, Integer> memo;

    public static int solution(int[] numbers, int target) {
        count =0;
        dfs(0,target,numbers);
        System.out.println(count);
        return count;
    }

    public static int advancedSolution(int [] numbers, int target) {
        memo = new HashMap<>();
        int res = advancedDfs(0,target,numbers);
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
//        solution(new int[]{1,1,1,1,1},3);
        advancedSolution(new int[]{1,1,1,1,1},3);
    }

    public static void dfs(int idx, int target, int [] numbers){
        if(idx==numbers.length){
            if(target==0){
                count++;
            }
            return;
        }
        dfs(idx+1,target+numbers[idx],numbers);
        dfs(idx+1,target-numbers[idx],numbers);
    }

    public static int advancedDfs(int idx, int target, int [] numbers){
        if(idx==numbers.length){
            return target==0?1:0;
        }
        String key = idx+","+target;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        int plus = advancedDfs(idx+1, target+numbers[idx], numbers);
        int minus = advancedDfs(idx+1, target-numbers[idx], numbers);

        memo.put(key,plus+minus);
        return plus+minus;
}
