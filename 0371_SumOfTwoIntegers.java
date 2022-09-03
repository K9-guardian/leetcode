class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int temp = (a & b) << 1;
            a ^= b;
            b = temp;
        }

        return a;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.getSum(2, 3));
    }
}
