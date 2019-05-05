package linkedlist.myimplement.queue;

/**
 * Created by Huzi on 2019/5/5.
 */
public class ArrayQueue {
    private String array[];
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int capacity) {
        this.array = new String[capacity];
        this.n = capacity;
    }

    public boolean inqueue(String data) {
        if (tail == n) {
            if (head == 0) {
                System.out.println("队列已满");
                return false;
            }
            for (int i = head; i < array.length; i++) {
                array[i - head] = array[i];
            }
            tail = tail - head;
            head = 0;
        }
        array[tail] = data;
        tail++;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            System.out.println("队列为空");
            return null;
        }
        String data = array[head];
        head++;
        return data;
    }

    public String[] getArray() {
        return array;
    }

    public void setArray(String[] array) {
        this.array = array;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public void printAll() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(4);
        arrayQueue.inqueue("a");
        arrayQueue.inqueue("b");
        arrayQueue.inqueue("c");
        arrayQueue.inqueue("d");
        arrayQueue.printAll();
        System.out.println("-------------------------");
        arrayQueue.dequeue();
        arrayQueue.inqueue("f");
        arrayQueue.printAll();
    }
}
