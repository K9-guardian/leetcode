import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length <= 2)
            return new ArrayList<>();
        else {
            Arrays.sort(nums);
            Set<List<Integer>> result = new HashSet<>();

            int i = 0;
            while (i < nums.length - 2 && nums[i] <= 0) {
                int start = i + 1, end = nums.length - 1;
                while (start < end) {
                    if (nums[start] + nums[end] == -1 * nums[i]) {
                        result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                        start++;
                        end--;
                    } else if (nums[start] + nums[end] > -1 * nums[i])
                        end--;
                    else
                        start++;
                }
                i++;
            }

            return List.copyOf(result);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        Solution sc = new Solution();
        System.out.println(sc.threeSum(nums));
    }
}