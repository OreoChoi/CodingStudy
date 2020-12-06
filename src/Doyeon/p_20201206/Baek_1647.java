package Doyeon.p_20201206;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * [백준] 도시분할계획
 * https://www.acmicpc.net/problem/1647
 *
 * 문제접근방법
 * 1. 먼저 최소신장트리를 구성하고
 * 2. 그 중 유지비가 가장 큰 길을 없앤다
 */
public class Baek_1647 {
	static class Edge implements Comparable<Edge> {
		int a;
		int b;
		int cost;

		public Edge(int a, int b, int cost) {
			this.a = a;
			this.b = b;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}
	public static int find(int x) {
		// 자기 자신이 parent이면 return
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	public static void union(int a, int b) {
		// 각각의 parent를 찾고
		a = find(a);
		b = find(b);
		// node번호가 작은거를 parent로
		if (a < b) {
			parent[b] = a;
		} else {
			parent[a] = b;
		}
	}
	// 부모 배열
	public static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		parent = new int[n+1];
		// 자기 자신으로 초기화
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		List<Edge> edgeList = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			edgeList.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}

		// cost 오름차순 정렬
		Collections.sort(edgeList);

		int maxCost = 0;
		int result = 0;
		for (int i = 0; i < edgeList.size(); i++) {
			int a = edgeList.get(i).a;
			int b = edgeList.get(i).b;
			int cost = edgeList.get(i).cost;
			// 사이클이 발생하는지 체크
			if (find(a) != find(b)) {
				union(a, b);
				result += cost;
				maxCost = Math.max(maxCost, cost);
			}
		}
		System.out.println(result-maxCost);
	}
}
