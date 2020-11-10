package cn.xiaozhg.code.chapter1;

import java.util.LinkedList;

public class BasicStackAndQueue {
    public static void main(String[] args) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(1);
        stack.peek();
        stack.pop();

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.peek();
        queue.poll();
    }
}
