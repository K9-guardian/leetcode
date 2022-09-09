import java.util.regex.*;

class Solution {
    public boolean isMatch(String s, String p) {
        return s.matches(p);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isMatch("abdde", "ab*c*d*e"));
    }
}
