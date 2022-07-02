import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Solution {
    record Pair<F, S> (F fst, S snd) { }

    sealed interface Expr permits IntExpr, VarExpr, AddExpr, MultExpr, LetExpr {
        public int eval(Deque<Map<String, Integer>> stack);
    }
    record IntExpr(int i) implements Expr {
        public int eval(Deque<Map<String, Integer>> stack) { return i; }
    }
    record VarExpr(String str) implements Expr {
        public int eval(Deque<Map<String, Integer>> stack) {
            return stack.stream()
                        .map(m -> m.get(str))
                        .filter(Objects::nonNull)
                        .findFirst()
                        .orElseThrow();
        }
    }
    record AddExpr(Expr x, Expr y) implements Expr {
        public int eval(Deque<Map<String, Integer>> stack) { return x.eval(stack) + y.eval(stack); }
    }
    record MultExpr(Expr x, Expr y) implements Expr {
        public int eval(Deque<Map<String, Integer>> stack) { return x.eval(stack) * y.eval(stack); }
    }
    record LetExpr(List<Pair<String, Expr>> binds, Expr expr) implements Expr {
        public int eval(Deque<Map<String, Integer>> stack) {
            Map<String, Integer> frame = new HashMap<>();
            stack.push(frame);
            binds.forEach(b -> frame.put(b.fst(), b.snd().eval(stack)));
            int res = expr.eval(stack);
            stack.pop();
            return res;
        }
    }

    Stream<String> tokenize(String expression) {
        Pattern p = Pattern.compile("\\(|\\)|-?\\d+|\\w[\\w\\d]*");
        Matcher m = p.matcher(expression);
        return m.results().map(match -> expression.substring(match.start(), match.end()));
    }

    Expr parseAtom(String str) {
        try { return new IntExpr(Integer.parseInt(str)); }
        catch (NumberFormatException e) { return new VarExpr(str); }
    }

    Expr parseSeq(Deque<String> tokens) {
        String fun = tokens.pop();

        return switch (fun) {
            case "add" -> {
                Expr x = parse(tokens);
                Expr y = parse(tokens);
                tokens.pop();
                yield new AddExpr(x, y);
            }
            case "mult" -> {
                Expr x = parse(tokens);
                Expr y = parse(tokens);
                tokens.pop();
                yield new MultExpr(x, y);
            }
            case "let" -> {
                List<Pair<String, Expr>> binds = new ArrayList<>();
                String fst = null, snd = null;

                do {
                    String key = tokens.pop();
                    Expr val = parse(tokens);
                    binds.add(new Pair(key, val));
                    Iterator<String> ll = tokens.iterator();
                    fst = ll.next();
                    snd = ll.next();
                } while (!fst.equals("(") && !snd.equals(")"));

                Expr expr = parse(tokens);
                tokens.pop();
                yield new LetExpr(binds, expr);
            }
            default -> throw new IllegalArgumentException("Unsupported function: " + fun);
        };
    }

    Expr parse(Deque<String> tokens) {
        String str = tokens.pop();

        return switch (str) {
            case "(" -> parseSeq(tokens);
            case ")" -> throw new IllegalArgumentException("Input has unmatched parentheses.");
            default -> parseAtom(str);
        };
    }

    public int evaluate(String expression) {
        Deque<Map<String, Integer>> stack = new ArrayDeque<>();
        Expr expr = parse(tokenize(expression).collect(Collectors.toCollection(ArrayDeque::new)));
        return expr.eval(stack);
    }

    public static void main(String[] args) {
        Solution sc = new Solution();
        System.out.println(sc.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
    }
}