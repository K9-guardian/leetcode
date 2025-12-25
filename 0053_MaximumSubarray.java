class Solution {
    public int maxSubArray(int[] nums) {
        int best_sum = nums[0];
        int current_sum = 0;

        for (int x : nums) {
            current_sum = Math.max(x, current_sum + x);
            best_sum = Math.max(best_sum, current_sum);
        }

        return best_sum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        Solution sol = new Solution();
        System.out.println(sol.maxSubArray(nums));
    }
}
