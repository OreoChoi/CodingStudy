package Doyeon.p_20201206;

import java.io.IOException;
import java.util.Scanner;

/**
 * 파일 합치기
 * https://www.acmicpc.net/problem/11066
 * 
 * 문제접근방법
 * d[i][j] : i번째~j번째 수까지 합치는데 필요한 최소 비용
 * d[1][4] = d[1][1] + d[2][4] + i ~ j까지 합 => 40 / 30 30 50
 * d[2][4] = d[2][2] + d[3][4] => 30 / 30 50
 * d[3][4] = d[3][3] + d[4][4] => 30 / 50
 */
public class Baek_11066 {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		int t = input.nextInt();
		for(int z = 0; z < t; z++) {
			int n = input.nextInt();
			// 각 파일의 비용
			int[] file = new int[n];
			// i 이전까지의 비용 합
			int[] sum = new int[n+1];
			int[][] d = new int[n][n];
			for(int i = 0; i < n; i++) {
				file[i] = input.nextInt();
				if(i == 0) {
					sum[i+1] = file[i];
				} else {
					sum[i+1] = sum[i] + file[i];
				}
			}
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < n - i; j++) {
					d[j][j+i] = Integer.MAX_VALUE;
					for (int k = j; k < j + i; k++) {
						d[j][j+i] = Math.min(d[j][j+i], d[j][k] + d[k+1][j+i] + sum[j+i+1] - sum[j]);
					}
				}
			}
			System.out.println(d[0][n-1]);
		}
	}
}
