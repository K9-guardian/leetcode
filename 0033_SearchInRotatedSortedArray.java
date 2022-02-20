class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        else {
            int low = 0, high = nums.length - 1;

            while(low < high) {
                int mid = (low + high) / 2;
                if (target == nums[mid]) return mid;
                else {
                    if (nums[mid] > nums[nums.length - 1]) {
                        if (target < nums[mid]) {
                            if (target < nums[0])
                                low = mid + 1;
                            else
                                high = mid - 1;
                        }
                        else
                            low = mid + 1;
                    }
                    else {
                        if (target > nums[mid]) {
                            if (target > nums[nums.length - 1])
                                high = mid - 1;
                            else
                                low = mid + 1;
                        }
                        else
                            high = mid - 1;
                    }
                }
            }

            return target == nums[low] ? low : -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        Solution sc = new Solution();
        System.out.println(sc.search(nums, 0));
    }
}