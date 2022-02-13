import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(', '[', '{' -> stack.push(switch (s.charAt(i)) {
                    case '(' -> ')';
                    case '[' -> ']';
                    default -> '}';
                });
                case ')', ']', '}' -> {
                    if (!stack.isEmpty() && stack.peek() == s.charAt(i))
                        stack.pop();
                    else
                        return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution sc = new Solution();
        System.out.println(sc.isValid("]"));
    }
}