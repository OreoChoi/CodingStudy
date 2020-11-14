package Doyeon.p_20201115;

import java.util.Scanner;

/**
 * 재귀를 이용해서 모든 케이스 다 확인
 * 이전 값이랑 같으면 pass 하도록 처리
 * https://www.acmicpc.net/problem/16968
 */
public class CarNumber {
	public static int count = 0;
	// 재귀
	private static void check(char[] formatArr, int index, String str, int prev) {
		// 현재 str의 길이와 format 길이를 비교해서
		// 다 만들어졌으면 count++하고 return
		if (str.length() == formatArr.length) {
			count++;
			return;
		}
		if (formatArr[index] == 'd') { // 숫자인 경우
			// 0 ~ 9까지 loop 돌면서
			for (int j = 0; j < 10; j++) {
				// 이전 값이랑 같으면 pass
				if (j == prev) {
					continue;
				}
				// index+1해주고, str에도 j를 append
				check(formatArr, index+1, str+j, j);
			}
		} else { // 문자인 경우
			// 0 ~ 25까지 loop 돌면서
			for (int j = 0; j < 26; j++) {
				// 이전 값이랑 같으면 pass
				if ((j+'a') == prev) {
					continue;
				}
				// index+1해주고, str에도 (j+97)를 append
				check(formatArr, index+1, str+(char)(j+'a'), j+'a');
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] formatArr = sc.next().toCharArray();
		check(formatArr, 0, "", -1);
		System.out.println(count);
	}
}
