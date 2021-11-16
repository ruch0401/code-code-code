package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * Given an array of integers, find the closest (not considering distance, but value) greater on left of every element.
 * If an element has no greater on the left side, print -1.
 */
public class Stack_Problem002 {
    public static void main(String[] args) {
        long[] arr = {1,3,2,4};
        System.out.println(Arrays.toString(nextLargestElementToLeft(arr, arr.length)));
    }

    private static long[] nextLargestElementToLeft(long[] arr, int length) {
        Stack<Long> stack = new Stack<>();
        List<Long> list = new ArrayList<>();
        for (long l : arr) {
            if (stack.size() == 0) {
                list.add(-1L);
            } else if (stack.peek() > l) {
                list.add(stack.peek());
            } else if (stack.peek() <= l) {
                while (stack.size() > 0 && stack.peek() <= l) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    list.add(-1L);
                } else {
                    list.add(stack.peek());
                }
            }
            stack.push(l);
        }
        return list.stream().mapToLong(e -> e).toArray();
    }
}
