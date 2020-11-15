package cn.xiaozhg.code.chapter1;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 最大子矩阵中1的个数
 * */
public class MaxRecSize {
    public int maxRecSize(int[][] map) {
        int maxSize = 0;
        int[] lineHeight = new int[map[0].length];
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 0) {
                    lineHeight[j] = 0;
                } else {
                    lineHeight[j] += map[i][j];
                }
            }
            int curSize = getNearLessArr(lineHeight);
            if (curSize > maxSize) {
                maxSize = curSize;
            }
        }
        return maxSize;
    }

    public int getNearLessArr(int[] heights) {
        LinkedList<LinkedList<Integer>> stack = new LinkedList<LinkedList<Integer>>();
        int maxSize = 0;
        for(int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek().get(0)] > heights[i]) {
                LinkedList<Integer> list = stack.pop();
                for (Integer j : list) {
                    int right = i;
                    int left = stack.isEmpty() ? -1 : stack.peek().peekLast();
                    int curSize = (right - left - 1) * heights[j];
                    if (curSize > maxSize) {
                        maxSize = curSize;
                    }
                }
            }
            if(!stack.isEmpty() && heights[stack.peek().get(0)] == heights[i]) {
                stack.peek().addLast(i);
            } else {
                LinkedList<Integer> list = new LinkedList<Integer>();
                list.addLast(i);
                stack.push(list);
            }
        }
        while (!stack.isEmpty()) {
            LinkedList<Integer> list = stack.pop();
            for(Integer j : list) {
                int right = heights.length;
                int left = stack.isEmpty() ? -1 : stack.peek().peekLast();
                int curSize = (right - left - 1) * heights[j];
                if (curSize > maxSize) {
                    maxSize = curSize;
                }
            }
        }
        return maxSize;
    }

    @Test
    public void test() {
        int[][] map = {
                {1,1,1,1,1,1,1},
                {1,1,0,1,0,0,0},
                {1,1,1,1,0,0,0}
        };
        System.out.println(maxRecSize(map));
    }
}
