package Doyeon.p_20201122;

import java.util.Scanner;

/**
 * 공항
 * Union-Find 이용해서 처리
 * https://www.acmicpc.net/problem/10775
 */
public class Airport {
	public static int[] parent;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int g = sc.nextInt();
		int p = sc.nextInt();

		int answer = 0;
		// 0 ~ 4
		parent = new int[g+1];
		// 자기자신으로 초기화
		for (int i = 1; i <= g; i++) {
			parent[i] = i;
		}

		// 다음 가능한 도킹 위치를 넣어줌
		// find(2) = 2 -> 2에 넣어주고 parent[2] = 1로 세팅 -> 다음에 2로 들어오면 게이트 1에 들어가게끔
		// find(2) = 1 -> 1에 넣어주고 parent[1] = 0으로 세팅
		// find(3) = 3 -> 3에 넣어주고 parent[3] = 0으로 세팅
		// find(3) = 0이므로 break
		for (int i = 0; i < p; i++) {
			int gi = sc.nextInt();
			int possibleGate = find(gi);
			if (possibleGate == 0) {
				break;
			}
			union(possibleGate, possibleGate-1);
			answer++;
		}
		System.out.println(answer);
	}

	public static void union(int u, int v) {
		u = find(u);
		v = find(v);
		parent[u] = v;
	}

	public static int find(int u) {
		if (u == parent[u]) {
			return u;
		}
		return parent[u] = find(parent[u]);
	}
}
