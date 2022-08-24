import java.util.*;

class TextEditor {
    Deque<Character> left;
    Deque<Character> right;

    public TextEditor() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    public void addText(String text) {
        for (int i = 0; i < text.length(); i++)
            left.addLast(text.charAt(i));
    }

    public int deleteText(int k) {
        int amt = Math.min(k, left.size());
        for (int i = 0; i < amt; i++)
            left.removeLast();
        return amt;
    }

    public String cursorLeft(int k) {
        int amt = Math.min(k, left.size());
        for (int i = 0; i < amt; i++)
            right.addFirst(left.removeLast());

        return lastTenStringLeftOfCursor();
    }

    public String cursorRight(int k) {
        int amt = Math.min(k, right.size());
        for (int i = 0; i < amt; i++)
            left.addLast(right.removeFirst());

        return lastTenStringLeftOfCursor();
    }

    private String lastTenStringLeftOfCursor() {
        int amt = Math.min(10, left.size());
        StringBuilder res = new StringBuilder();

        Iterator<Character> leftItr = left.descendingIterator();
        for (int i = 0; i < amt; i++)
            res.insert(0, leftItr.next());

        return res.toString();
    }

    public static void main(String[] args) {
        TextEditor obj = new TextEditor();
        obj.addText("Hello  World!");
        obj.cursorLeft(7);
        System.out.printf("%s|%s\n", obj.cursorLeft(0), obj.cursorRight(0));
        obj.deleteText(1);
        obj.addText(",");
        System.out.printf("%s|%s\n", obj.cursorLeft(0), obj.cursorRight(0));
    }
}
