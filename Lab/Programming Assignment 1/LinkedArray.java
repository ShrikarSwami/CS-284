package pa1;

/**
 * PUT YOUR INFORMATION BELOW PRIOR TO SUBMISSION
 * Name: Shrikar Swami
 * Pledge: I pledge my honor that I have abided by the Stevens Honors System.
 */

public class LinkedArray {
    public static class ArrayNode {
        public String[] array;
        public ArrayNode next;

        public ArrayNode(int size) {
            this.array = new String[size];
        }
    }

    public ArrayNode head;
    public int size;
    public ArrayNode tail;

    public LinkedArray() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }



    public String get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new RuntimeException("Index out of bounds");
        }

        ArrayNode cur = head;
        int count = 0;

        while (cur != null) {

            for (int i = 0; i < cur.array.length; i++) {

                if (count == idx) {
                    return cur.array[i];
                }

                count++;
            }

            cur = cur.next;
        }

        return null;
    }

    public void set(int idx, String value) {
        if (idx < 0 || idx >= size) {
            throw new RuntimeException("Index out of bounds");
        }

        ArrayNode cur = head;
        int count = 0;

        while (cur != null) {

            for (int i = 0; i < cur.array.length; i++) {

                if (count == idx) {
                    cur.array[i] = value;
                    return;
                }

                count++;
            }

            cur = cur.next;
        }
    }

    public void append(String value) {
        if (size == 0) {

            ArrayNode node = new ArrayNode(1);
            node.array[0] = value;

            head = node;
            tail = node;

            size++;
            return;
        }

        for (int i = 0; i < tail.array.length; i++) {

            if (tail.array[i] == null) {

                tail.array[i] = value;
                size++;
                return;
            }
        }

        ArrayNode newNode =
                new ArrayNode(tail.array.length * 2);

        newNode.array[0] = value;

        tail.next = newNode;
        tail = newNode;

        size++;
    }

    public String pop() {
        if (size == 0) {
            throw new RuntimeException("Empty list");
        }

        String removed = get(size - 1);
        set(size - 1, null);

        size--;

        // If empty now
        if (size == 0) {
            head = null;
            tail = null;
        }

        return removed;
    }

    public int size() {
        return size;
    }

    public void insert(int idx, String value) {
        if (idx < 0 || idx > size) {
            throw new RuntimeException("Index out of bounds");
        }

        append(null);

        for (int i = size - 2; i >= idx; i--) {
            set(i + 1, get(i));
        }

        set(idx, value);
    }


    public String remove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new RuntimeException("Index out of bounds");
        }

        String removed = get(idx);

        for (int i = idx; i < size - 1; i++) {
            set(i, get(i + 1));
        }

        pop();

        return removed;
    }

    public String toString() {
        String s = "[";

        for (int i = 0; i < size; i++) {

            if (i > 0) {
                s += ",";
            }

            s += get(i);
        }

        s += "]";

        return s;
    }
}
