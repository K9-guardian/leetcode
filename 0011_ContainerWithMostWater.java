class Solution {
    public int maxArea(int[] height) {
        int start = 0, end = height.length - 1;
        int area = 0;

        while (start != end) {
            int min = Math.min(height[start], height[end]);
            area = Math.max(area, (end - start) * min);

            if (min == height[start])
                start++;
            else
                end--;
        }

        return area;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        Solution sol = new Solution();
        System.out.println(sol.maxArea(height));
    }
}