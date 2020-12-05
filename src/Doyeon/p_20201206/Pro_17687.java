package Doyeon.p_20201206;

import java.util.ArrayList;
import java.util.List;

/**
 * n진수 게임
 * https://programmers.co.kr/learn/courses/30/lessons/17687
 *
 * 문제풀이방법
 *
 */
public class Pro_17687 {
	public static char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	public static String solution(int n, int t, int m, int p) {
		List<Character> list = new ArrayList<>();
		int val = 0;
		while (true) {
			List<Character> baseList = getBaseNum(val, n);
			// 한번 또 쪼개서
			for (int i = baseList.size()-1; i > -1; i--) {
				list.add(baseList.get(i));
			}
			if (list.size() >= t*m) {
				break;
			}
			val++;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = p-1; i < list.size(); i+=m) {
			sb.append(list.get(i));
			if (sb.length() == t) {
				break;
			}
		}
		return sb.toString();
	}

	private static List<Character> getBaseNum(int val, int n) {
		List<Character> baseList = new ArrayList<>();
		if (val == 0) {
			baseList.add('0');
			return baseList;
		}
		while (val > 0) {
			baseList.add(table[val%n]);
			val /= n;
		}
		return baseList;
	}

	public static void main(String[] args) {
		System.out.println(solution(2,4,2,1));
		System.out.println(solution(16,16,2,1));
		System.out.println(solution(16,16,2,2));
	}
}
