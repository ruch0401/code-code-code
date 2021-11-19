package stack;

import java.util.Stack;

/*
 * Design a data-structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull() and
 * an additional operation getMin() which should return minimum element from the SpecialStack.
 * Your task is to complete all the functions, using stack data-Structure.
 * https://practice.geeksforgeeks.org/problems/special-stack/1
 */
public class Stack_Problem009 {
    public static Stack<Integer> ss = new Stack<>();

    public static void main(String[] args) {

    }

    public void push(int a, Stack<Integer> s) {
        s.push(a);
        if (ss.size() == 0 || a <= ss.peek()) {
            ss.push(a);
        }
    }

    public int pop(Stack<Integer> s) {
        if (s.size() == 0) {
            return -1;
        }
        int ans = s.pop();
        if (ss.peek() == ans) {
            ss.pop();
        }
        return ans;
    }

    public int min(Stack<Integer> s) {
        if (ss.size() == 0) return -1;
        else {
            return ss.peek();
        }
    }

    public boolean isFull(Stack<Integer> s, int n) {
        return s.size() == n;
    }

    public boolean isEmpty(Stack<Integer> s) {
        return s.size() == 0;
    }
}
