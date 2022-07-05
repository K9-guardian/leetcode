class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int sum = 0;

        for (int num : nums) {
            if (sum < 0)
                sum = 0;
            sum += num;
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