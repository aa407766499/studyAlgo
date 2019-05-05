package linkedlist.myimplement.stack;

import linkedlist.myimplement.Node;

public class LinkedListStack {
    /**
     * 链表栈
     */
    private Node head;

    /**
     * 栈中的元素个数
     */
    private int count;

    public LinkedListStack() {
        this.count = 0;
    }

    /**
     * 入栈
     * @param data
     * @return
     */
    public boolean push(String data) {
        if (head == null) {
            head = new Node(data, null);
            ++count;
            return false;
        }
        Node node = head;
        while (node.getNext() != null) {
            node = node.getNext();
        }
        node.setNext(new Node(data, null));
        ++count;
        return true;
    }

    /**
     * 出栈
     * @return
     */
    public String pop() {
        if (count == 0) {
            System.out.println("栈中无数据");
            return null;
        }
        Node node = head;
        while (node.getNext().getNext() != null) {
            node = node.getNext();
        }
        String data = (String) node.getNext().getValue();
        node.setNext(null);
        --count;
        return data;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push("a");
        linkedListStack.push("b");
        linkedListStack.push("c");
        System.out.println(linkedListStack.getHead());
        String data = linkedListStack.pop();
        System.out.println(data);
    }
}
