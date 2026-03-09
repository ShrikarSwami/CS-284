package pa2;

import java.util.*;

public class TriangularList<E> {
    public List<List<E>> metaList;
    public int size;

    // This is an empty constructor for the TriangularList class
    public TriangularList() {
        metaList = new ArrayList<>();
        size = 0;
    }

    // This constructor initializes the get function
    public E get(int idx) {
        // Check if the index is out of bounds
        if (idx < 0 || idx >= size)
            throw new IndexOutOfBoundsException("Index Out of Bounds");
        // Find the row and column corresponding to the linear index
        int row = 0;
        // Then it subtracts the size of the current row from the index until it finds the correct row
        while (idx >= metaList.get(row).size()){
            idx -= metaList.get(row).size();
            row++;
        }

        // Finally, it returns the element at the calculated row and column
        return metaList.get(row).get(idx);
    }

    // This method sets the value at the specified index in the TriangularList
    public void set(int idx, E value) {
        // Check if the index is out of bounds
        if (idx < 0 || idx >= size){
            throw new IndexOutOfBoundsException("Index Out of Bounds");
        }
        // Similar to the get method, it calculates the row and column corresponding to the linear index
        int row = 0;
        // It subtracts the size of the current row from the index until it finds the correct row
        while (idx >= metaList.get(row).size()){
            idx -= metaList.get(row).size();
            row++;
        }
        // Finally, it sets the value at the calculated row and column
        metaList.get(row).set(idx, value);
    }

    // This method inserts a value at the specified index in the TriangularList
    public void insert(int idx, E value) {
        // Insert supports appending at idx == size.
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException("Index Out of Bounds");
        }

        // To insert, we flatten the structure into a single list, perform the insertion, and then rebuild the triangular structure.
        // I decided to flatten it because it was easier to draw out and visualize the insert operation on a single list rather than trying to directly manipulate the triangular structure.
        List<E> flat = flatten();
        flat.add(idx, value);
        rebuildFromFlat(flat);
    }

    // This method removes the element at the specified index in the TriangularList
    public void remove(int idx) {
        // Check if the index is out of bounds
        if (idx < 0 || idx >= size) {
            throw new IndexOutOfBoundsException("Index Out of Bounds");
        }

        // Similar to the insert method, we flatten the structure into a single list, perform the removal, and then rebuild the triangular structure.
        List<E> flat = flatten();
        flat.remove(idx);
        rebuildFromFlat(flat);
    }

    // This method returns a string representation of the TriangularList
    public String toString() {
        return metaList.toString();
    }

    // This method returns the number of elements in the TriangularList
    public int size() {
        return size;
    }

    // Returns elements in logical (linear index) order.
    // I know this isn't part of the assignment and is like an extra thing but I really found it useful
    private List<E> flatten() {
        List<E> flat = new ArrayList<>(size);
        for (List<E> row : metaList) {
            flat.addAll(row);
        }
        return flat;
    }

    // Rebuilds rows with capacities 1, 2, 3, ... and a possibly partial last row.
    // This is a helper method I used because it realy helped me visualize the insert and remove operations when I could just draw out the flat list and then rebuild the triangular structure from it.
    private void rebuildFromFlat(List<E> flat) {
        metaList = new ArrayList<>();

        int rowSize = 1;
        int i = 0;
        while (i < flat.size()) {
            int take = Math.min(rowSize, flat.size() - i);
            List<E> row = new ArrayList<>(take);
            for (int j = 0; j < take; j++) {
                row.add(flat.get(i + j));
            }
            metaList.add(row);
            i += take;
            rowSize++;
        }

        size = flat.size();
    }
}
