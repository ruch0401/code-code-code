/**
 * Problem Name: Sawtooth Array
 * Company Name: eBay
 * Platform: Code Signal Question 4
 */
public class Problem020 {
    public static void main(String[] args) {
        int[][] x = {{-1, -2, -3, -4, -5}, {1, 2, 1, 2, 1}, {1, 2, 3, 3, 5}, {1, 3, 5, 7, 9}};
        for (int[] arr : x) {
            System.out.println(solve(arr));
        }
    }

    public static int solve(int[] x) {
        for (int i = 0; i < x.length; i++) {
            x[i] = Math.abs(x[i]);
        }
        boolean flip = false;
        int[] dp = new int[x.length];
        dp[0] = 1;
        for (int i = 1; i < x.length; i++) {
            if (x[i] % 2 != x[i - 1] % 2) {
                flip = true;
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        int last = dp[x.length - 1];
        return (flip) ? last * (last + 1) / 2 : x.length;
    }
}
