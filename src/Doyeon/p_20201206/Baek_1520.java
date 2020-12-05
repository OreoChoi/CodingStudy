package Doyeon.p_20201206;

import java.util.Scanner;

public class Baek_1520 {
	public static int[] dx = {-1, 0, 0, 1};
	public static int[] dy = {0, -1, 1, 0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] a = new int[m][n];
		int[][] cnt = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				a[i][j] = sc.nextInt();
				// -1로 초기화를 해준다
				cnt[i][j] = -1;
			}
		}
		System.out.println(dfs(a, cnt, m, n, 0, 0));
	}

	private static int dfs(int[][] a, int[][] cnt, int m, int n, int i, int j) {
		// 마지막 위치에 도착한 경우 1을 return
		if (i == m-1 && j == n-1) {
			return 1;
		}
		// 방문한 적 없는 경우
		if (cnt[i][j] == -1) {
			cnt[i][j] = 0;
			for (int k = 0; k < 4; k++) {
				int ni = i + dx[k];
				int nj = j + dy[k];
				if ((0 <= ni && ni < m) && (0 <= nj && nj < n)) {
					if (a[ni][nj] < a[i][j]) {
						cnt[i][j] += dfs(a, cnt, m, n, ni, nj);
					}
				}
			}
		}
		return cnt[i][j];
	}
}
