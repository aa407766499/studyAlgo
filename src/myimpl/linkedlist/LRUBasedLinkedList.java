package myimpl.linkedlist;

public class LRUBasedLinkedList {

    private LinkedList<Integer> linkedList;

    {
        LinkedList<Integer> linkedList = new LinkedList<>(1);
        linkedList.insertEnd(3);
        linkedList.insertEnd(11);
        linkedList.printAll();
        this.linkedList = linkedList;
        System.out.println("-------------------------------");
    }

    /**
     * 查询缓存
     *
     * @param targetNode
     * @return
     */
    public Integer findCache(Node targetNode) {
        Node resultNode = linkedList.find(targetNode);
        if (resultNode != null) {
            linkedList.deleteNode(resultNode);
            linkedList.insertHead(((Integer) resultNode.getValue()));
            return ((Integer) resultNode.getValue());
        } else if (linkedList.getSize().equals(linkedList.getCapacity())) {
            linkedList.deleteNode(linkedList.getLastNode());
            linkedList.insertHead(((Integer) targetNode.getValue()));
            return ((Integer) targetNode.getValue());
        } else {
            linkedList.insertHead(((Integer) targetNode.getValue()));
            return ((Integer) targetNode.getValue());
        }
    }

    public LinkedList<Integer> getLinkedList() {
        return linkedList;
    }

    public void setLinkedList(LinkedList<Integer> linkedList) {
        this.linkedList = linkedList;
    }

    public static void main(String[] args) {
        LRUBasedLinkedList lruBasedLinkedList = new LRUBasedLinkedList();
        Integer cacheValue = lruBasedLinkedList.findCache(new Node(11, null));
        lruBasedLinkedList.getLinkedList().printAll();
    }

}
