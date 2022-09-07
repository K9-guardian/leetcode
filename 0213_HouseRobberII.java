import java.util.*;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];

        Integer[] memo = new Integer[nums.length];
        int fst = robRec(memo, nums, 0, nums.length - 1);
        Arrays.fill(memo, null);
        int snd = robRec(memo, nums, 1, nums.length);
        return Math.max(fst, snd);
    }

    public int robRec(Integer[] memo, int[] nums, int i, int end) {
        if (i >= end)
            return 0;
        else if (memo[i] != null)
            return memo[i];
        else {
            int res = Math.max(nums[i] + robRec(memo, nums, i + 2, end),
                               robRec(memo, nums, i + 1, end));
            memo[i] = res;
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 2, 3, 2 };
        System.out.println(sol.rob(nums));
    }
}
