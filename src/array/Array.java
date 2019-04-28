package array;

/**
 * 数组
 */
public class Array {
    //  数组
    private int[] data;
    // 数组长度
    private int n;
    //    数组中实际的元素个数
    private int count;

    public Array() {
        this(10);
    }

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    //    根据索引查找元素
    public int find(int index) {
        if (index < 0 || index >= n) {
            return -1;
        }
        return data[index];
    }


    /**
     * 根据索引插入元素
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, int value) {

        if (count == n) {
            System.out.println("没有可以插入的位置");
            return false;
        }
        if (index < 0 || index > count) {
            System.out.println("位置不合法");
            return false;
        }
        for (int i = count; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    //删除指定位置的元素
    public boolean delete(int index) {
        if (index < 0 || index >= count) {
            return false;
        }
        for (int i = index; i < count-1; i++) {
            data[i] = data[i + 1];
        }
        --count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(data[i]);
        }
        System.out.println();
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 1);
        array.insert(1, 2);
        array.insert(2, 3);
        array.insert(1, 6);
        array.insert(0, 9);
        array.printAll();
        array.delete(0);
        array.printAll();
    }
}
