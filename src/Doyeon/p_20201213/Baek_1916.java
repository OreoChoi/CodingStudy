package Doyeon.p_20201213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Baek_1916 {
	public static final int INF = (int) 1e9;
	private static void dijkstra(int start, List<Node>[] adjList, int[] shortest) {
		// 우선순위큐
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		// 시작점 cost 0으로
		priorityQueue.add(new Node(start, 0));
		shortest[start] = 0;
		while (!priorityQueue.isEmpty()) {
			Node node = priorityQueue.poll();
			int currIndex = node.getIndex();
			int currCost = node.getCost();
			// 현재 cost값보다 작은 경우 이미 처리한 것으로 보고 pass
			if (shortest[currIndex] < currCost) {
				continue;
			}
			// 현재 노드와 인접한 노드를 loop 돌면서
			for (int i = 0; i < adjList[currIndex].size(); i++) {
				int calculCost = shortest[currIndex] + adjList[currIndex].get(i).getCost();
				// 현재 노드를 거쳐서 다른 노드로 가는 게 더 cost가 작은 경우
				if (calculCost < shortest[adjList[currIndex].get(i).getIndex()]) {
					shortest[adjList[currIndex].get(i).getIndex()] = calculCost;
					priorityQueue.add(new Node(adjList[currIndex].get(i).getIndex(), calculCost));
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		// 인접리스트
		List<Node>[] adjList = new List[n+1];
		for (int i = 1; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			adjList[a].add(new Node(b, cost));
		}
		int start = sc.nextInt();
		int end = sc.nextInt();
		// 최단거리배열
		int[] shortest = new int[n+1];
		Arrays.fill(shortest, INF);
		dijkstra(start, adjList, shortest);
		System.out.println(shortest[end]);
	}
}
