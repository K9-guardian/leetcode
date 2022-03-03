import java.util.*;

class Solution {
    Map<Character, Integer> frequencies(String str) {
        Map<Character, Integer> freqs = new HashMap<>();

        for (int i = 0; i < str.length(); i++)
            freqs.merge(str.charAt(i), 1, Integer::sum);

        return freqs;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        record Pair(Map<Character, Integer> key, String value) { }

        return new ArrayList<>(
            Arrays.stream(strs)
                  .map(s -> new Pair(frequencies(s), s))
                  .collect(HashMap<Map<Character, Integer>, List<String>>::new,
                           (map, pair) -> map.merge(pair.key(),
                                                    Arrays.asList(pair.value()),
                                                    (arr, _arr) -> {
                                                        List<String> tmp = new ArrayList<>(arr);
                                                        tmp.add(pair.value());
                                                        return tmp;
                                                    }),
                           (map1, map2) -> {
                                for (var e : map2.entrySet())
                                    map1.merge(e.getKey(), e.getValue(), (arr1, arr2) -> {
                                        List<String> tmp = new ArrayList<>(arr1);
                                        tmp.addAll(arr2);
                                        return tmp;
                                    });
                           })
                  .values());
    }

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        Solution sc = new Solution();
        System.out.println(sc.groupAnagrams(strs));
    }
}