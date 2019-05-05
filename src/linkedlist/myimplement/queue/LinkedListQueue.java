package linkedlist.myimplement.queue;

import linkedlist.myimplement.Node;

/**
 * Created by Huzi on 2019/5/5.
 */
public class LinkedListQueue {
    private Node linkedListHead;
    private Node head;
    private Node tail;

    public boolean inqueue(String data) {
        if (linkedListHead == null) {
            linkedListHead = new Node(data, null);
            head = linkedListHead;
            tail = linkedListHead;
            return true;
        }
        tail.setNext(new Node(data, null));
        tail = tail.getNext();
        return true;
    }

    public String dequeue() {
        if (head != null) {
            String data = (String) head.getValue();
            head = head.getNext();
            return data;
        }
        return null;
    }

    public Node getLinkedListHead() {
        return linkedListHead;
    }

    public void setLinkedListHead(Node linkedListHead) {
        this.linkedListHead = linkedListHead;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void printAll() {
        Node node = this.getHead();
        while (node != null) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        linkedListQueue.inqueue("a");
        linkedListQueue.inqueue("b");
        linkedListQueue.inqueue("c");
        linkedListQueue.printAll();
        System.out.println("-------------------------");
        System.out.println(linkedListQueue.dequeue());
        System.out.println(linkedListQueue.dequeue());
        String dataNotNull = linkedListQueue.dequeue();
        System.out.println(dataNotNull);
        String dataIsNull = linkedListQueue.dequeue();
        System.out.println(dataIsNull);
    }
}
