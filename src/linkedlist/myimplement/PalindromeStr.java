package linkedlist.myimplement;

public class PalindromeStr {
    private LinkedList<String> linkedList;

    public PalindromeStr() {
        this.linkedList = new LinkedList<>("l");
        linkedList.insertEnd("e");
        linkedList.insertEnd("a");
        linkedList.insertEnd("v");
        linkedList.insertEnd("a");
        linkedList.insertEnd("a");
        linkedList.insertEnd("e");
        linkedList.insertEnd("l");
    }

    public Boolean isPalindromeString() {
        Node slowPointer = null;
        Node fastPointer = null;
        Node nextNode = null;
        Node<String> firstNode = linkedList.getFirstNode();
        nextNode = firstNode.getNext();
        if (linkedList.getSize() == 0) {
            return false;
        }
        if (linkedList.getSize() == 1) {
            return true;
        }
        if (linkedList.getSize() == 2) {
            if (firstNode.getValue().equals(firstNode.getNext().getValue())) {
                return true;
            }
            return false;
        }
        slowPointer = firstNode;
        fastPointer = firstNode;
        if (linkedList.getSize() % 2 == 1) {
            while (fastPointer.getNext() != null) {
                fastPointer = fastPointer.getNext().getNext();
                Node tmp = slowPointer;
                Node tmpNextNode = nextNode.getNext();
                if (tmp.equals(firstNode)) {
                    tmp.setNext(null);
                }
                slowPointer = nextNode;
                slowPointer.setNext(tmp);
                nextNode = tmpNextNode;
            }
            while (slowPointer.getNext()!=null) {
                if (slowPointer.getNext().getValue().equals(nextNode.getValue())) {
                    slowPointer = slowPointer.getNext();
                    nextNode = nextNode.getNext();
                } else {
                    return false;
                }
            }
            return true;
        }
        if (linkedList.getSize() % 2 == 0) {
            while (fastPointer.getNext().getNext() != null) {
                fastPointer = fastPointer.getNext().getNext();
                Node tmp = slowPointer;
                Node tmpNextNode = nextNode.getNext();
                if (tmp.equals(firstNode)) {
                    tmp.setNext(null);
                }
                slowPointer = nextNode;
                slowPointer.setNext(tmp);
                nextNode = tmpNextNode;
            }
            while (slowPointer.getNext()!=null) {
                if (slowPointer.getValue().equals(nextNode.getValue())) {
                    slowPointer = slowPointer.getNext();
                    nextNode = nextNode.getNext();
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PalindromeStr palindromeStr = new PalindromeStr();
        Boolean palindromeString = palindromeStr.isPalindromeString();
        System.out.println(palindromeString);
    }
}
