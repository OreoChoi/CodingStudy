package Doyeon.p_20201129;

import java.util.Arrays;

public class Pro_ColoringBook {
	public static int[] dx = {-1, 0, 0, 1};
	public static int[] dy = {0, -1, 1, 0};
	public static void dfs(int[][] picture, int[][] group, int m, int n, int i, int j, int regionNum, int groupNum) {
		if (group[i][j] != 0) {
			return;
		}
		group[i][j] = groupNum;
		for (int k = 0; k < 4; k++) {
			int nx = i + dx[k];
			int ny = j + dy[k];
			if ((0 <= nx && nx < m) && (0 <= ny && ny < n)) {
				if (group[nx][ny] == 0 && picture[nx][ny] == regionNum) {
					dfs(picture, group, m, n, nx, ny, regionNum, groupNum);
				}
			}
		}
	}
	public static int[] solution(int m, int n, int[][] picture) {
		int[][] group = new int[m][n];

		int groupNum = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] != 0 && group[i][j] == 0) {
					groupNum++;
					dfs(picture, group, m, n, i, j, picture[i][j], groupNum);
				}
			}
		}
		int maxVal = 0;
		for (int i = 1; i <= groupNum; i++) {
			int tempVal = 0;
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < n; k++) {
					if (group[j][k] == i) {
						tempVal++;
					}
				}
			}
			if (tempVal > maxVal) {
				maxVal = tempVal;
			}
		}
		int[] answer = new int[2];
		answer[0] = groupNum;
		answer[1] = maxVal;
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(6, 4,
			new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
	}
}
