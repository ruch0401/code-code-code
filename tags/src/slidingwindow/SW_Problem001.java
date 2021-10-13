package slidingwindow;

/*
 * Maximum sum subarray of size k
 * Technique: Sliding Window [FIXED]
 */
public class SW_Problem001 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4,5}};
        int k = 2;
        for (int[] a: arr) {
            System.out.println(solve(a, k));
        }
    }

    private static int solve(int[] a, int k) {
        // Initialization Phase
        int i = 0, j = 0, sum = 0, max = Integer.MIN_VALUE;
        int len = a.length;

        // Looping condition to check whether the end of array has been reached
        // i -> start of window
        // j -> end of window
        while (j < len) {
            // calculation
            sum += a[j];

            // window size is not reached
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {

                // perform some calculations as window size has been reached
                max = Math.max(max, sum);
                sum -= a[i];

                // slide the window a.k.a. update the start and end pointers
                i++;
                j++;
            }
        }
        return max;
    }
}
