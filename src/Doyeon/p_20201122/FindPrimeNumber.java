package Doyeon.p_20201122;

import java.util.HashSet;
import java.util.Set;

/**
 * 소수찾기
 * https://programmers.co.kr/learn/courses/30/lessons/42839
 */
public class FindPrimeNumber {
	public static int[] value = new int[7]; //
	public static boolean[] used = new boolean[7]; // i번째 숫자 사용여부 배열
	public static Set<Integer> numberSet = new HashSet<>();	// 중복된 값 처리하기 위해 Set 이용

	/**
	 * 재귀 이용해서 길이별로 모든 가능한 숫자 생성
	 */
	private static void go(int[] numberArr, int index, int length) {
		if (index == length) { // 길이 같아지면 숫자를 만들고 set에 넣어주고 return
			int result = 0;
			for (int i = 0; i < length; i++) {
				result += value[i] * Math.pow(10, length-i-1);
			}
			numberSet.add(result);
			return;
		}
		for (int i = 0; i < numberArr.length; i++) {
			if (used[i]) { // 이미 이전에 사용한 경우 pass
				continue;
			}
			used[i] = true;
			value[index] = numberArr[i];
			go(numberArr, index+1, length);
			used[i] = false;
		}
	}

	/**
	 * 소수 판별 로직
	 * number의 제곱근까지만 확인
	 */
	private static int isPrimeNumber(int number) {
		if (number < 2) {
			return 0;
		}
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return 0;
			}
		}
		return 1;
	}

	public static int solution(String numbers) {
		int answer = 0;
		int[] numberArr = new int[numbers.length()];
		for (int i = 0; i < numberArr.length; i++) {
			numberArr[i] = numbers.charAt(i) - '0';
		}
		for (int i = 1; i <= numbers.length(); i++) {
			go(numberArr, 0, i);
		}
		for (int number : numberSet) {
			answer += isPrimeNumber(number);
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution("17"));
	}
}
