import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

class Solution {
    record Pair<F, S> (F fst, S snd) { }

    sealed interface Expr permits IntExpr, VarExpr, AddExpr, MultExpr, LetExpr { }
    record IntExpr(int i) implements Expr { }
    record VarExpr(String str) implements Expr { }
    record AddExpr(Expr x, Expr y) implements Expr { }
    record MultExpr(Expr x, Expr y) implements Expr { }
    record LetExpr(List<Pair<Expr, Expr>> binds, Expr expr) implements Expr { }

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
                List<Pair<Expr, Expr>> binds = new ArrayList<>();
                Expr fst = parse(tokens);

                do {
                    Expr snd = parse(tokens);
                    binds.add(new Pair(fst, snd));
                    fst = parse(tokens);
                } while (!tokens.peek().equals(")"));

                tokens.pop();

                yield new LetExpr(binds, fst);
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

    public int evalRecur(Expr expr, Deque<Map<Expr, Integer>> stack) {
        return switch (expr) {
            case IntExpr e -> e.i();
            case VarExpr e -> stack.stream()
                                   .map(m -> m.get(e))
                                   .filter(Objects::nonNull)
                                   .findFirst()
                                   .orElseThrow();
            case AddExpr e -> evalRecur(e.x(), stack) + evalRecur(e.y(), stack);
            case MultExpr e -> evalRecur(e.x(), stack) * evalRecur(e.y(), stack);
            case LetExpr e -> {
                Map<Expr, Integer> frame = new HashMap<>();
                stack.push(frame);
                e.binds.forEach(b -> frame.put(b.fst(), evalRecur(b.snd(), stack)));
                int res = evalRecur(e.expr(), stack);
                stack.pop();
                yield res;
            }
        };
    }

    public int evaluate(String expression) {
        Deque<Map<Expr, Integer>> stack = new ArrayDeque<>();
        Expr expr = parse(tokenize(expression).collect(Collectors.toCollection(ArrayDeque::new)));
        return evalRecur(expr, stack);
    }

    public static void main(String[] args) {
        Solution sc = new Solution();
        System.out.println(sc.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
    }
}