class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int left = 0, right = 0;

        while (right != prices.length) {
            res = Math.max(res, prices[right] - prices[left]);
            if (left == right)
                right++;
            else if (prices[right] < prices[left])
                left++;
            else
                right++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] prices = {7,6,4,3,1};
        System.out.println(sol.maxProfit(prices));
    }
}
