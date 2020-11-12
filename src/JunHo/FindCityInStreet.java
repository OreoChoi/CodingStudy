package JunHo;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class FindCityInStreet {
    static int[] visit;
    static int[] from;
    static int X;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer input = new StringTokenizer(br.readLine());
        int N = parseInt(input.nextToken());   //도시 갯수
        int M = parseInt(input.nextToken());   //도로 갯수
        K = parseInt(input.nextToken());   //거리 정보
        X = parseInt(input.nextToken());   //출발 도시 번호
        Graph graph = new Graph(N);

        for (int i = 0; i < M; i++) {
            StringTokenizer edge = new StringTokenizer(br.readLine());
            graph.put(parseInt(edge.nextToken()), parseInt(edge.nextToken()));
        }

        graph.bfs(X);

        boolean hasK = false;
        for (int i = 1; i <= N; i++) {
            if (visit[i] != 0) {
                if (tracing(i) == K) {
                    hasK = true;
                    bw.write(i + "\n");
                }
            }
        }

        if (!hasK) {
            bw.write(-1 + "");
        }

        bw.flush();
    }

    public static int tracing(int node) {
        int count = 0;
        while (node != X) {
            node = from[node];
            count++;
        }

        return count;
    }

    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    public static class Graph {
        ArrayList<Integer>[] listGraph;

        public Graph(int size) {
            size++;
            this.listGraph = new ArrayList[size];
            visit = new int[size];
            from = new int[size];

            for (int i = 0; i < size; i++) {
                listGraph[i] = new ArrayList<>();
            }
        }

        public void put(int x, int y) {
            listGraph[x].add(y);
        }

        public void bfs(int startCity) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(startCity);

            while (!queue.isEmpty()) {
                int city = queue.poll();

                for (int i = 0; i < listGraph[city].size(); i++) {
                    int conCity = listGraph[city].get(i);

                    if (visit[conCity] == 0) {
                        visit[conCity] = visit[city] + 1;
                        from[conCity] = city;
                        queue.offer(conCity);
                    }
                }
            }
        }
    }
}
