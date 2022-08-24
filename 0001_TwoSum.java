import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        int[] res = null;

        for (int i = 0; i < nums.length; i++)
            if (m.containsKey(target - nums[i]))
                res = new int[]{i, m.get(target - nums[i])};
            else
                m.put(nums[i], i);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.twoSum(nums, target)));
    }
}
