package JunHo.done;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * jhChoi - 201110
 * 최소 신장 트리
 */
public class MinimumSpanningTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertexCount = sc.nextInt();
        int edgeCount = sc.nextInt();
        Union union = new Union(vertexCount);
        List<Edge> graph = new ArrayList<>();

        for (int i = 0; i < edgeCount; i++) {
            graph.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(graph);
        int sum = 0;

        for (Edge edge : graph) {
            if (!union.findParent(edge.node[0], edge.node[1])) {
                sum += edge.distance;
                union.union(edge.node[0], edge.node[1]);
            }
        }

        System.out.println(sum);

    }

    static class Edge implements Comparable<Edge> {
        int[] node = new int[2];
        int distance;

        Edge(int a, int b, int distance) {
            node[0] = a;
            node[1] = b;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(distance, o.distance);
        }
    }

    static class Union {
        int[] union;

        public Union(int vertex) {
            union = new int[vertex + 1];

            for (int i = 1; i < union.length; i++) {
                union[i] = i;
            }
        }

        int getParent(int x) {
            if (union[x] == x) return x;
            return union[x] = getParent(union[x]);
        }

        void union(int a, int b) {
            a = getParent(a);
            b = getParent(b);
            if (a < b) union[b] = a;
            else union[a] = b;
        }

        boolean findParent(int a, int b) {
            return getParent(a) == getParent(b);
        }
    }
}
