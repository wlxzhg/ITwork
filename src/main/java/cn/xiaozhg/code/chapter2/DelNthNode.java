package cn.xiaozhg.code.chapter2;

import org.junit.Test;

public class DelNthNode {
    public Node delNthNode(Node head,int n) {
        Node dummy = new Node(-1, head);

        if(n <= 0) {
            return dummy.getNext();
        }
        Node p1 = dummy;
        Node p2 = dummy;
        for(int i = 1; i <= n; i++) {
            if(p1 == null) {
                return dummy.getNext();
            }
            p1 = p1.getNext();
        }
        if(p1 == null) {
            return dummy.getNext();
        }
        while (p1.getNext() != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();
        }
        p2.setNext(p2.getNext().getNext());
        return dummy.getNext();
    }

    @Test
    public void testDelNthNode() {
        Node head = Node.getNodeFromArr(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(head);
        DelNthNode delNthNode = new DelNthNode();
        Node newHead = delNthNode.delNthNode(head, 1);
        System.out.println(newHead);
        Node newHead2 = delNthNode.delNthNode(newHead,5);
        System.out.println(newHead2);
        Node newHead3 = delNthNode.delNthNode(newHead2,3);
        System.out.println(newHead3);
    }
}
