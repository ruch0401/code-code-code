package dp.knapsack01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
 * Sum of subset differences
 * Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
 * If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
 *
 * Example:
 * Input:  arr[] = {1, 6, 11, 5}
 * Output: 1
 * Explanation:
 * Subset1 = {1, 5, 6}, sum of Subset1 = 12
 * Subset2 = {11}, sum of Subset2 = 11
 *
 * PROBLEM STATEMENT LINK: https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1
 */
public class DP_Problem005 {
    public static void main(String[] args) {
        int[][] set = {{1, 6, 11, 5}, {5, 6, 6, 5, 7, 4, 7, 6}};

        for (int[] arr : set) {
            System.out.println(sumOfSubsetDifferences(arr));
        }
    }

    private static int sumOfSubsetDifferences(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        System.out.println("sum: " + sum);

        int[] validSum = subsetSum(arr, sum);
        System.out.println("last: " + Arrays.toString(validSum));

        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= ((validSum.length % 2 == 0) ? validSum.length / 2 - 1 : validSum.length / 2); i++) {
            min = Math.min(min, sum - 2 * validSum[i]);
        }
        return min;
    }

    private static int[] subsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (boolean[] d: dp) {
            d[0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < dp[n].length; i++) {
            if (dp[n][i]) {
                ans.add(i);
            }
        }
        return ans.stream().mapToInt(e -> e).toArray();
    }
}
