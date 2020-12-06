package JunHo.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * jhChoi - 201203
 * 백준 - 도시분할계획
 *
 */
public class Baek_UrbanDivPlan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int vertex = Integer.parseInt(input[0]);
        int edge = Integer.parseInt(input[1]);
        Union union = new Union(vertex);
        Queue<Edge> graph = new PriorityQueue<>();

        for (int i = 0; i < edge; i++) {
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            graph.offer(new Edge(a, b, weight));
        }

        int sum = 0;
        int count =0;
        while(count<vertex-2){
            Edge edges = graph.poll();
            if(!union.findParent(edges.vertexes[0], edges.vertexes[1])){
                union.union(edges.vertexes[0],edges.vertexes[1]);
                sum+= edges.weight;
                count++;
            }
        }

        System.out.println(sum);
    }

    static class Edge implements Comparable<Edge> {
        int[] vertexes = new int[2];
        int weight;

        Edge(int a, int b, int weight) {
            vertexes[0] = a;
            vertexes[1] = b;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
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
            if (a == b) return;
            else if (a > b) union[b] = a;
            else union[a] = b;
        }

        boolean findParent(int a, int b) {
            return getParent(a) == getParent(b);
        }
    }
}
