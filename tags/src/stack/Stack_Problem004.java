package stack;

import java.util.*;

public class Stack_Problem004 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nextSmallerElementToRight(arr, arr.length)));
    }

    private static int[] nextSmallerElementToRight(int[] arr, int length) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = length - 1; i >= 0; i--) {
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
        Collections.reverse(list);
        return list.stream().mapToInt(e -> e).toArray();
    }
}
