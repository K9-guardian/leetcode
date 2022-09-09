import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return s.matches("(?:" + String.join("|", wordDict) + ")+");
    }

    public static void main(String[] args) {
        List<String> wordDict = List.of("apple", "pen");
        Solution sol = new Solution();
        System.out.println(sol.wordBreak("applepenapple", wordDict));
    }
}
