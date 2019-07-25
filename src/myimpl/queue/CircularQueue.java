package myimpl.queue;

/**
 * Created by Huzi on 2019/5/5.
 */
public class CircularQueue {
    private String array[];
    private int n;
    private int head = 0;
    private int tail = 0;
    public CircularQueue() {
        this(4);
    }

    public CircularQueue(int capacity) {
        this.array = new String[capacity];
        this.n = capacity;
    }

    public boolean inqueue(String data) {
        if ((tail + 1) % n == head) {
            System.out.println("队列已满");
            return false;
        }
        array[tail] = data;
        tail = (tail + 1) % n;
        return true;
    }

    public String  dequeue() {
        if (head == tail) {
            System.out.println("队列为空");
            return null;
        }
        String data = array[head];
        head = (head + 1) % n;
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
        CircularQueue circularQueue = new CircularQueue();
        circularQueue.inqueue("a");
        circularQueue.inqueue("b");
        circularQueue.inqueue("c");
        circularQueue.inqueue("d");
        circularQueue.inqueue("e");
        circularQueue.printAll();
        System.out.println("-------------");
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        circularQueue.dequeue();
        circularQueue.dequeue();
    }
}

