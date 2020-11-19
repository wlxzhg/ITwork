package cn.xiaozhg.code.chapter2;

import org.junit.Test;

/**
 * 有两个有序链表，求它们的公共部分
 * 如1->2->3->null和2—>5->null的公共部分为2->null
 * */
public class CommonPart {
    public void printCommonPart(Node head1, Node head2) {
        Node p1 = head1,p2 = head2;
        while (p1 != null && p2 != null) {
            if(p1.getVal() > p2.getVal()) {
                p2 = p2.getNext();
            } else if (p1.getVal() < p2.getVal()) {
                p1 = p1.getNext();
            } else {
                System.out.println(p1.getVal());
                p1 = p1.getNext();
                p2 = p2.getNext();
            }
        }
    }

    @Test
    public void testPrintCommonPart() {
        int[] arr1 = {1,3,5,8,19};
        int[] arr2 = {2,3,8,10,15,19};
        Node node = Node.getNodeFromArr(arr1);
        Node node1 = Node.getNodeFromArr(arr2);
        (new CommonPart()).printCommonPart(node, node1);

    }
}
