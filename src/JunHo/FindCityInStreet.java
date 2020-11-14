package JunHo;

import java.io.*;
import java.util.*;

public class FindCityInStreet {
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

        boolean hasDistance = false;
        int[] distance = graph.bfs(X);

        for (int i = 0; i < distance.length; i++) {
            if(K == distance[i]){
                hasDistance = true;
                bw.write(i+"\n");
            }
        }

        if(!hasDistance){
            bw.write(-1+"");
        }

        bw.flush();
    }


    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    public static class Graph {
        ArrayList<Integer>[] listGraph;

        public Graph(int size) {
            size++;
            this.listGraph = new ArrayList[size];

            for (int i = 0; i < size; i++) {
                listGraph[i] = new ArrayList<>();
            }
        }

        public void put(int x, int y) {
            listGraph[x].add(y);
        }

        public int[] bfs(int startCity) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(startCity);
            int[] dist = new int[listGraph.length];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[startCity] = 0;

            while (!q.isEmpty()) {
                int city = q.poll();

                for (int i = 0; i < listGraph[city].size(); i++) {
                    int conCity = listGraph[city].get(i);

                    if (dist[conCity] > dist[city] + 1) {
                        dist[conCity] = dist[city] + 1;
                        q.add(conCity);
                    }
                }
            }

            return dist;
        }
    }
}
