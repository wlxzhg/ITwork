package cn.xiaozhg.code.chapter2;

import org.junit.Test;

public class CommonPart {
    class Node {
        int val;
        Node next;
        Node(int v,Node n) {
            this.val = v;
            this.next = n;
        }
    }

    public void printCommonPart(Node head1, Node head2) {
        Node p1 = head1,p2 = head2;
        while (p1 != null && p2 != null) {
            if(p1.val > p2.val) {
                p2 = p2.next;
            } else if (p1.val < p2.val) {
                p1 = p1.next;
            } else {
                System.out.println(p1.val);
                p1 = p1.next;
                p2 = p2.next;
            }
        }
    }

    @Test
    public void testPrintCommonPart() {
        int[] arr1 = {1,3,5,8,19};
        int[] arr2 = {2,3,8,10,15,19};
        Node node = generateNode(arr1);
        Node node1 = generateNode(arr2);
        (new CommonPart()).printCommonPart(node, node1);

    }

    public Node generateNode(int[] arr) {
        Node head = null;
        Node p = null;
        for (int i = 0; i < arr.length; i++) {
            if(i == 0) {
                head = new Node(arr[i], null);
                p = head;
            } else {
                p.next = new Node(arr[i],null);
                p = p.next;
            }
        }
        return head;
    }
}
