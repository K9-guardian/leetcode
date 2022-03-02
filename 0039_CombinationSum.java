import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        record DFSElement(int i, int total, List<Integer> nums) { }

        List<List<Integer>> result = new ArrayList<>();
        Deque<DFSElement> stack = new ArrayDeque<>();
        stack.push(new DFSElement(0, 0, new ArrayList<>()));

        while (!stack.isEmpty()) {
            DFSElement e = stack.pop();

            if (e.total() == target) {
                result.add(new ArrayList<>(e.nums()));
                continue;
            }
            if (e.i() >= candidates.length || e.total() > target)
                continue;

            List<Integer> s1 = new ArrayList<>(e.nums()), s2 = new ArrayList<>(e.nums());
            s2.add(candidates[e.i()]);

            stack.push(new DFSElement(e.i() + 1, e.total(), s1));
            stack.push(new DFSElement(e.i(), e.total() + candidates[e.i()], s2));
        }

        return result;
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        Solution sc = new Solution();
        System.out.println(sc.combinationSum(candidates, 7));
    }
}