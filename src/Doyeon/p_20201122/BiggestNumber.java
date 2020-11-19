package Doyeon.p_20201122;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 가장 큰 수
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 */
public class BiggestNumber {
	public static String solution(int[] numbers) {
		StringBuffer sb = new StringBuffer();
		List<Integer> list = new ArrayList<>();
		for (int number : numbers) {
			list.add(number);
		}
		// 두 숫자를 앞뒤로, 뒤앞으로 조합해서 Integer형으로 변환 후 비교해서 내림차순으로 정렬되도록 처리
		list.sort((o1, o2) -> {
			int num1 = Integer.parseInt(Integer.toString(o1) + o2);
			int num2 = Integer.parseInt(Integer.toString(o2) + o1);
			return Integer.compare(num1, num2) * -1;
		});
		for (int i = 0; i < list.size(); i++) {
			// 입력값이 모두 0인 경우가 있어 예외 처리
			if (i == 0 && list.get(i) == 0) {
				return "0";
			}
			sb.append(list.get(i));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 30, 34, 5, 9}));
	}
}
