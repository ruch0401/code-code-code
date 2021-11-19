package stack;

import java.util.Stack;

public class Stack_Problem010 {
    public int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        Stack_Problem010 p10 = new Stack_Problem010();
        int[][] arr = {{18, 19, 29, 15, 16}};
        for (int[] a: arr) {
            while (!p10.isEmpty(s)) {
                p10.pop(s);
            }

            while (!p10.isFull(s, a.length)) {
                for (int elem : a) {
                    p10.push(elem, s);
                }
            }
            System.out.println(p10.min(s));
        }
    }
    public void push(int a, Stack<Integer> s) {
        if (s.size() == 0) {
            s.push(a);
            minValue = a;
        } else {
            if (a >= minValue) {
                s.push(a);
            } else {
                s.push(2 * a - minValue);
                minValue = a;
            }
        }
    }

    public int pop(Stack<Integer> s) {
        if (s.size() == 0) {
            return -1;
        }
        int ans = 0;
        if (s.peek() >= minValue) {
            s.pop();
        } else {
            ans = 2 * minValue - s.peek();
            s.pop();
        }
        return ans;
    }

    public int min(Stack<Integer> s) {
        if (s.size() == 0) {
            return -1;
        }
        return minValue;
    }

    public boolean isFull(Stack<Integer> s, int n) {
        return s.size() == n;
    }

    public boolean isEmpty(Stack<Integer> s) {
        return s.size() == 0;
    }
}
