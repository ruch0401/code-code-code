public class Problem018 {
    public static void main(String[] args) {
        int flagHeight = 8;
        int bigJump = 3;
        System.out.println(solve(flagHeight, bigJump));
    }

    private static int solve(int flagHeight, int bigJump) {
        int big = flagHeight / bigJump;
        int rem = flagHeight % bigJump;
        return big + rem;
    }
}
