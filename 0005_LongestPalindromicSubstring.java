class Solution {
    public String longestPalindrome(String s) {
        String palindrome = "";

        for (int i = 0; i < s.length(); i++) {
            int start = i, end = i;

            while (start > -1 && end < s.length() &&
                    s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            start++;

            if (end - start > palindrome.length())
                palindrome = s.substring(start, end);

            start = i;
            end = i + 1;

            while (start > -1 && end < s.length() &&
                    s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            start++;

            if (end - start > palindrome.length())
                palindrome = s.substring(start, end);
        }

        return palindrome;
    }

    public static void main(String[] args) {
        Solution sc = new Solution();
        System.out.println(sc.longestPalindrome("babad"));
    }
}