import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length <= 2) return List.of();

        Arrays.sort(nums);
        Set<List<Integer>> res = new HashSet<>();

        int i = 0;
        while (i < nums.length - 2 && nums[i] <= 0) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                if (nums[start] + nums[end] == -1 * nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                } else if (nums[start] + nums[end] > -1 * nums[i])
                    end--;
                else
                    start++;
            }
            i++;
        }

        return List.copyOf(res);
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        Solution sol = new Solution();
        System.out.println(sol.threeSum(nums));
    }
}
