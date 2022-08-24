import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Solution {
    public int countBinarySubstrings(String s) {
        Pattern p = Pattern.compile("0+|1+");
        Matcher m = p.matcher(s);
        List<Integer> counts = m.results()
                                .map(match -> match.end() - match.start())
                                .collect(Collectors.toCollection(ArrayList::new));

        int sum = 0;

        for (int i = 1; i < counts.size(); i++)
            sum += Math.min(counts.get(i - 1), counts.get(i));

        return sum;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countBinarySubstrings("00110011"));
    }
}
