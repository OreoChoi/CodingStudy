package Doyeon.p_20201115;

import java.util.*;



/**
 * [다익스트라] 특정 거리의 도시 찾기
 * 최단거리 찾는 문제이면서 간선의 가중치가 다 1이므로 BFS를 이용해서 찾을수도 있음
 * https://www.acmicpc.net/problem/18352
 */
public class FindCityBfs {
    static class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }

    private static void bfs(int[] shortArr, List<Integer>[] adjList, int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));
        shortArr[start] = 0;
        while (!queue.isEmpty()) {
            // 현재 노드
            Node node = queue.poll();
            int index = node.index;
            int distance = node.distance;
            // 인접한 노드들을 돌면서
            for (int n : adjList[index]) {
                // 방문 안한 노드
                if (shortArr[n] == -1) {
                    // 현재 거리에 + 1
                    shortArr[n] = distance + 1;
                    queue.add(new Node(n, shortArr[n]));
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
        // 노드 별 거리 배열이면서 방문 여부 배열 (노드 1부터 시작이니까 n+1)
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
        // BFS
        bfs(shortArr, adjList, x);
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
