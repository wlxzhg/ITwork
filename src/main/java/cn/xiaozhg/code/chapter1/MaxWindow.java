package cn.xiaozhg.code.chapter1;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 给定一个数组和一个窗口宽度。求窗口内的最大值。要求时间复杂度为O(n)
 * */
public class MaxWindow {
    public int[] getMaxWindow(int[] nums,int w) {
        if (nums == null || nums.length == 0 || w > nums.length || w <= 0) {
            return null;
        }
        int[] maxWindow = new int[nums.length - w + 1];
        int index = 0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if(i - queue.peekFirst() == w) {
                queue.pollFirst();
            }
            if(i >= w - 1) {
                maxWindow[index++] = nums[queue.peekFirst()];
            }
        }
        return maxWindow;
    }

    @Test
    public void test() {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        int[] maxWindow = getMaxWindow(arr, w);
        System.out.println(Arrays.toString(maxWindow));
    }
}
