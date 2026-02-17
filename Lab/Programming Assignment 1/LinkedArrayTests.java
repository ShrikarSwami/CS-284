package pa1;

// Simple manual tests for LinkedArray.
public class LinkedArrayTests {
    public static void main(String[] args) {
        LinkedArray list = new LinkedArray();

        // Basic append and size checks.
        list.append("a");
        list.append("b");
        list.append("c");
        assertEquals(3, list.size(), "size after appends");
        assertEquals("a", list.get(0), "get index 0");
        assertEquals("b", list.get(1), "get index 1");
        assertEquals("c", list.get(2), "get index 2");

        // set and get
        list.set(1, "bb");
        assertEquals("bb", list.get(1), "set index 1");

        // pop
        String popped = list.pop();
        assertEquals("c", popped, "pop returns last");
        assertEquals(2, list.size(), "size after pop");

        // insert
        list.insert(1, "x");
        assertEquals(3, list.size(), "size after insert");
        assertEquals("a", list.get(0), "after insert index 0");
        assertEquals("x", list.get(1), "after insert index 1");
        assertEquals("bb", list.get(2), "after insert index 2");

        // remove
        String removed = list.remove(1);
        assertEquals("x", removed, "remove returns value");
        assertEquals(2, list.size(), "size after remove");
        assertEquals("a", list.get(0), "after remove index 0");
        assertEquals("bb", list.get(1), "after remove index 1");

        // toString
        assertEquals("[a,bb]", list.toString(), "toString output");

        System.out.println("All tests passed.");
    }

    private static void assertEquals(Object expected, Object actual, String label) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new RuntimeException("Test failed (" + label + "): expected=" + expected + ", actual=" + actual);
        }
    }
}
