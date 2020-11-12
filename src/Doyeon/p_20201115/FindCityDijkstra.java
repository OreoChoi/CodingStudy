package Doyeon.p_20201115;

import java.util.*;

/**
 * [다익스트라] 특정 거리의 도시 찾기
 * 다익스트라 최단 거리 알고리즘을 이용해서 해결.
 * 우선순위 큐를 같이 사용함.
 * https://www.acmicpc.net/problem/18352
 */
public class FindCityDijkstra {
    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        // 거리값이 작은 순으로 정렬
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
        queue.add(new Node(start, 0));
        shortArr[start] = 0;
        while (!queue.isEmpty()) {
            // 현재 노드
            Node node = queue.poll();
            int index = node.index;
            int distance = node.distance;
            // 이미 최단거리 계산이 되어 있으면 처리 X
            if (shortArr[index] != -1 && shortArr[index] < distance) {
                continue;
            }
            // 인접한 노드들을 돌면서
            for (int n : adjList[index]) {
                // 현재 노드의 거리에 + 1
                int cost = shortArr[index] + 1;
                // 그 거리값이 더 작은 경우
                if (shortArr[n] == -1 || cost < shortArr[n]) {
                    // 최단거리배열에 업데이트
                    shortArr[n] = cost;
                    // 큐에 넣어줌
                    queue.add(new Node(n, cost));
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int x = sc.nextInt();
        // 최단거리 배열 (노드 1부터 시작이니까 n+1)
        // 초기값을 -1로
        int[] shortArr = new int[n+1];
        for (int i = 1; i < shortArr.length; i++) {
            shortArr[i] = -1;
        }
        // 인접리스트 (거리는 다 1이니까 따로 저장 X)
        List<Integer>[] adjList = new List[n+1];
        for (int i = 1; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            adjList[sc.nextInt()].add(sc.nextInt());
        }
        boolean isExist = false;
        dijkstra(shortArr, adjList, x);
        for (int i = 1; i < shortArr.length; i++) {
            if (i == x) {
                continue;
            }
            if (shortArr[i] == k) {
                isExist = true;
                System.out.println(i);
            }
        }
        if (!isExist) {
            System.out.println(-1);
        }
    }
}
