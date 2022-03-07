import java.util.*;
import java.util.stream.Collectors;

class Solution {
    Map<Character, Integer> frequencies(String str) {
        Map<Character, Integer> freqs = new HashMap<>();

        for (int i = 0; i < str.length(); i++)
            freqs.merge(str.charAt(i), 1, Integer::sum);

        return freqs;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(
            Arrays.stream(strs)
                  .collect(Collectors.groupingBy(this::frequencies))
                  .values());
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        Solution sc = new Solution();
        System.out.println(sc.groupAnagrams(strs));
    }
}