import java.util.*;
import java.util.stream.*;

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Long> uniq = t.chars()
            .mapToObj(x -> (char) x)
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        int fst = 0, snd = 0;
        int formed = 0, required = uniq.size();
        Map<Character, Long> window = new HashMap<>();
        int[] min = {Integer.MAX_VALUE, 0, 0}; // length, left idx, right idx

        while (snd != s.length()) {
            char c = s.charAt(snd);

            if (uniq.containsKey(c)) {
                window.merge(c, 1L, (x, y) -> x + y);

                if (window.get(c).equals(uniq.get(c)))
                    formed++;
            }

            while (fst <= snd && formed == required) {
                char k = s.charAt(fst);

                if (snd - fst + 1 < min[0]) {
                    min[0] = snd - fst + 1;
                    min[1] = fst;
                    min[2] = snd;
                }

                if (uniq.containsKey(k)) {
                    window.compute(k, (c_, y) -> y - 1);

                    if (window.get(k) < uniq.get(k))
                        formed--;
                }

                fst++;
            }

            snd++;
        }

        return min[0] == Integer.MAX_VALUE ? "" : s.substring(min[1], min[2] + 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minWindow("adobecodebanc", "abc"));
    }
}