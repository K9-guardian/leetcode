import java.util.*;

class Solution {
    public int minMoves(int target, int maxDoubles) {
        int res = 0;

        while (target != 1 && maxDoubles > 0) {
            maxDoubles--;
            if (target % 2 == 0) {
                target /= 2;
                res++;
            } else {
                target = (target - 1) / 2;
                res += 2;
            }
        }

        return target - 1 + res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minMoves(19, 2));
    }
}
