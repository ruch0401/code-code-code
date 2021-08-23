import java.util.Scanner;

public class SortedUnsorted {
    public static void main(String[] args) {
        String isSorted = checkIfSorted(new int[]{1, 2, 3, 4, 5}, 1) ? "SORTED" : "UNSORTED";
        System.out.println(isSorted);
    }

    private static boolean checkIfSorted(int[] array, int index) {
        // base condition
        if (index >= array.length)
            return true;

        // work - will be followed by the recursive call - hence, TAIL recursion
        if (array[index] < array[index - 1]) {
            return false;
        }

        // recursive call
        return checkIfSorted(array, index + 1);
    }
}
