import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int localMax = 1;

            for (int j = i; j < nums.length; j++)
                if (nums[i] < nums[j])
                    localMax = Math.max(localMax, 1 + dp[j]);

            dp[i] = localMax;
        }

        return Arrays.stream(dp).max().orElse(0);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(sol.lengthOfLIS(nums));
    }
}
