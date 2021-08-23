import java.util.Scanner;

public class Jumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of stairs: ");
        int stairCount = sc.nextInt();

        int jumps = jumps(stairCount);
        System.out.printf("Number of ways that stair %d can be reached is %d", stairCount, jumps);
    }

    private static int jumps(int stairCount) {
        if (stairCount < 0)
            return 0;
        if (stairCount == 0 || stairCount == 1)
            return 1;
        return jumps(stairCount - 1) + jumps(stairCount - 2) + jumps(stairCount - 3);
    }
}
