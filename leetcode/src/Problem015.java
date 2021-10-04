import java.util.Arrays;

public class Problem015 {
    public static void main(String[] args) {
        int[] arr1 = {-2, -1, -2, 5};
        int lowerBound1 = 3;
        int upperBound1 = 10;

        int[] arr2 = {-1, -3, 2};
        int lowerBound2 = 2;
        int upperBound2 = 8;

        int[] arr3 = {1, 2};
        int lowerBound3 = 3;
        int upperBound3 = 4;

        System.out.println(countAnalogousArraysNew(arr1, lowerBound1, upperBound1));
        System.out.println(countAnalogousArraysNew(arr2, lowerBound2, upperBound2));
        System.out.println(countAnalogousArraysNew(arr3, lowerBound3, upperBound3));
    }

    public static int countAnalogousArrays(int[] consecutiveDifference, int lowerBound, int upperBound) {
        int maxDiff = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;
        int runningSum = 0;

        for (int diff: consecutiveDifference) {
            runningSum += diff;

            if (runningSum > maxDiff)
                maxDiff = runningSum;

            if (runningSum < minDiff)
                minDiff = runningSum;
        }
        System.out.println("MaxDiff: " + maxDiff + "\tMinDiff: " + minDiff);
        int maxValidUpperBound = Math.min(upperBound + minDiff, upperBound);
        int minValidLowerBound = Math.max(lowerBound + maxDiff, lowerBound);

        if(maxValidUpperBound > minValidLowerBound) {
            return maxValidUpperBound - minValidLowerBound + 1;
        } else {
            return 0;
        }
    }

    public static int countAnalogousArraysNew(int[] consecutiveDifference, int lowerBound, int upperBound) {
        int len = consecutiveDifference.length;
        int[] onearray = new int[len + 1];
        onearray[0] = lowerBound;
        int i = 1;
        for (int elem: consecutiveDifference) {
            onearray[i] = onearray[i - 1] - elem;
            i++;
        }
        System.out.println(Arrays.toString(onearray));
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int elem: onearray) {
            if (elem > max) max = elem;
            if (elem < min) min = elem;
        }
        int sum = (min - lowerBound) + (upperBound - max);
        return sum > 0 ? sum + 1 : 0;
    }
}
