package Doyeon.p_20201213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Baek_1753 {
	public static final int INF = (int) 1e9;
	private static void dijkstra(int start, List<Node>[] adjList, int[] shortest) {
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new Node(start, 0));
		shortest[start] = 0;
		while (!priorityQueue.isEmpty()) {
			Node node = priorityQueue.poll();
			int currIndex = node.getIndex();
			int currCost = node.getCost();
			if (shortest[currIndex] < currCost) {
				continue;
			}
			for (int i = 0; i < adjList[currIndex].size(); i++) {
				int calculCost = shortest[currIndex] + adjList[currIndex].get(i).getCost();
				if (calculCost < shortest[adjList[currIndex].get(i).getIndex()]) {
					shortest[adjList[currIndex].get(i).getIndex()] = calculCost;
					priorityQueue.add(new Node(adjList[currIndex].get(i).getIndex(), calculCost));
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int start = sc.nextInt();
		// 인접리스트
		List<Node>[] adjList = new List[v+1];
		for (int i = 1; i < adjList.length; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			adjList[a].add(new Node(b, cost));
		}
		// 최단거리 배열
		int[] shortest = new int[v+1];
		Arrays.fill(shortest, INF);
		dijkstra(start, adjList, shortest);
		for (int i = 1; i < shortest.length; i++) {
			if (shortest[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(shortest[i]);
			}
		}
	}
}
