package Doyeon.p_20201122;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 저울
 * https://www.acmicpc.net/problem/2437
 */
public class Scales {
	public static List<Integer> weightList = new ArrayList<>();

	/**
	 * 재귀로 돌면서 무게추로 조합 가능한 모든 무게 계산
	 */
	private static void go(int[] weightArr, boolean[] used, int goal, int sumWeight) {
		if (sumWeight == goal) {
			if (!weightList.contains(sumWeight)) {
				weightList.add(sumWeight);
			}
			return;
		}
		if (sumWeight > goal) {
			return;
		}
		for (int i = 0; i < weightArr.length; i++) {
			if (used[i]) {
				continue;
			}
			used[i] = true;
			go(weightArr, used, goal, sumWeight+weightArr[i]);
			used[i] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int totalWeight = 0;
		boolean[] used = new boolean[n];
		int[] weightArr = new int[n];
		for (int i = 0; i < weightArr.length; i++) {
			int weight = sc.nextInt();
			totalWeight += weight;
			weightArr[i] = weight;
		}
		Arrays.sort(weightArr);
		for (int i = 1; i <= totalWeight; i++) {
			go(weightArr, used, i, 0);
		}
		for (int i = 1; i <= totalWeight; i++) {
			if (weightList.get(i-1) != i) {
				System.out.println(weightList.get(i-2)+1);
				break;
			}
		}
	}
}
