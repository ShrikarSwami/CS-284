package pa1;

/**
 * PUT YOUR INFORMATION BELOW PRIOR TO SUBMISSION
 * Name: Shrikar Swami
 * Pledge: I pledge my honor that I have abided by the Stevens Honors System.
 */


//This initialized the class and the inner class ArrayNode which is what I used to create the linked list of arrays.
public class LinkedArray {
    public static class ArrayNode {
        public String[] array;
        public ArrayNode next;

        public ArrayNode(int size) {
            this.array = new String[size];
        }
    }

    // This section initialized the head, tail, and size of the linked list of arrays.
    public ArrayNode head;
    public int size;
    public ArrayNode tail;

    // This is a constructor for the LinkedArray class that initializes the head, tail, and size of the linked list of arrays.
    public LinkedArray() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    //This method is used to get a value at a specific index in the linked list of arrays. 
    public String get(int idx) {
        // Check if index is out of bounds
        if (idx < 0 || idx >= size) {
            throw new RuntimeException("Index out of bounds");
        }

        // Gos through the linked list of arrays to find the value at the specified index
        ArrayNode cur = head;
        int count = 0;

        // Loop through the linked list of arrays until we find the index we are looking for
        while (cur != null) {

            // Loop through the current array in the linked list of arrays
            for (int i = 0; i < cur.array.length; i++) {

                if (count == idx) {
                    return cur.array[i];
                }

                count++;
            }

            // Move to the next node in the linked list of arrays
            cur = cur.next;
        }

        // Hopefully this line is never reached because it we should've already found the index we are looking for.
        return null;
    }

    // This method is used to set a value at a specific index in the array.
    public void set(int idx, String value) {
        // Check if index is out of bounds
        if (idx < 0 || idx >= size) {
            throw new RuntimeException("Index out of bounds");
        }

        // Gos through the linked list of arrays to find the value at the specified index
        ArrayNode cur = head;
        int count = 0;


        // Loops through the linked list of arrays until we find the index we are looking for and then it sets the value at that index to the value that was passed in as a parameter.
        while (cur != null) {

            // Loop through the current array in the linked list of arrays
            for (int i = 0; i < cur.array.length; i++) {

                if (count == idx) {
                    cur.array[i] = value;
                    return;
                }

                count++;
            }

            // Move to the next node in the linked list of arrays
            cur = cur.next;
        }
    }

    // This method is used to append a value to the end of the linked list of arrays. 
    public void append(String value) {
        // If the linked list of arrays is empty, 
        if (size == 0) {

            // Create a new node with an array of size 1 and set the first element of the array to the value that was passed in as a parameter. 
            ArrayNode node = new ArrayNode(1);
            node.array[0] = value;

            // Set the head and tail of the linked list of arrays to the new node and increment the size of the linked list of arrays by 1.
            head = node;
            tail = node;

            // Increment the size of the linked list of arrays by 1 and return.
            size++;
            return;
        }

        // If the linked list of arrays is not empty, loop through the tail node's array to find the first null element and set it to the value that was passed in as a parameter. 
        for (int i = 0; i < tail.array.length; i++) {

            // If we find a null element in the tail node's array, set it to the value that was passed in as a parameter, increment the size of the linked list of arrays by 1, and return.
            if (tail.array[i] == null) {

                tail.array[i] = value;
                size++;
                return;
            }
        }

        // If we don't find a null element in the tail node's array, create a new node with an array that is double the size of the tail node's array and set the first element of the new node's array to the value that was passed in as a parameter. Then, set the next pointer of the tail node to the new node, update the tail pointer to the new node, and increment the size of the linked list of arrays by 1.
        ArrayNode newNode =
                new ArrayNode(tail.array.length * 2);

        newNode.array[0] = value;

        tail.next = newNode;
        tail = newNode;

        size++;
    }

    // This method is used to remove the last value from the linked list of arrays and return it.
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
            return removed;
        }

        // If the tail node became empty, remove it.
        if (tail != null && tail.array[0] == null && head != tail) {
            ArrayNode prev = head;
            while (prev.next != null && prev.next != tail) {
                prev = prev.next;
            }
            prev.next = null;
            tail = prev;
        }

        return removed;
    }

    // This method is used to return the size of the linked list of arrays.
    public int size() {
        int count = 0;
        ArrayNode cur = head;

        while (cur != null) {
            for (int i = 0; i < cur.array.length; i++) {
                if (cur.array[i] == null) {
                    // Return here to end the method early once the first unused slot is found.
                    return count;
                }
                count++;
            }
            cur = cur.next;
        }

        return count;
    }

    // This method is used to insert a value at a specific index in the linked list of arrays.
    public void insert(int idx, String value) {
        // Check if index is out of bounds
        if (idx < 0 || idx > size) {
            throw new RuntimeException("Index out of bounds");
        }

        // If we are inserting at the end of the linked list of arrays, just append the value to the end and then return it.
        append(null);

        for (int i = size - 2; i >= idx; i--) {
            set(i + 1, get(i));
        }

        set(idx, value);
    }

    // This method is used to remove a value at a specific index in the linked list of arrays and return it.
    public String remove(int idx) {
        // Check if index is out of bounds
        if (idx < 0 || idx >= size) {
            throw new RuntimeException("Index out of bounds");
        }

        // Get the value at the specified index and store it in a variable called removed.
        String removed = get(idx);

        // Loop through the linked list of arrays starting from the index that we want to remove and shift all the values to the left by one. 
        for (int i = idx; i < size - 1; i++) {
            set(i, get(i + 1));
        }

        // After shifting the values to the left, we need to remove the last value in the linked list of arrays because it is now a duplicate of the second to last value. 
        pop();

        return removed;
    }

    // This method is used to return a string representation of the linked list of arrays.
    public String toString() {
        String s = "[";

        // Loop through the linked list of arrays and append each value to the string representation of the linked list of arrays.
        for (int i = 0; i < size; i++) {

            // If we are not at the first value, append a comma to the string representation of the linked list of arrays before appending the value at the current index.
            if (i > 0) {
                s += ",";
            }

            // Append the value at the current index to the string representation of the linked list of arrays.
            s += get(i);
        }

        // After looping through the linked list of arrays, append a closing bracket to the string representation of the linked list of arrays and return it.
        s += "]";

        return s;
    }
}
