import java.util.*;
import java.util.stream.*;

class Solution {
    List<Integer> frequencies(String str) {
        int[] freqs = new int[26];

        str.chars().map(x -> x - 97).forEach(x -> freqs[x]++);

        return Arrays.stream(freqs).boxed().toList();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        return Arrays.stream(strs)
                     .collect(Collectors.groupingBy(this::frequencies))
                     .values()
                     .stream()
                     .toList();
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        Solution sol = new Solution();
        System.out.println(sol.groupAnagrams(strs));
    }
}
