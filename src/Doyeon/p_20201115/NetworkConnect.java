package Doyeon.p_20201115;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 크루스칼 알고리즘을 이용해서 처리
 * 이거는 Edge를 class로 만들어서 list에 담아두고 cost기준으로 정렬한 뒤
 * union-find 방식을 이용해서 cycle인지 판단하여 해당 간선을 포함할 것인지 아닌지 처리
 * 최소 스패닝 트리 문제와 동일
 * https://www.acmicpc.net/problem/1922
 */
public class NetworkConnect {
	// cost 기준으로 정렬되도록 comparable 구현
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
			if (this.cost < o.cost) {
				return -1;
			}
			return 1;
		}
	}

	// 노드 index가 높은 값으로 합치기 (작은 값으로 해도 되고 상관없음)
	private static void unionParent(int a, int b) {
		int aParent = findParent(a);
		int bParent = findParent(b);
		if (aParent > bParent) {
			parent[bParent] = aParent;
		} else {
			parent[aParent] = bParent;
		}
	}

	// 자신의 부모 return
	private static int findParent(int x) {
		// 자기가 root일 때 반환
		if (x == parent[x]) {
			return x;
		}
		return findParent(parent[x]);
	}
	public static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		// 부모테이블
		parent = new int[v+1];
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		// 간선리스트
		List<Edge> edgeList = new ArrayList<>();
		for (int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int cost = sc.nextInt();
			edgeList.add(new Edge(a, b, cost));
		}
		// cost 낮은 순으로 정렬
		Collections.sort(edgeList);

		int result = 0;
		for (Edge edge : edgeList) {
			int a = edge.a;
			int b = edge.b;
			int cost = edge.cost;
			// 사이클 여부 체크
			if (findParent(a) != findParent(b)) {
				unionParent(a, b);
				result += cost;
			}
		}
		System.out.println(result);
	}

}
