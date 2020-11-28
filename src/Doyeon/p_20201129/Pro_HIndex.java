package Doyeon.p_20201129;

import java.util.Arrays;

/**
 * H-Index
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */
public class Pro_HIndex {
	public static int solution(int[] citations) {
		int result = 0;
		// sorting하고
		Arrays.sort(citations);
		// 0 ~ 최대인용횟수까지
		for (int i = 0; i <= citations[citations.length-1]; i++) {
			int cnt = 0;
			// 입력 받은 인용횟수와 매번 비교해서
			for (int j = 0; j < citations.length; j++) {
				// i보다 인용횟수가 크거나 같은 경우 cnt++
				if (citations[j] >= i) {
					cnt++;
				}
			}
			// i가 cnt보다 작거나 같으면서, i가 result보다 크면
			if (i <= cnt && i > result) {
				result = i;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(solution(new int[] {10, 11, 12, 13}));
	}
}
