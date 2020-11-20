package cn.xiaozhg.code.chapter2;

import org.junit.Test;

public class JosephusLoop {
    @Test
    public void test() {
        Node head = new Node(1);
        Node p = head;
        for(int i = 2; i <= 10; i++) {
            Node next = new Node(i);
            p.setNext(next);
            p = next;
        }
        p.setNext(head);
        Node node = josephusLoop(head, 2);
        if (node != null) {
            System.out.println(node.getNext() == node);
            System.out.println(node.getVal());
        } else {
            System.out.println(false);
        }
    }

    public Node josephusLoop(Node head, int m) {
        if (head == null || head.getNext() == null || m <= 0) {
            return head;
        }
        if(m == 1) {
            Node last = head;
            while (last.getNext() != head) {
                last = last.getNext();
            }
            last.setNext(last);
            return last;
        }
        Node p = head;
        int index = 1;
        while (p != null && p.getNext() != null && p.getNext() != p) {
            if (index == m - 1) {
                p.setNext(p.getNext().getNext());
                index = 0;
            } else {
                index++;
                p = p.getNext();
            }
        }
        return p;
    }
}
