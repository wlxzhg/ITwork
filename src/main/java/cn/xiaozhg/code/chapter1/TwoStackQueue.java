package cn.xiaozhg.code.chapter1;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 使用两个栈实现一个队列
 * */
public class TwoStackQueue {
    private LinkedList<Integer> addStack = new LinkedList<Integer>();
    private LinkedList<Integer> pollStack = new LinkedList<Integer>();

    public void add(int newNum) {
        addStack.push(newNum);
    }

    public int poll() {
        if (pollStack.isEmpty()) {
            if(addStack.isEmpty()) {
                throw new RuntimeException("queue is empty!");
            }
            while (!addStack.isEmpty()) {
                pollStack.push(addStack.pop());
            }
        }
        return pollStack.pop();
    }

    public int peek() {
        return pollStack.peek();
    }

    @Test
    public void test() {
        TwoStackQueue queue = new TwoStackQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }

}
