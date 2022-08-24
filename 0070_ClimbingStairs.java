class Solution {
    public int climbStairs(int n) {
        int prev = 1, pprev = 1;

        for (int i = n; i > 1; i--) {
            int temp = pprev;
            pprev = prev + pprev;
            prev = temp;
        }

        return pprev;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.climbStairs(4));
    }
}
