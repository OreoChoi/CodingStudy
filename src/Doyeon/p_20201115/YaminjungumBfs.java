package Doyeon.p_20201115;

import java.util.*;

/**
 * [다익스트라] 그대, 그머가되어
 * 최단거리 찾는 문제이면서 간선의 가중치가 다 1이므로 BFS를 이용해서 최단거리 찾을수도 있음
 * 이거는 양방향 그래프이므로 양방향 처리
 * https://www.acmicpc.net/problem/14496
 */
public class YaminjungumBfs {
    static class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
    private static void dijkstra(int[] shortArr, List<Integer>[] adjList, int start) {
        Queue<Node> queue = new LinkedList<>();
        // 시작 위치는 거리가 0
        queue.add(new Node(start, 0));
        shortArr[start] = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int index = node.index;
            int distance = node.distance;
            for (int n : adjList[index]) {
                // 방문 안한 노드인 경우
                if (shortArr[n] == -1) {
                    // 현재 거리에 + 1
                    shortArr[n] = distance + 1;
                    queue.add(new Node(n, distance + 1));
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
