import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        int[] result = null;

        for (int i = 0; i < nums.length; i++)
            if (m.containsKey(target - nums[i]))
                result = new int[]{i, m.get(target - nums[i])};
            else
                m.put(nums[i], i);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        Solution sc = new Solution();
        System.out.println(Arrays.toString(sc.twoSum(nums, target)));
    }
}