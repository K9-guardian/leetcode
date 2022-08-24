class Solution {
    public boolean canJump(int[] nums) {
        int goalPost = nums.length - 1;

        for (int pos = nums.length - 1; pos > -1; pos--) {
            int dist = goalPost - pos;
            if (nums[pos] >= dist)
                goalPost = pos;
        }

        return goalPost == 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        Solution sol = new Solution();
        System.out.println(sol.canJump(nums));
    }
}
