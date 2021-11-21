//task2

import java.util.Arrays;

public class MyArrayListClass<T> {
    private T[] array;
    private int size;
    private static final int DEFAULT_VOLUME = 0;

    public static void main(String[] args) {

        MyArrayListClass<Integer> numbersList = new MyArrayListClass<>();
        numbersList.add(1);
        numbersList.add(2);
        numbersList.add(3);
        numbersList.add(5);
        numbersList.remove(2);
        System.out.println("Array: " + numbersList.toString());
        System.out.println("Size of array = " + numbersList.size());
    }

    public MyArrayListClass(){
        this.array = (T[]) new Object[DEFAULT_VOLUME];
    }

    private int isExisting(int id){
        if((id < 0) || (id >= size))
        {
            throw new IndexOutOfBoundsException("Index is not existing");
        }
        else return id;
    }

    public T get(int id){
        isExisting(id);
        return array[id];
    }

    private T [] increaseVolume(){
        Object [] temp = new Object[(array.length * 2)];
        System.arraycopy(array, 0, temp, 0, array.length);
        return (T[]) temp;
    }

    public boolean add(T value){
        if (size==0) {
            this.array = (T[]) new Object[1];
        }
        if (size == array.length){
            array = increaseVolume();
        }
        array[size] = value;
        size++;
        return true;
    }

    public int size() {
        return size;
    }

    public T remove (int id){
        isExisting(id);
        T [] tempArray = array;
        array = (T[])new Object[tempArray.length-1];
        T value = tempArray[id];
        System.arraycopy(tempArray, 0, array, 0, id);
        System.arraycopy(tempArray, id + 1, array, id, tempArray.length - id - 1);
        size--;
        return value;
    }

    @Override
    public String toString(){
        T[] tempArray = (T[]) new Object[size];
        System.arraycopy(array, 0, tempArray, 0, size);
        return Arrays.toString(tempArray);
    }

}
