package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * Given an array of integers, find the closest (not considering distance, but value) smaller on left of every element.
 * If an element has no smaller on the left side, print -1.
 */
public class Stack_Problem003 {
    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};
        System.out.println(Arrays.toString(nextSmallerElementToLeft(arr, arr.length)));
    }

    private static int[] nextSmallerElementToLeft(int[] arr, int length) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (stack.size() == 0) {
                list.add(-1);
            } else if (stack.peek() < arr[i]) {
                list.add(stack.peek());
            } else if (stack.peek() >= arr[i]) {
                while (stack.size() > 0 && stack.peek() >= arr[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    list.add(-1);
                } else {
                    list.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        return list.stream().mapToInt(e -> e).toArray();
    }
}
