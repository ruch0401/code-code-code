import java.util.ArrayList;
import java.util.List;

public class Problem007 {

    static List<List<Integer>> comps = new ArrayList<>();

    public static void allPathsSourceTarget(int[][] graphM) {
        int vtces = graphM.length - 1;
        ArrayList<Edge>[] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < graphM.length - 1; i++) {
            for (int j = 0; j < graphM[i].length; j++) {
                int v1 = i;
                int v2 = graphM[i][j];
                graph[v1].add(new Edge(v1, v2));
                System.out.println(graph[v1].toString());
            }
        }
    }


    private static class Edge {
        int src;
        int nbr;

        Edge (int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }

        public String toString() {
            return String.format("src: %d | dest: %d", src, nbr);
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2},{3},{3},{}};
        allPathsSourceTarget(graph);
    }
}
