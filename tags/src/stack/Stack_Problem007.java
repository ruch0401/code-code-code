package stack;

import java.util.*;

/*
 * Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s.
 * Example:
 *
 * Input :   0 1 1 0
 *           1 1 1 1
 *           1 1 1 1
 *           1 1 0 0
 *
 * Output :  1 1 1 1
 *           1 1 1 1
 */
public class Stack_Problem007 {
    public static void main(String[] args) {
        int[][] arr =
                {
                        {0,1,1,0},
                        {1,1,1,1},
                        {1,1,1,1},
                        {1,1,0,0}
                };
        System.out.println(maximumAreaRectangleInBinaryMatrix(arr));
    }

    private static int maximumAreaRectangleInBinaryMatrix(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int[] global = new int[arr[0].length];
        for (int[] a: arr) {
            for (int i = 0; i < a.length; i++) {
                global[i] = (a[i] == 0) ? 0 : global[i] + a[i];
            }
            max = Math.max(max, maximumAreaHistogram(global, global.length));
        }
        return max;
    }

    private static int maximumAreaHistogram(int[] a, int length) {
        int[] left = nextSmallerLeft(a, length);
        int[] right = nextSmallerRight(a, length);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, a[i] * (right[i] - left[i] - 1));
        }
        return max;
    }

    private static int[] nextSmallerLeft(int[] arr, int length) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int pseudoindex = -1;
        for (int i = 0; i < length; i++) {
            if (stack.size() == 0) {
                list.add(pseudoindex);
            } else if (arr[stack.peek()] < arr[i]) {
                list.add(stack.peek());
            } else if (arr[stack.peek()] >= arr[i]) {
                while (stack.size() > 0 && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    list.add(pseudoindex);
                } else {
                    list.add(stack.peek());
                }
            }
            stack.push(i);
        }
        return list.stream().mapToInt(e -> e).toArray();
    }

    private static int[] nextSmallerRight(int[] arr, int length) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int pseudoindex = length;
        for (int i = length - 1; i >= 0; i--) {
            if (stack.size() == 0) {
                list.add(pseudoindex);
            } else if (arr[stack.peek()] < arr[i]) {
                list.add(stack.peek());
            } else if (arr[stack.peek()] >= arr[i]) {
                while (stack.size() > 0 && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    list.add(pseudoindex);
                } else {
                    list.add(stack.peek());
                }
            }
            stack.push(i);
        }
        Collections.reverse(list);
        return list.stream().mapToInt(e -> e).toArray();
    }
}
