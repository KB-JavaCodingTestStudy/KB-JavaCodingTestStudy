// 문제
// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
// Example 2:
// nums 배열 중 두 수를 더했을 때 target이 되는 인덱스 구하기, 정답은 1개만 존재

//반복문, 재귀로 풀 수 있지만 이 문제를 재귀로 풀기에는 투머치라 반복문으로 풀었습니다.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        int n = nums.length;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(nums[i] + nums[j] == target) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
            }
        }
        return answer;
    }
}
