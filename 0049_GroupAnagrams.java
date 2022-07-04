import java.util.*;
import java.util.stream.*;

class Solution {
    Map<Character, Long> frequencies(String str) {
        return str.chars()
                  .mapToObj(x -> (char) x)
                  .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        return Arrays.stream(strs)
                     .collect(Collectors.groupingBy(this::frequencies))
                     .values()
                     .stream()
                     .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        Solution sol = new Solution();
        System.out.println(sol.groupAnagrams(strs));
    }
}