package Doyeon.p_20201122;

/**
 * 조이스틱
 * https://programmers.co.kr/learn/courses/30/lessons/42860
 */
public class Joystick {
	public static int solution(String name) {
		char[] nameArr = name.toCharArray();
		// 1. 위 - 아래
		int unDown = 0;
		for(int i = 0 ; i < name.length() ; i++) {
			// A가 아닌 경우
			if (nameArr[i] != 'A') {
				int up = nameArr[i] - 'A'; // 위로 이동
				int down = 'Z' - nameArr[i] + 1; // 아래로 이동
				unDown += Math.min(up, down);
			}
		}
		// 2. 좌 - 우
		int right;
		int prevI = 0;
		int leftRight = 0;
		for (int i = 0; i < nameArr.length; i++) {
			if (nameArr[i] == 'A') {
				continue;
			}
			// 현재위치
			right = i - prevI;
			leftRight += Math.min(right, prevI+nameArr.length-i);
			prevI = i;
		}
		return unDown + leftRight;
	}

	public static void main(String[] args) {
		System.out.println(solution("JEROEN"));
	}
}
