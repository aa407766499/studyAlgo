package linkedlist.github;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 *
 * Author: Zheng
 */
public class LinkedListAlgo {

    //三指针（前一个节点指针，当前节点指针，下一个节点指针）
    // 单链表反转
    public static Node reverse(Node list) {
        Node curr = list, pre = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    // 检测环
    public static boolean checkCircle(Node list) {
        if (list == null) {
            return false;
        }
        //第一点：由于fast指针每次跑两格，则在无环及链表节点为偶数的情况下，fast会跑到最后一个节点,
        // 在无环及链表节点为奇数的情况下，fast指针会跑到最后一个节点的下一个节点(假想是节点,其实是null)。所以要采取以下的循环条件
        //如果fast指针的起点和slow指针的起点不同，则情况与上述相反,其实fast指针和slow指针的起点相同，谁在前一个，谁在后一个，对于奇偶节点数的两种情况不影响循环条件
        //第二点：从链表头节点开始一起跑,如果有环,fast指针先进环,slow指针后进环，一定时间内两者肯定会相遇，则说明有环。如果无环，fast指针会节点跑完链表,循环退出
        Node fast = list.next;
        Node slow = list;
        //保证无环，循环退出
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //保证进环，循环退出
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    // 有序链表合并
    public static Node mergeSortedLists(Node la, Node lb) {
        if (la == null) {
            return lb;
        }
        if (lb == null) {
            return la;
        }
        //找新链表的头节点head,遍历新链表的指针r
        Node p = la;
        Node q = lb;
        Node head;
        if (p.data < q.data) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        Node r = head;

        while (p != null && q != null) {
            if (p.data < q.data) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }

        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }

        return head;
    }

    // 删除倒数第K个结点
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) {
            return list;
        }

        Node slow = list;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }

    // 求中间结点
    public static Node findMiddleNode(Node list) {
        if (list == null) {
            return null;
        }

        Node fast = list;
        Node slow = list;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

}