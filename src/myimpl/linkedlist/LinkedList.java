package myimpl.linkedlist;

public class LinkedList<T> {
    /**
     * 头节点
     */
    private Node<T> firstNode;
    /**
     * 尾节点
     */
    private Node<T> lastNode;
    /**
     * 链表中节点个数
     */
    private Integer size;
    /**
     * 链表容量
     */
    Integer capacity;

    public LinkedList(T value) {
        this.firstNode = new Node<T>();
        this.firstNode.setValue(value);
        this.firstNode.setNext(null);
        this.lastNode = this.firstNode;
        this.size = 1;
        this.capacity = 5;
    }

    /**
     * 链表末尾插入元素
     */
    public void insertEnd(T value) {
        Node<T> lastNode = new Node<>();
        lastNode.setValue(value);
        lastNode.setNext(null);
        this.lastNode = lastNode;
        Node nextNode = firstNode.next;
        if (nextNode != null) {
            while (true) {
                if (nextNode.getNext() != null) {
                    nextNode = nextNode.getNext();
                    continue;
                }
                nextNode.setNext(lastNode);
                break;
            }
        } else {
            firstNode.setNext(lastNode);
        }
        ++size;
    }

    /**
     * 链表头部插入元素
     */
    public void insertHead(T value) {
        Node<T> headNode = new Node<>();
        headNode.setValue(value);
        headNode.setNext(this.firstNode);
        this.firstNode = headNode;
        ++size;
    }

    /**
     * 指定节点前插入元素
     */
    public void insertElemenBeforeNode(T value, Node<T> targetNode) {
        if (targetNode.equals(firstNode)) {
            insertHead(value);
            return;
        }
        Node<T> prevNode = findPrev(targetNode);
        Node newNode = new Node();
        newNode.setValue(value);
        prevNode.setNext(newNode);
        newNode.setNext(targetNode);
        ++size;
    }

    /**
     * 指定节点后插入元素
     */
    public void insertElemenafterNode(T value, Node<T> targetNode) {
        Node nextNode = null;
        Node nodeInLinkedList = find(targetNode);
        if (nodeInLinkedList != null) {
            if (nodeInLinkedList.getNext() != null) {
                nextNode = nodeInLinkedList.getNext();
                Node<T> newNode = new Node<>();
                newNode.setValue(value);
                nodeInLinkedList.setNext(newNode);
                newNode.setNext(nextNode);
                ++size;
            } else {
                insertEnd(value);
            }
        }
    }

    /**
     * 查找指定节点前一个节点
     */
    public Node<T> findPrev(Node<T> targetNode) {
        Node nextNode = null;
        Node prevNode = null;
        prevNode = firstNode;
        nextNode = firstNode.getNext();
        while (nextNode != null) {
            if (nextNode.equals(targetNode)) {
                return prevNode;
            }
            prevNode = nextNode;
            nextNode = nextNode.getNext();
        }
        return null;
    }

    /**
     * 查找指定节点
     */
    public Node<T> find(Node<T> targetNode) {
        if (targetNode.equals(firstNode)) {
            return firstNode;
        }
        Node nextNode = firstNode.getNext();
        while (nextNode != null) {
            if (nextNode.equals(targetNode)) {
                return nextNode;
            }
            nextNode = nextNode.getNext();
        }
        return null;
    }


    /**
     * 更新节点
     */
    public void updateNode(Node targetNode, T value) {
        Node resultNode = find(targetNode);
        if (resultNode != null) {
            resultNode.setValue(value);
        }
    }

    /**
     * 删除节点
     */
    public void deleteNode(Node targetNode) {
        Node resultNode = find(targetNode);
        if (resultNode != null) {
            Node prevNode = findPrev(targetNode);
            Node nextNode = resultNode.getNext();
            prevNode.setNext(nextNode);
        }
    }

    /**
     * 带头节点链表反转(有哨兵节点)
     */
    public Node inverseLinkedList_head(Node p) {//从头节点p开始
        Node<Integer> Head = new Node(999, null);
        Head.setNext(p);
        Node cur = p.next;
        Node next = null;
        p.setNext(null);
        while (cur != null) {
            next = cur.getNext();
            cur.setNext(Head.getNext());
            Head.setNext(cur);
            cur = next;
        }
        return Head;
    }

    /**
     * 无头节点链表反转
     */
    public Node inverseLinkedList(Node e) {//从头节点到目标节点e
        Node p = null;
        Node q = this.firstNode;
        Node next = null;
        while (!q.equals(e)) {
            next = q.getNext();
            q.setNext(p);
            p = q;
            q = next;
        }
        q.setNext(p);
        return q;
    }

