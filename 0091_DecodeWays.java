import java.util.*;

class Solution {
    public int numDecodings(String s) {
        return numDecodingsRec(s);
    }

    int numDecodingsRec(String s) {
        if (s.length() == 0) return 1;


    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numDecodings("226"));
    }
}