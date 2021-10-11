package twitter;

/*
* Do They Belong?
* Hackerrank
* Twitter | Goldmann Sachs
* Check if triangle is degenerate and whether a point lies inside/on the triangle or not
*
 */
public class T_Problem002 {
    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int x1 = 0, y1 = 0, x2 = 2, y2 = 0, x3 = 4, y3 = 0, xp = 2, yp = 0, xq = 4, yq = 0; // should be 0
//        int x1 = 3, y1 = 1, x2 = 7, y2 = 1, x3 = 5, y3 = 5, xp = 3, yp = 1, xq = 0, yq = 0; // should be 1
//        int x1 = 3, y1 = 1, x2 = 7, y2 = 1, x3 = 5, y3 = 5, xp = 1, yp = 1, xq = 4, yq = 3; // should be 2
//        int x1 = 3, y1 = 1, x2 = 7, y2 = 1, x3 = 5, y3 = 5, xp = 5, yp = 2, xq = 6, yq = 3; // should be 3
//        int x1 = 3, y1 = 1, x2 = 7, y2 = 1, x3 = 5, y3 = 5, xp = 1, yp = 1, xq = 2, yq = 2; // should be 4

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);
        Point p3 = new Point(x3, y3);

        Point p = new Point(xp, yp);
        Point q = new Point(xq, yq);

        System.out.println(solve(p1, p2, p3, p, q));
    }

    private static int solve(Point p1, Point p2, Point p3, Point p, Point q) {
        boolean isPInside = isInside(p1, p2, p3, p);
        boolean isQInside = isInside(p1, p2, p3, q);

        if (!isNonDegenerate(p1, p2, p3)) return 0;
        else if (isPInside && !isQInside) return 1;
        else if (!isPInside && isQInside) return 2;
        else if (isPInside) return 3;
        else return 4;
    }

    private static boolean isNonDegenerate(Point p1, Point p2, Point p3) {
        return distance(p1, p2) + distance(p2, p3) > distance(p1, p3) &&
                distance(p2, p3) + distance(p1, p3) > distance(p1, p2) &&
                distance(p1, p2) + distance(p1, p3) > distance(p2, p3);
    }


    private static double distance(Point p1, Point p2) {
        return Math.sqrt((p1.y - p2.y) * (p1.y - p2.y) + (p1.x - p2.x) * (p1.x - p2.x));
    }

    private static boolean isInside(Point p1, Point p2, Point p3, Point p) {
        double aAll = area(p1, p2, p3);
        double a1 = area(p1, p2, p);
        double a2 = area(p2, p3, p);
        double a3 = area(p1, p3, p);
        System.out.printf("%s = %s + %s + %s%n", aAll, a1, a2, a3);
        return aAll == a1 + a2 + a3;
    }

    private static double area(Point p1, Point p2, Point p3) {
        return Math.abs((p1.x * (p2.y - p3.y) + p2.x * (p3.y - p1.y) + p3.x * (p1.y - p2.y)) / 2);
    }
}
