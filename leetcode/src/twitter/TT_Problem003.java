package twitter;

/*
 * Restocking the warehouse
 */
public class TT_Problem003 {
    public static void main(String[] args) {
        int[][] arrs = {{6,1,2,1},{1,2,3,2,1}};
        int[] targets = {100, 4};

        for (int i = 0; i < arrs.length; i++) {
            int[] arr = arrs[i];
            int target = targets[i];
            System.out.println(solve(arr, target));
        }
    }

    private static int solve(int[] arr, int target) {
        int sum = 0;
        for (int j : arr) {
            if (sum > target) {
                break;
            }
            sum += j;
        }

        return Math.abs(sum - target);
    }
}
