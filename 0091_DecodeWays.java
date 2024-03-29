class Solution {
    int[] memo = null;

    public int numDecodings(String s) {
        memo = new int[s.length() + 1];
        return s.isEmpty() ? 0 : numDecodingsRec(s, 0);
    }

    int numDecodingsRec(String s, int i) {
        if (i == s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (memo[i] != 0) return memo[i];

        int res = numDecodingsRec(s, i + 1);
        if (i < s.length() - 1
            && (s.charAt(i) == '1'
                || s.charAt(i) == '2'
                && s.charAt(i + 1) <= '6')) {
            res += numDecodingsRec(s, i + 2);
        }

        memo[i] = res;
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numDecodings("226"));
    }
}
