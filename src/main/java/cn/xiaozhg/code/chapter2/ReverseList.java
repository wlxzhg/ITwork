package cn.xiaozhg.code.chapter2;

import org.junit.Test;

public class ReverseList {
    public Node reverseList(Node head) {
        Node dummy = new Node(-1);
        Node p = head;
        while (p != null) {
            Node p1 = dummy.getNext();
            dummy.setNext(p);
            p = p.getNext();
            dummy.getNext().setNext(p1);
        }

        return dummy.getNext();
    }

    public DeNode reverseList(DeNode head) {
        DeNode dummy = new DeNode(-1);
        DeNode p = head;
        while (p != null) {
            DeNode p1 = dummy.getNext();
            dummy.setNext(p);
            p = p.getNext();
            dummy.getNext().setPrev(dummy);
            dummy.getNext().setNext(p1);
            if(p1 != null) {
                p1.setPrev(dummy.getNext());
            }
        }
        if (dummy.getNext() != null) {
            dummy.getNext().setPrev(null);
        }
        return dummy.getNext();
    }

    @Test
    public void testReverseList() {
        Node nodeFromArr = Node.getNodeFromArr(new int[]{1,2});
        System.out.println(nodeFromArr);
        nodeFromArr = reverseList(nodeFromArr);
        System.out.println(nodeFromArr);
    }

    @Test
    public void testReverseList2() {
        DeNode nodeFromArr = DeNode.getNodeFromArr(new int[]{1, 2, 3, 4});
        System.out.println(nodeFromArr);
        reverseList(nodeFromArr);
        DeNode p = nodeFromArr;
        while (p != null) {
            System.out.print(p.getVal());
            if (p.getPrev() != null) {
                System.out.print(",");
            }
            p = p.getPrev();
        }
    }
}
