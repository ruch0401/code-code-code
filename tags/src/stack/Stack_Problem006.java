package stack;

import java.util.*;

public class Stack_Problem006 {
    public static void main(String[] args) {
        int[][] arr = {{6, 2, 5, 4, 5, 1, 6}, {10, 4, 5, 90, 120, 80}};
        for (int[] a : arr) {
            System.out.println(maximumAreaHistogram(a, a.length));
        }
    }

    private static int maximumAreaHistogram(int[] a, int length) {
        int[] left = nextSmallerLeft(a, length);
        int[] right = nextSmallerRight(a, length);
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
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
