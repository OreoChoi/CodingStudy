package Doyeon.p_20201206;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * [프로그래머스] 압축
 * https://programmers.co.kr/learn/courses/30/lessons/17684
 *
 * 문제접근방법
 * 1.
 */
public class Pro_17684 {
	public static Integer[] solution(String msg) {
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < 26; i++) {
			// 색인번호 0부터 저장
			map.put(String.valueOf((char)(i+65)), i);
		}
		List<Integer> answerList = new ArrayList<>();
		boolean isEnd = false;
		for (int i = 0; i < msg.length(); i++) {
			String word = String.valueOf(msg.charAt(i));
			while (map.containsKey(word)) {
				i++;
				if (i == msg.length()) {
					isEnd = true;
					break;
				}
				word += msg.charAt(i);
			}
			if (isEnd) {
				answerList.add(map.get(word)+1);
				break;
			}
			// 지금 word의 전 word의 인덱스를 list에 추가
			answerList.add(map.get(word.substring(0, word.length() - 1))+1);
			// 지금 word는 word
			map.put(word, map.size());
			i--;
		}
		return answerList.toArray(new Integer[answerList.size()]);
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("KAKAO")));
	}
}
