package linkedlist.myimplement;

import array.Array;

public class LRUBasedArray {
    private Array array;

    public LRUBasedArray() {
        this.array = new Array(5);
        array.insert(0, 1);
        array.insert(1, 2);
        array.insert(2, 3);
        array.printAll();
        System.out.println("---------------");
    }
    public void findCache(int data) {
        for (int i = 0; i < array.getN(); i++) {
            if (array.find(i) == data) {
                array.delete(i);
                array.insert(0, data);
                return;
            }
        }
        if (array.getN() == array.getCount()) {
            array.delete(array.getCount() - 1);
            array.insert(0, data);
        }
        array.insert(0, data);
    }

    public Array getArray() {
        return array;
    }

    public void setArray(Array array) {
        this.array = array;
    }

    public static void main(String[] args) {
        LRUBasedArray lruBasedArray = new LRUBasedArray();
        lruBasedArray.findCache(10);
        lruBasedArray.getArray().printAll();
    }
}
