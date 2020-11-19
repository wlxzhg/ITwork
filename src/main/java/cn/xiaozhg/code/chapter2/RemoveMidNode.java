package cn.xiaozhg.code.chapter2;

import org.junit.Test;

public class RemoveMidNode {
    /**
     * 快慢指针法
     * 时间复杂度为O(n)
     * */
    public Node removeMidNode1(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node dummy = new Node(-1, head);
        Node p1 = null, p2 = dummy;
        if (dummy.getNext() != null) {
            p1 = dummy.getNext().getNext();
        }
        while (p1 != null && p1.getNext() != null) {
            p1 = p1.getNext().getNext();
            p2 = p2.getNext();
        }
        if(p2.getNext() != null) {
            p2.setNext(p2.getNext().getNext());
        }
        return dummy.getNext();
    }

    /**
     * 求出要删除的结点是第几个再进行删除
     */
    public Node removeMidNode2(Node head) {
        int length = lenOfNode(head);
        if(length <= 1) {
            return head;
        }
        int index = ((length & 1) == 1) ? length / 2 + 1 : length / 2;
        index--;//要删结点的前一个结点下标
        return removeNthNode(head, index);
    }

    /**
     * 删除第n个节点
     * */
    public Node removeNthNode(Node head,int n) {
        if(head == null || n <= 0) {
            return head;
        }
        Node dummy = new Node(-1, head);
        Node p = dummy;
        while (n > 0 && p != null) {
            n--;
            p = p.getNext();
        }
        if (n == 0 && p != null && p.getNext() != null) {
            p.setNext(p.getNext().getNext());
        } else {
            return head;
        }
        return dummy.getNext();
    }

    /**
     * 求链表长度
     * */
    public int lenOfNode(Node head) {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.getNext();
        }
        return count;
    }

    @Test
    public void testRemoveMidNode() {
        Node nodeFromArr = Node.getNodeFromArr(new int[]{1, 2, 3,4,5});
        System.out.println(nodeFromArr);
        nodeFromArr = removeMidNode2(nodeFromArr);
        System.out.println(nodeFromArr);

        nodeFromArr = removeMidNode2(nodeFromArr);
        System.out.println(nodeFromArr);

        nodeFromArr = removeMidNode2(nodeFromArr);
        System.out.println(nodeFromArr);

        nodeFromArr = removeMidNode2(nodeFromArr);
        System.out.println(nodeFromArr);

        nodeFromArr = removeMidNode2(nodeFromArr);
        System.out.println(nodeFromArr);
    }
}
