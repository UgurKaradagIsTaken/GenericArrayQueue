/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericarrayqueue;

/**
 *
 * @author apple
 */
public class GenericArrayQueue<Item> {
    Item[] array;
    int N;
    int first;
    int last;

    public GenericArrayQueue(int size) {
        array = (Item[]) new Object[size];
        this.N = size;
        first = 0;
        last = 0;
    }
    public boolean isEmpty() {
        return N == 0;
    }
    public void enqueue(Item item) {
        if(N == array.length) {
            this.resize(N * 2);
        }
        array[last] = item;
        last++;
        if(last == array.length) {
            last = 0;
        }
    }
    public Item dequeue() {
        if(isEmpty()) {
            throw new IllegalAccessError("Exception is being handled");
        }
        Item deletedItem = array[first];
        array[first] = null;
        first++;
        if(first == array.length || array[first] == null) {
            first = 0;
        }
        N--;
        return deletedItem;
    }
    public String toString() {
        String s = "";
        for(int i = 0; i < N; i++) {
            s += array[(i + first) % array.length]; //Metodumuzda nullar yani boşluklar var onun için
        }
        return s;
    }
    public void resize(int newSize) {
        if(newSize <= N) {
            throw new IllegalArgumentException("New size cannot be smaller than the actual size!");
        }
        Item[] temp = (Item[]) new Object[newSize];
        for(int i = 0; i < N; i++) {
            temp[i] = array[(i + first) % array.length];
        }
        array = temp.clone();
        first = 0;
        last = N;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
