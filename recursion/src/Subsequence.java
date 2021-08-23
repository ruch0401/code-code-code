import java.util.Scanner;

// This problem is similar to finding all the subsets problem
public class Subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string for which you want to find the subsequence: ");
        String s = sc.nextLine();

        String output = "";
        subsequence(s, output, 0);
    }

    private static void subsequence(String str, String op, int index) {
        if (index == str.length()) {
            System.out.println(op);
            return;
        }

        // element does not have to be included
        subsequence(str, op, index + 1);

        // element has to be included in the subsequence
        op += str.charAt(index);
        subsequence(str, op, index + 1);
    }
}
