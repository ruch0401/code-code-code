package twitter;

public class TT_Problem005 {
    public static void main(String[] args) {
        System.out.println(canReach(1,1,3,5));
    }

    private static boolean canReach(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (sx == tx && sy == ty) {
                return true;
            } else if (ty == sy) {
                return (tx - sx) % ty == 0;
            } else if (tx == sx) {
                return (ty - sy) % tx == 0;
            } else if (tx > ty) {
                tx = tx % ty;
            } else {
                ty = ty % tx;
            }
        }
        return false;
    }
}
