package tiktok;

/*
 * https://leetcode.com/problems/gas-station/submissions/
 * https://leetcode.com/discuss/interview-question/406135/ibm-oa-2019-aladdin-and-his-carpet-backend | Version asked in OA
 */
public class TT_Problem007 {
    public static void main(String[] args) {
        int[] magic = {2,4,5,2};
        int[] dist = {4,3,1,3};
        System.out.println(getStartPoint(magic, dist));
    }

    private static int getStartPoint(int[] magic, int[] dist) {
        int diff = 0, d = 0, index = 0;
        for (int i = 0; i < magic.length; i++) {
            diff += magic[i] - dist[i];
            if (diff < 0) {
                index = i + 1;
                d += diff;
                diff = 0;
            }
        }

        return (d + diff >= 0) ? index : -1;
    }
}
