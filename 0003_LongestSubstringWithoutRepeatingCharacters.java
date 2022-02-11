import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0;
        int longestLength = 0;
        HashSet<Character> set = new HashSet<>();

        while (end != s.length()) {
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }
            else {
                set.add(s.charAt(end));
                end++;
                longestLength = Math.max(longestLength, end - start);
            }
            System.out.println(set);
        }

        return longestLength;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution sc = new Solution();
        System.out.println(sc.lengthOfLongestSubstring(s));
    }
}