    /**
     * 删除链表倒数第n个节点
     */
    public Node deleteReciprocalNode(LinkedList<Integer> linkedList, int k) {
        int i = 0;
        int size = linkedList.getSize();
        Node p = linkedList.getFirstNode();
        Node head = new Node(999, p);
        //删除头节点
        if (size - k - 1 < 0) {
            head.setNext(p.getNext());
        }
        //size-k代表走到倒数第k个节点p走过的步数,size-k-1少走一步说明走到要删除的节点的前一个节点
        while (p!= null && i < size - k-1) {
            p = p.getNext();
            ++i;
        }
        p.setNext(p.getNext().getNext());
        return head;
    }

    /**
     * 获取链表中点
     */
    public Node getMidpointOfLinkedList() {
        Node q = this.firstNode;
        Node p = this.firstNode;
        //该判断条件保证了中点在节点个数为奇数的时候在正中间，偶数的时候拿到中点的前一个
        while (p.getNext() != null && p.getNext().getNext() != null) {
            q = q.getNext();
            p = p.getNext().getNext();
        }
        return q;
    }

    //还可以再简洁点
    public Node mergeSortedLinkedList(Node<Integer> q, Node<Integer> p) {
        LinkedList<Integer> mergeLinkedList = new LinkedList<>(999);
        while (q != null && p != null) {
            if (q.getValue().equals(p.getValue())) {
                mergeLinkedList.insertEnd(q.getValue());
                mergeLinkedList.insertEnd(p.getValue());
                q = q.getNext();
                p = p.getNext();
            } else if (q.getValue() < p.getValue()) {
                mergeLinkedList.insertEnd(q.getValue());
                q = q.getNext();
            } else {
                mergeLinkedList.insertEnd(p.getValue());
                p = p.getNext();
            }
            if (q == null) {
                mergeLinkedList.getLastNode().setNext(p);
            }
            if (p == null) {
                mergeLinkedList.getLastNode().setNext(q);
            }
        }
        return mergeLinkedList.getFirstNode();
    }

    //low，但是至少能工作
    public boolean hasCirque(LinkedList<Integer> linkedList) {
        Node<Integer> q = linkedList.getFirstNode();
        //外层循环每次循环参与比较的节点个数
        Integer restSize = linkedList.getSize();
        Integer size = 2;
        Node nextNode = q.getNext();
        //外层循环使得q一直遍历到倒数第二个节点
        while (q.getNext().getNext() != null) {
            //内层循环遍历q节点后面的所有节点
            while (!nextNode.getNext().equals(q)) {
                nextNode = nextNode.getNext();
                ++size;
                //代表最后一个节点的下一个节点不是q
                if (size > restSize) {
                    break;
                }
                //代表最后一个节点的下一个节点为null或者为q节点
                if (size.equals(restSize)) {
                    if (nextNode.getNext() == null) {
                        break;
                    }
                }
            }
            if (size.equals(restSize)) {
                //代表最后一个节点的下一个节点为null跳到下一次循环
                if (nextNode.getNext() == null) {
                    q = q.getNext();
                    nextNode = q.getNext();
                    --restSize;
                    continue;
                }
                if (nextNode.getNext().equals(q)) {
                    return true;
                }
            }
            //代表最后一个节点的下一个节点不是null并且不是q
            if (size > restSize) {
                q = q.getNext();
                nextNode = q.getNext();
                --restSize;
                continue;
            }
            //size<restSize ,nextNode节点还没到最后一个节点就退出内层循环，说明有环
            return true;
        }
        //遍历到倒数第二个节点特殊处理
        if (nextNode.getNext() == null) {
            return false;
        }
        return nextNode.getNext().equals(q);
    }

    public void printAll() {
        System.out.println(firstNode.getValue());
        Node nextNode = firstNode.getNext();
        while (nextNode != null) {
            System.out.println(nextNode.getValue());
            nextNode = nextNode.getNext();
        }
    }

    public Node<T> getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Node<T> firstNode) {
        this.firstNode = firstNode;
    }

    public Node<T> getLastNode() {
        return lastNode;
    }

    public void setLastNode(Node<T> lastNode) {
        this.lastNode = lastNode;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList1 = new LinkedList<>(1);
        linkedList1.insertEnd(3);
        linkedList1.insertEnd(5);
        linkedList1.insertEnd(6);
        linkedList1.insertEnd(7);
        linkedList1.insertEnd(8);
        System.out.println("-------------------------------");
        LinkedList<Integer> linkedList2 = new LinkedList<>(2);
        linkedList2.insertEnd(6);
        linkedList2.insertEnd(7);
        linkedList2.insertEnd(8);
        linkedList2.insertEnd(9);
        linkedList2.insertEnd(11);
        linkedList2.insertEnd(13);
        linkedList2.printAll();
        System.out.println("-------------------------------");
        Node node = linkedList1.deleteReciprocalNode(linkedList1, 10);
        System.out.println(node);
    }
}
