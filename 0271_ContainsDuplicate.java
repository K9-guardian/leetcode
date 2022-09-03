import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums)
            if (set.contains(n))
                return true;
            else
                set.add(n);

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(sol.containsDuplicate(nums));
    }
}
