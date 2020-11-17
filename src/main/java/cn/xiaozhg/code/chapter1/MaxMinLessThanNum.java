package cn.xiaozhg.code.chapter1;

import org.junit.Test;

import java.util.LinkedList;

public class MaxMinLessThanNum {
    @Test
    public void testGetNum() {
        int[] arr = {4,1,4,2,0,7};
        int num = 4;
        System.out.println((new MaxMinLessThanNum()).getNum(arr, num));
    }

    public int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0 || num < 0) {
            return 0;
        }
        int res = 0;
        LinkedList<Integer> maxQueue = new LinkedList<Integer>();
        LinkedList<Integer> minQueue = new LinkedList<Integer>();
        int i = 0,j = 0;
        boolean flag = true;
        while (i < arr.length) {
            while (j < arr.length) {
                if (flag) {
                    while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] <= arr[j]) {
                        maxQueue.pollLast();
                    }
                    maxQueue.addLast(j);
                    while (!minQueue.isEmpty() && arr[minQueue.peekLast()] >= arr[j]) {
                        minQueue.pollLast();
                    }
                    minQueue.addLast(j);
                }

                if (arr[maxQueue.peekFirst()] - arr[minQueue.peekFirst()] > num) {
                    flag = false;
                    break;
                }
                j++;
                flag = true;
            }
            res += j - i;
            if (!maxQueue.isEmpty() && maxQueue.peekFirst() == i) {
                maxQueue.pollFirst();
            }
            if (!minQueue.isEmpty() && minQueue.peekFirst() == i) {
                minQueue.pollFirst();
            }
            i++;
        }
        return res;
    }
}
