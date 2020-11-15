package cn.xiaozhg.code.chapter1;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 单调栈结构
 * 找到每个数组元素左右两边第一个比它小的元素的下标，要求时间复杂度为O(n)
 * 其中数组中没有重复元素.
 * 思路：使用单调栈结构，栈保持单调递增。遇到使栈无法递增的元素时弹出栈顶元素，
 * 同时确定栈顶元素的结果。
 * 进阶：数组中可能包含重复元素。栈的每个元素变成List
 * */
public class NearLessNoRepeat {
    public int[][] getNearLessNoRepeat(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[][] result = new int[nums.length][2];
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int j = stack.pop();
                result[j][1] = i;
                result[j][0] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int j = stack.pop();
            result[j][1] = -1;
            result[j][0] = stack.isEmpty() ? -1 : stack.peek();
        }

        return result;
    }

    @Test
    public void test() {
        int[] nums = {3, 4, 1, 5, 6, 2, 7};
        int[][] result = getNearLessNoRepeat(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

    }
}
