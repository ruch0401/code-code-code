package dp.matrixmultiplication;

import java.util.HashMap;
import java.util.Map;

/*
 * Evaluate Expression To True-Boolean Parenthesization Memoized
 * Given a boolean expression with following symbols.
 * Symbols
 *     'T' --- true
 *     'F' --- false
 * And following operators filled between symbols
 * Operators
 *     &   --- boolean AND
 *     |   --- boolean OR
 *     ^   --- boolean XOR
 * Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
 * Example:
 * Input: symbol[]    = {T, F, T}
 *        operator[]  = {^, &}
 * Output: 2
 * The given expression is "T ^ F & T", it evaluates true
 * in two ways "((T ^ F) & T)" and "(T ^ (F & T))"
 *
 * PROBLEM STATEMENT LINK: https://practice.geeksforgeeks.org/problems/boolean-parenthesization5610/1#
 */
public class MCM_Problem003 {
    static Map<String, Integer> hm = new HashMap<>();

    public static void main(String[] args) {
        int[] Ns = {7, 5};
        String[] ss = {"T|T&F^T", "T^F|F"};

        for (int x = 0; x < Ns.length; x++) {
            int n = Ns[x];
            String s = ss[x];

            int i = 0;
            int j = n - 1;
            hm.clear();
            System.out.println(solve(s, i, j, true));
        }
    }

    private static int solve(String s, int i, int j, boolean isTrue) {
        if (i > j)
            return 0;

        if (i == j) {
            if (isTrue) {
                return (s.charAt(i) == 'T') ? 1 : 0;
            } else {
                return (s.charAt(i) == 'F') ? 1 : 0;
            }
        }

        String temp = i + "";
        temp += " ";
        temp += j;
        temp += " ";
        temp += isTrue;
        if (hm.containsKey(temp)) {
            return hm.get(temp);
        }

        int ans = 0;
        for (int k = i + 1; k <= j - 1; k++) {
            int lt = solve(s, i, k - 1, true);
            int lf = solve(s, i, k - 1, false);
            int rt = solve(s, k + 1, j, true);
            int rf = solve(s, k + 1, j, false);

            if (s.charAt(k) == '&') {
                if (isTrue) {
                    ans += lt * rt;
                } else {
                    ans += lt * rf + lf * rt + lf * rf;
                }
            } else if (s.charAt(k) == '|') {
                if (isTrue) {
                    ans += lt * rf + lf * rt + lt * rt;
                } else {
                    ans += lf * rf;
                }
            } else if (s.charAt(k) == '^') {
                if (isTrue) {
                    ans += lt * rf + lf * rt;
                } else {
                    ans += lf * rf + lt * rt;
                }
            }
        }
        hm.put(temp, ans);
        return hm.get(temp);
    }
}
