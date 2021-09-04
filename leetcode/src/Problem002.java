import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem002 {

    public static void main(String[] args) {
        minimumDifference(new int[]{9, 4, 1, 7}, 2);
    }

    public static int minimumDifference(int[] nums, int k) {
        String currentSubset = "";
        return minDiff(nums, k, 0, currentSubset);
    }

    static List<String> subsetsOfLengthK = new ArrayList<>();
    private static int minDiff(int[] nums, int k, int index, String currentSubset) {
        if (index >=  nums.length) {
            System.out.println(currentSubset);
            return 0;
        }

        minDiff(nums, k, index + 1, currentSubset);

        currentSubset += nums[index];
        if (currentSubset.length() == k)
            subsetsOfLengthK.add(currentSubset);
        minDiff(nums, k, index + 1, currentSubset);

        return getMin(subsetsOfLengthK);
    }

    private static int getMin(List<String> subsetsOfLengthK) {
        List<Integer> diffList = new ArrayList<>();
        int l = subsetsOfLengthK.size() - 1;
        diffList.add(Math.abs(Integer.parseInt(subsetsOfLengthK.get(0)) - Integer.parseInt(subsetsOfLengthK.get(l))));
        Collections.sort(diffList);
        return diffList.get(0);
    }
}
