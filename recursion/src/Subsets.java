public class Subsets {

    public static void main(String[] args) {
        String currentSubset = "";
        printSubsets(new int[]{1, 2, 3}, currentSubset, 0);
    }

    private static void printSubsets(int[] input, String currentSubset, int index) {
        if (index >= input.length) {
            System.out.println(currentSubset);
            return;
        }

        // element does not have to be included
        printSubsets(input, currentSubset, index + 1);

        // element needs to be included in the output array (Arraylist in this case)
        currentSubset += input[index];
        printSubsets(input, currentSubset, index + 1);
    }
}
