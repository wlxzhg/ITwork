package cn.xiaozhg.code.chapter2;

import org.junit.Test;

/**
 * 反转链表的一部分
 * */
public class ReversePartList {
    @Test
    public void testReversePartList() {
        Node head = Node.getNodeFromArr(new int[]{1, 2, 3, 4, 5});
        head = reversePartList(head, 1, 3);
        System.out.println(head);
    }

    public Node reversePartList(Node head, int start, int end) {
        if(head == null || head.getNext() == null || start == end || start <= 0 || start > end) {
            return head;
        }
        Node dummy = new Node(-1);
        dummy.setNext(head);
        Node pStart = null, pEnd = null, pBeforeStart = null, pAfterEnd = null;
        Node p = dummy;
        for(int i = 0; i <= end; i++) {
            if(p == null) {
                return head;
            }
            if(i == start - 1) {
                pBeforeStart = p;
            } else if (i == end) {
                pEnd = p;
            }
            p = p.getNext();
        }
        pStart = pBeforeStart.getNext();
        pAfterEnd = pEnd.getNext();
        reverseList(pStart, pEnd);
        pBeforeStart.setNext(pEnd);
        pStart.setNext(pAfterEnd);
        return dummy.getNext();
    }

    public Node reverseList(Node start,Node end) {
        Node dummy = new Node(-1);
        Node p = start;
        //这里注意要保存一下end.next再判断，因为end是会变化的
        Node stop = end.getNext();
        while (p != stop && p != null) {
            Node next = dummy.getNext();
            dummy.setNext(p);
            p = p.getNext();
            dummy.getNext().setNext(next);
        }
        return dummy.getNext();
    }
}
