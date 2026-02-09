package inclasss;

public class MyArrayList<E> {
    private static final int INITIAL_CAPACITY = 30;

    private E[] theData;

    private int size =0;

    private int capacity = 0;

    public MyArrayList(){
        capacity = INITIAL_CAPACITY;
        theData = (E[]) new Object[capacity];
    }

    public MyArrayList(int initialCapacity){
        capacity = initialCapacity;
        theData = (E[]) new Object[initialCapacity];
    }

    public boolean add(E e){
        if (size == capacity){
//            reallocate();
        }
        theData[size]=e;
        size++;
        return true;
    }

    public E get(int index){
        if (index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }

        return theData[index];
    }

    public E set(int index, E element){
        if (index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = theData[index];
        theData[index] = element;
        return oldValue;
    }

    public void add(int index, E element){
        if (index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (size == capacity){
            reallocate();
        }
        for (int i = size; i > index; i--){
            theData[i] = theData[i-1];
        }
        theData[index] = element;
        size++;
    }

    public void reallocate(){
        capacity *= 2;
        theData = (E[]) new Object[capacity];
    }



}

