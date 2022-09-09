import java.util.*;

class SmallestInfiniteSet {
    int nats;
    SortedSet<Integer> addedBack = null;

    public SmallestInfiniteSet() {
        nats = 1;
        addedBack = new TreeSet<>();
    }

    public int popSmallest() {
        if (addedBack.isEmpty())
            return nats++;
        else {
            int min = addedBack.first();
            addedBack.remove(min);
            return min;
        }
    }

    public void addBack(int num) {
        if (num < nats)
            addedBack.add(num);
    }
}
