package github.queue;

/**
 * 基于链表实现的队列
 *
 * Author: Zheng
 */
public class QueueBasedOnLinkedList {

    // 队列的队首和队尾
    /**
     * 基于链表的队列，tail指向最后一个元素，当head==tail时，出队取最后一个元素，tail置空，队列相当于清零
     */
    private Node head = null;
    private Node tail = null;

    // 入队
    public void enqueue(String value) {
        if (tail == null) {
            Node newNode = new Node(value, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;
        }
    }

    // 出队
    public String dequeue() {
        if (head == null) {
            return null;
        }

        String value = head.data;
        head = head.next;
        //head走到了尾节点的下一个节点
        if (head == null) {
            tail = null;
        }
        return value;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }

}