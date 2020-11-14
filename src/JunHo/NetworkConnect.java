package JunHo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * jhChoi - 201110
 * 네트워크 연결
 */
public class NetworkConnect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertexCount = sc.nextInt();
        int edgeCount = sc.nextInt();
        List<Edge> graph = new ArrayList<>();
        DisjointSet set = new DisjointSet(vertexCount);

        for (int i = 0; i < edgeCount; i++) {
            graph.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(graph);
        int sum = 0;

        for (Edge n : graph) {
            if(!set.findParent(n.node[0],n.node[1])){
                sum+=n.cost;
                set.union(n.node[0],n.node[1]);
            }
        }

        System.out.println(sum);
    }

    /**
     * 간선의 정보
     * */
    static class Edge implements Comparable<Edge>{
        int node[] = new int[2];        // vertex 1, vertex 2의 정보
        int cost;                       // 간선 가중치

        public Edge(int a, int b, int cost) {
            node[0] = a;
            node[1] = b;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(cost,o.cost);
        }
    }

    /**
     * 상호배타적 그룹
     * */
    static class DisjointSet {
        int[] union;

        DisjointSet(int size) {
            union = new int[size + 1];

            for (int i = 1; i < union.length; i++) {
                union[i] = i;
            }
        }

        public int getParent(int child) {
            if (union[child] == child) return child;
            else return getParent(union[child]);
        }

        /**
         * 작은 쪽을 루트 노드로 삼고 union 합니다.
         */
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
