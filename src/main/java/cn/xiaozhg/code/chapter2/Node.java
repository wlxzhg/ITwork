package cn.xiaozhg.code.chapter2;

public class Node {
    private int val;
    private Node next;

    public Node(int value) {
        this.val = value;
        this.next = null;
    }

    public Node(int value, Node next) {
        this.val = value;
        this.next = next;
    }

    public int getVal() {
        return this.val;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.val);
        Node p = this.next;
        while (p != null) {
            sb.append("," + p.val);
            p = p.next;
        }
        return sb.toString();
    }

    public static Node getNodeFromArr(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Node head = null,p = null;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                head = new Node(arr[i],null);
                p = head;
            } else {
                p.next = new Node(arr[i],null);
                p = p.next;
            }
        }
        return head;
    }
}
