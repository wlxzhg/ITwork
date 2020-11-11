package cn.xiaozhg.code.chapter1;

import org.junit.Test;

import java.util.LinkedList;

public class SortStackByStack {
    public void sortStackByStack(LinkedList<Integer> stack) {
        LinkedList<Integer> sortStack = new LinkedList<Integer>();
        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (!sortStack.isEmpty()) {
                while (!sortStack.isEmpty() && sortStack.peek() <= num) {
                    stack.push(sortStack.pop());
                }
            }
            sortStack.push(num);
        }
        while (!sortStack.isEmpty()) {
            stack.push(sortStack.pop());
        }
    }

    @Test
    public void test() {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int[] nums = {3, 8, 2, 1, 6};
        for (int i : nums) {
            stack.push(i);
        }
        sortStackByStack(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
