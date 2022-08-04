import java.util.*;
import java.util.function.*;

public class Solution {
    static abstract class ConsList<E> extends AbstractSequentialList<E> {
        public abstract <C> C match(C n, BiFunction<E, ConsList<E>, C> c);

        public static <E> ConsList<E> nil() {
            return new ConsList<>() {
                public <C> C match(C n, BiFunction<E, ConsList<E>, C> c_) {
                    return n;
                }
            };
        }

        public static <E> ConsList<E> cons(E h, ConsList<E> t) {
            return new ConsList<>() {
                public <C> C match(C n_, BiFunction<E, ConsList<E>, C> c) {
                    return c.apply(h, t);
                }
            };
        }

        @Override
        public int size() {
            return match(0, (h_, t) -> 1 + t.size());
        }

        @Override
        public ListIterator<E> listIterator(int index) {
            // Could single pass stuff but hard
            if (index < 0 || index > size()) throw new IndexOutOfBoundsException();

            return new ListIterator<>() {
                ConsList<E> front = drop(index);
                ConsList<E> back = take(index).reverse();
                int idx = index;

                record Pair<F, S> (F fst, S snd) { }

                @Override
                public E next() {
                    Optional<Pair<E, ConsList<E>>> match = front.match(
                        Optional.empty(),
                        (h, t) -> Optional.of(new Pair<>(h, t))
                    );

                    var pair = match.orElseThrow(() -> new NoSuchElementException());

                    idx++;
                    front = pair.snd();
                    back = cons(pair.fst(), back);
                    return pair.fst();
                }

                @Override
                public E previous() {
                    Optional<Pair<E, ConsList<E>>> match = back.match(
                        Optional.empty(),
                        (h, t) -> Optional.of(new Pair<>(h, t))
                    );

                    var pair = match.orElseThrow(() -> new NoSuchElementException());

                    idx--;
                    back = pair.snd();
                    front = cons(pair.fst(), front);
                    return pair.fst();
                }

                @Override
                public boolean hasNext() {
                    return !front.isEmpty();
                }

                @Override
                public boolean hasPrevious() {
                    return !back.isEmpty();
                }

                @Override
                public int nextIndex() {
                    return idx + 1;
                }

                @Override
                public int previousIndex() {
                    return idx - 1;
                }

                @Override
                public void add(E e) {
                    throw new UnsupportedOperationException();
                }

                @Override
                public void remove() {
                    throw new UnsupportedOperationException();
                }

                @Override
                public void set(E e) {
                    throw new UnsupportedOperationException();
                }
            };
        }

        private ConsList<E> take(int amt) {
            if (amt <= 0)
                return nil();
            else
                return match(nil(), (h, t) -> cons(h, t.take(amt - 1)));
        }

        private ConsList<E> drop(int amt) {
            if (amt <= 0)
                return this;
            else
                return match(nil(), (h_, t) -> t.drop(amt - 1));
        }

        private ConsList<E> reverse() {
            return reverse(nil());
        }

        private ConsList<E> reverse(ConsList<E> acc) {
            return match(acc, (h, t) -> t.reverse(cons(h, acc)));
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        record DFSElement(int i, int total, ConsList<Integer> nums) { }

        List<List<Integer>> res = new ArrayList<>();
        Deque<DFSElement> stack = new ArrayDeque<>();
        stack.push(new DFSElement(0, 0, ConsList.nil()));

        while (!stack.isEmpty()) {
            DFSElement e = stack.pop();

            if (e.total() == target) {
                res.add(e.nums());
                continue;
            }
            if (e.i() >= candidates.length || e.total() > target)
                continue;

            stack.push(new DFSElement(e.i() + 1, e.total(), e.nums()));
            stack.push(new DFSElement(e.i(), e.total() + candidates[e.i()], ConsList.cons(candidates[e.i()], e.nums())));
        }

        return res;
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        Solution sol = new Solution();
        System.out.println(sol.combinationSum(candidates, 8));
    }
}