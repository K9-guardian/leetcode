import java.util.*;
import java.util.regex.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Pattern p = Pattern.compile("(?:" + String.join("|", wordDict) + ")+");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    public static void main(String[] args) {
        List<String> wordDict = List.of("apple", "pen");
        Solution sol = new Solution();
        System.out.println(sol.wordBreak("applepenapple", wordDict));
    }
}