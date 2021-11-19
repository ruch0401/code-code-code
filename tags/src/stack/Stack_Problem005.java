package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
 * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days.
 * The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 * https://practice.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
 */
public class Stack_Problem005 {
    public static void main(String[] args) {
        int[][] arr = {{100, 80, 60, 70, 60, 75, 85}, {10, 4, 5, 90, 120, 80}};
        for (int[] a : arr) {
            System.out.println(Arrays.toString(stockSpanProblem(a, a.length)));
        }
    }

    private static class Pair {
        int number;
        int index;

        Pair(int number, int index) {
            this.number = number;
            this.index = index;
        }
    }

    private static int[] stockSpanProblem(int[] arr, int length) {
        List<Integer> list = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (stack.size() == 0) {
                list.add(-1);
            } else if (stack.peek().number > arr[i]) {
                list.add(stack.peek().index);
            } else if (stack.peek().number <= arr[i]) {
                while (stack.size() > 0 && stack.peek().number <= arr[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    list.add(-1);
                } else {
                    list.add(stack.peek().index);
                }
            }
            stack.push(new Pair(arr[i], i));
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < length; i++) {
            ans[i] = i - list.get(i);
        }
        return ans;
    }
}
