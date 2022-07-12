import java.util.*;
import java.util.stream.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        Set<Integer> seen = new HashSet<>();
        int maxSeqLength = 1;

        for (int num : numSet) {
            if (!seen.contains(num)) {
                seen.add(num);
                int left = num - 1, right = num + 1;
                int seqLength = 1;

                while (numSet.contains(left)) {
                    seqLength++;
                    seen.add(left);
                    left--;
                }
                while (numSet.contains(right)) {
                    seqLength++;
                    seen.add(right);
                    right++;
                }

                maxSeqLength = Math.max(seqLength, maxSeqLength);
            }
        }

        return maxSeqLength;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {100,4,200,1,3,2};
        System.out.println(sol.longestConsecutive(nums));
    }
}