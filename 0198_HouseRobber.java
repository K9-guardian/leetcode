class Solution {
    public int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return robRec(memo, nums, 0);
    }

    public int robRec(Integer[] memo, int[] nums, int i) {
        if (i >= nums.length)
            return 0;
        else if (memo[i] != null)
            return memo[i];
        else {
            int res = Math.max(nums[i] + robRec(memo, nums, i + 2), robRec(memo, nums, i + 1));
            memo[i] = res;
            return res;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 2, 1, 1, 2 };
        System.out.println(sol.rob(nums));
    }
}
