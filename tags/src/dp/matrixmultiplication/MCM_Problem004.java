package dp.matrixmultiplication;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Egg Dropping using Memoization Optimization
 *
 * Problem statement: You are given N floor and K eggs. You have to minimize the number of times you have to drop the eggs to find the critical floor where critical floor means the floor beyond which eggs start to break. Assumptions of the problem:
 *
 * If egg breaks at ith floor then it also breaks at all greater floors.
 * If egg does not break at ith floor then it does not break at all lower floors.
 * Unbroken egg can be used again.
 * Note: You have to find minimum trials required to find the critical floor not the critical floor.
 *
 * Example:
 * Input:
 *     4
 *     2
 *
 *     Output:
 *     Number of trials when number of eggs is 2 and number of floors is 4: 3
 *
 * PROBLEM STATEMENT LINK: https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1
 */
public class MCM_Problem004 {
    static int[][] dp = new int[51][51];
    public static void main(String[] args) {
        int[] es = {1, 2, 2};
        int[] fs = {2, 10, 4};

        for (int i = 0; i < es.length; i++) {
            int e = es[i];
            int f = fs[i];

            for (int[] d: dp) {
                Arrays.fill(d, -1);
            }
            System.out.println(solve(e, f));
        }
    }

    private static int solve(int e, int f) {
        // If the building does not have any floors, then zero attempts will be required as the eggs will not break
        if (f == 0) {
            return 0;
        }

        // If only one egg is given, then in the worst case, we will have to check whether the egg is breaking or not from each floor
        if (e == 1) {
            return f;
        }

        if (dp[e][f] != -1) {
            return dp[e][f];
        }

        int min = Integer.MAX_VALUE;
        for (int k = 1; k <=f; k++) {

            // Here, we are assuming that if base problem has not been solved, then the initial 2 subproblems
            // have not been solved either. This can further be optimized to check whether these problems have already
            // been solved or not

            // Unoptimized
            // int temp = 1 + Math.max(solve(e - 1, k - 1), solve(e, f - k));

            // Optimized
            int low = 0, high = 0;
            if (dp[e - 1][k - 1] != -1) {
                low = dp[e - 1][k - 1];
            } else {
                low = solve(e - 1, k - 1);
                dp[e - 1][k - 1] = low;
            }

            if (dp[e][f - k] != -1) {
                high = dp[e][f - k];
            } else {
                high = solve(e, f - k);
                dp[e][f - k] = high;
            }

            // Here, Math.max() because we need to find the critical floor. Critical means that the highest floor/threshold floor
            // from which the egg can be dropped without breaking
            int temp = 1 + Math.max(low, high);
            min = Math.min(min, temp);
        }
        return dp[e][f] = min;
    }
}
