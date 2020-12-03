package Doyeon.p_20201206;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Baek_4386 {
	static class Node {
		double x;
		double y;

		public Node(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	static class Edge implements Comparable<Edge> {
		int a;
		int b;
		double distance;

		public Edge(int a, int b, double distance) {
			this.a = a;
			this.b = b;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.distance, o.distance);
		}
	}
	// 부모를 find
	private static int find(int x) {
		if (x == parent[x]) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
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
		parent = new int[n+1];
		// 자기 자신으로 초기화
		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
		// 처음에 노드 정보를 받아서 리스트로 다 노드를 만든다
		List<Node> nodeList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nodeList.add(new Node(sc.nextDouble(), sc.nextDouble()));
		}
		List<Edge> edgeList = new ArrayList<>();
		// 모든 노드를 다 돌면서 서로의 거리를 저장해둔다
		// 100 * 100 => 10000가지니까 괜찮?
		for (int i = 0; i < nodeList.size(); i++) {
			for (int j = 0; j < nodeList.size(); j++) {
				if (i == j) {
					continue;
				}
				// 평면 상의 두 점의 거리
				// 노드 번호 1부터 시작하도록 +1
				edgeList.add(new Edge(i+1, j+1, Math.sqrt(Math.pow(nodeList.get(i).x-nodeList.get(j).x,2)+Math.pow(nodeList.get(i).y-nodeList.get(j).y,2))));
			}
		}

		// 거리 내림차순 정렬
		Collections.sort(edgeList);

		double result = 0;
		// Edge 돌면서
		for (int i = 0; i < edgeList.size(); i++) {
			int a = edgeList.get(i).a;
			int b = edgeList.get(i).b;
			double distance = edgeList.get(i).distance;
			// 싸이클이 존재하는지 확인
			if (find(a) != find(b)) {
				union(a, b);
				result += distance;
			}
		}
		// 소수점 두자리까지
		System.out.println(Math.round(result*100)/100.0);
	}
}
