package dp.matrixmultiplication;

import java.util.Arrays;

/*
 * Matrix Chain Multiplication using Recursion
 *  Given a sequence of matrices, find the most efficient way to multiply these matrices together. The problem is not actually to  perform the multiplications, but merely to decide in which order to perform the multiplications.
 *
 * PROBLEM STATEMENT LINK: https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1#
 *
 * Step to follow -
 * 1. Find suitable values of i and j
 * 2. Find the base case and handle it
 * 3. Find the looping scheme for k
 * 4. Calculate the temporary answer and find max/min/sum/diff from these temp answers as per the given question
 */
public class MCM_Problem001 {
    static int[][] dp = new int[101][101];
    public static void main(String[] args) {
        int[][] arrs = {{40, 20, 30, 10, 30}, {10, 30, 5, 60}};
        int[] Ns = {5, 4};

        for (int i = 0; i < arrs.length; i++) {
            int[] arr = arrs[i];
            int n = Ns[i];

            for (int[] d: dp) {
                Arrays.fill(d, -1);
            }
            System.out.println(matrixMultiplication(arr, n));
        }
     }

    private static int matrixMultiplication(int[] arr, int n) {
        int i = 1;
        int j = n - 1;
        System.out.println("Using Recursion: " + solveRecursion(arr, i, j));
        System.out.println("Using Recursion + Memoization: " + solveRecursion(arr, i, j));
        return solveMemoization(arr, i, j);
    }

    private static int solveMemoization(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solveMemoization(arr, i, k) + solveMemoization(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
            min = Math.min(temp, min);
        }
        dp[i][j] = min;
        return dp[i][j];
    }

    private static int solveRecursion(int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = solveRecursion(arr, i, k) + solveRecursion(arr, k + 1, j) + (arr[i - 1] * arr[k] * arr[j]);
            min = Math.min(temp, min);
        }
        return min;
    }
}
