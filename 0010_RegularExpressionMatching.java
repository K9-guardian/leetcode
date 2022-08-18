import java.util.regex.*;

class Solution {
    public boolean isMatch(String s, String p) {
        Pattern pat = Pattern.compile(p);
        Matcher m = pat.matcher(s);
        return m.matches();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isMatch("abdde", "ab*c*d*e"));
    }
}