package stack;

import java.util.*;

/*
 * Given an array, print the Next Greater Element (NGE) for every element.
 * The Next greater Element for an element x is the first greater element on the right side of x in array.
 * Elements for which no greater element exist, consider next greater element as -1.
 * Refer : https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
 */
public class Stack_Problem001 {
    public static void main(String[] args) {
        long[] arr = {1,3,2,4};
        System.out.println(Arrays.toString(nextLargerElement(arr, arr.length)));
    }

    public static long[] nextLargerElement(long[] arr, int n)
    {
        Stack<Long> stack = new Stack<>();
        List<Long> list = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.size() == 0) {
                list.add(-1L);
            } else if (stack.peek() > arr[i]) {
                list.add(stack.peek());
            } else if (stack.size() > 0 && stack.peek() <= arr[i]) {
                while (stack.size() > 0 && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    list.add(-1L);
                } else {
                    list.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }

        long[] ans = new long[list.size()];
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
