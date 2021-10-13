package twitter;

import java.util.Arrays;
import java.util.Stack;

public class T_Problem003 {
    public static void main(String[] args) {
        int[][] arr = {{5, 1, 3, 4, 6, 2}, {2, 3, 1, 2, 4, 2}};
        for (int[] a : arr) {
            solve(a);
        }
    }

    private static void solve(int[] prices) {
        int[] tmp = new int[prices.length];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = prices[i];
        }
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            System.out.println(Arrays.toString(tmp));
            while (!s.isEmpty() && prices[s.peek()] >= prices[i]) {
                int pre = s.pop();
                tmp[pre] = prices[pre] - prices[i];
            }
            s.push(i);
        }
        int res = 0;
        for (int t : tmp)
            res += t;
        System.out.println(res);
        System.out.println(Arrays.toString(tmp));
    }
}
