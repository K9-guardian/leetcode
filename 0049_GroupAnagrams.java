import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    Map<Character, Long> frequencies(String str) {
        return str.chars()
                  .mapToObj(Character.class::cast)
                  .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<List<String>>(
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