package Doyeon.p_20201115;

import java.util.*;

/**
 * [다익스트라] 그대, 그머가되어
 * 다익스트라 최단 거리 알고리즘을 이용해서 해결
 * https://www.acmicpc.net/problem/14496
 */
public class YaminjungumDijkstra {
    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        // 거리 짧은 순으로 정렬
        @Override
        public int compareTo(Node o) {
            if (this.distance < o.distance) {
                return -1;
            }
            return 1;
        }
    }
    private static void dijkstra(int[] shortArr, List<Integer>[] adjList, int start) {
        Queue<Node> queue = new PriorityQueue<>();
        // 시작 위치는 거리가 0
        queue.add(new Node(start, 0));
        shortArr[start] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int index = node.index;
            int distance = node.distance;
            if (shortArr[index] != -1 && shortArr[index] < distance) {
                continue;
            }
            for (int n : adjList[index]) {
                int cost = shortArr[index] + 1;
                if (shortArr[n] == -1 || cost < shortArr[n]) {
                    shortArr[n] = cost;
                    queue.add(new Node(n, cost));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 최단거리배열
        int[] shortArr = new int[n+1];
        for (int i = 1; i < shortArr.length; i++) {
            shortArr[i] = -1;
        }
        // 인접리스트
        List<Integer>[] adjList = new List[n+1];
        for (int i = 1; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            // 양방향
            adjList[x].add(y);
            adjList[y].add(x);
        }
        // 다익스트라
        dijkstra(shortArr, adjList, a);
        System.out.println(shortArr[b]);
    }
}
