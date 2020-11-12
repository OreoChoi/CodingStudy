package JunHo;

import java.io.*;
import java.util.*;

/**
 * jhChoi - 201112
 * 그대, 그머가 되어
 */
public class StringSubstitution {
    static int source;
    static int destination;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(br.readLine());

        source = parseInt(input.nextToken());
        destination = parseInt(input.nextToken());
        input = new StringTokenizer(br.readLine());
        int N = parseInt(input.nextToken());
        int M = parseInt(input.nextToken());
        Graph graph = new Graph(N);

        for (int i = 0; i < M; i++) {
            input = new StringTokenizer(br.readLine());
            graph.put(parseInt(input.nextToken()), parseInt(input.nextToken()));
        }

        graph.bfs(source);
    }

    public static class Graph {
        ArrayList<Integer>[] listGraph;

        public Graph(int size) {
            size++;
            this.listGraph = new ArrayList[size];

            for (int i = 0; i < listGraph.length; i++) {
                listGraph[i] = new ArrayList<>();
            }
        }

        public void put(int a, int b) {
            listGraph[a].add(b);
            listGraph[b].add(a);
        }

        public void bfs(int source) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(source);
            int[] dist = new int[listGraph.length];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[source] = 0;

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int i = 0; i < listGraph[now].size(); i++) {
                    int next = listGraph[now].get(i);

                    if (dist[next] > dist[now] + 1) {
                        dist[next] = dist[now] + 1;
                        q.add(next);
                    }
                }
            }
            System.out.println(dist[destination] == Integer.MAX_VALUE ? -1 : dist[destination]);
        }
    }

    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }
}
