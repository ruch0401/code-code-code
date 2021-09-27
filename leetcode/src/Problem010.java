import java.util.Arrays;

public class Problem010 {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 1, 3, 7, -3};
        int k1 = 2;

        int[] arr2 = {-3, -6, 3, 6};
        int k2 = 1;

        int[] arr3 = {3, -5};
        int k3 = 1;

        int ans1 = solve(arr1, k1);
        int ans2 = solve(arr2, k2);
        int ans3 = solve(arr3, k3);

        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans3);
    }

    private static int solve(int[] arr, int k) {
        int n = arr.length;
        int rotate = n / 2;
        int windowSum = Integer.MIN_VALUE;
        int iterator = 0;
        int[] prefixSum = new int[2 * n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        for (int i = 0; i < n; i++) {
            prefixSum[i + n + 1] = prefixSum[i + n] + arr[i];
        }
        System.out.println(Arrays.toString(prefixSum));

        int currSum;
        while (iterator <= n / 2 - 1) {
            currSum = prefixSum[iterator + k] - prefixSum[iterator] + (prefixSum[iterator + rotate + k] - prefixSum[iterator + rotate]);
            windowSum = Math.max(windowSum, currSum);
            iterator += 1;
        }
        return windowSum;
    }
}