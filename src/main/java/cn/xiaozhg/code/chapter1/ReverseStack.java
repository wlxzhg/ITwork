package cn.xiaozhg.code.chapter1;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 使用递归反转一个栈
 * */
public class ReverseStack {
    //把最后一个元素最后push进去
    public void reverseStack(LinkedList<Integer> stack) {
        if(stack.isEmpty()) {
            return;
        }
        int lastElement = getLastElement(stack);
        reverseStack(stack);
        stack.push(lastElement);
    }

    //获取最后一个元素
    public int getLastElement(LinkedList<Integer> stack) {
        int num = stack.pop();
        if (stack.isEmpty()) {
            return num;
        } else {
            int lastElement = getLastElement(stack);
            stack.push(num);
            return lastElement;
        }
    }

    @Test
    public void test() {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < 5; i++) {
            stack.push(i + 1);
        }
        System.out.println(stack);
        (new ReverseStack()).reverseStack(stack);
        System.out.println(stack);
    }
}
