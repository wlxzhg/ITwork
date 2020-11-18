package cn.xiaozhg.code.chapter2;

public class DeNode {
    private int val;
    private DeNode next;
    private DeNode prev;

    public DeNode(int val) {
        this.val = val;
    }

    public DeNode(int val, DeNode next, DeNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public DeNode getNext() {
        return next;
    }

    public void setNext(DeNode next) {
        this.next = next;
    }

    public DeNode getPrev() {
        return prev;
    }

    public void setPrev(DeNode prev) {
        this.prev = prev;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.val);
        DeNode p = this.next;
        while (p != null) {
            sb.append("," + p.val);
            p = p.next;
        }
        return sb.toString();
    }

    public static DeNode getNodeFromArr(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        DeNode head = null,p = null;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                head = new DeNode(arr[i]);
                p = head;
            } else {
                p.next = new DeNode(arr[i]);
                p.next.prev = p;
                p = p.next;
            }
        }
        return head;
    }
}
