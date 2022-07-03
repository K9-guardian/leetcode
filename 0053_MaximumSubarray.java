class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum < 0)
                sum = 0;
            sum += nums[i];
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Solution sol = new Solution();
        System.out.println(sol.maxSubArray(nums));
    }
}