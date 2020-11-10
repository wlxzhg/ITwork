package cn.xiaozhg.code.chapter1;

import java.util.LinkedList;

/**
 * 实验LinkedList作为栈、队列的基本操作
 * */
public class BasicStackAndQueue {
    public static void main(String[] args) {
        //作为栈使用
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(1);  //入栈
        stack.peek();      //获取栈顶元素
        stack.pop();       //出栈

        //作为队列使用
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(1);      //入队列
        queue.peek();      //获取队列头部元素
        queue.poll();      //出队列
    }
}
