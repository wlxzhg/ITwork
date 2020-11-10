package cn.xiaozhg.code.chapter1;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 设计一个栈，
 * pop，push，getMin的时间复杂度都是O(1)
 * */
public class GetMinStack {
    private LinkedList<Integer> stackData = new LinkedList<Integer>();
    private LinkedList<Integer> stackMin = new LinkedList<Integer>();

    public void push(int newNum) {
        stackData.push(newNum);
        if (stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else {
            int min = getMin();
            if(newNum <= min) {
                stackMin.push(newNum);
            }
        }
    }

    public int pop() {
        int num = stackData.pop();
        int min = getMin();
        if(num == min) {
            stackMin.pop();
        }
        return num;
    }

    public int getMin() {
        return stackMin.peek();
    }

    @Test
    public void test() {
        GetMinStack getMinStack = new GetMinStack();
        int[] arr = {3,4,5,1,2,1};
        for (int i : arr) {
            getMinStack.push(i);
            System.out.println(getMinStack.getMin());
        }
    }
}
