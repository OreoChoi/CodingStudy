package Doyeon.p_20201206;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 파일명 정렬
 * https://programmers.co.kr/learn/courses/30/lessons/17686
 *
 * 문제풀이방법
 * 1. 숫자의 시작위치 끝위치를 찾고
 */

class File implements Comparable<File> {
	String head;
	int number;
	String tail;
	String fileName;

	public File(String head, int number, String tail, String fileName) {
		this.head = head;
		this.number = number;
		this.tail = tail;
		this.fileName = fileName;
	}

	@Override
	public int compareTo(File o) {
		int result = this.head.toLowerCase().compareTo(o.head.toLowerCase());
		if (result == 0) {
			result = Integer.compare(this.number, o.number);
		}
		return result;
	}
}
public class Pro_17686 {
	public static String[] solution(String[] files) {
		List<File> fileList = new ArrayList<>();
		// 파일을 돌면서
		for (int i = 0; i < files.length; i++) {
			String file = files[i];
			// 숫자 시작위치
			int numStart = 0;
			// 숫자의 index를 찾는다 최대 5자리
			for (int j = 0; j < file.length(); j++) {
				if (file.charAt(j) >= '0' && file.charAt(j) <= '9') {
					numStart = j;
					break;
				}
			}
			// 숫자의 끝나는 위치를 찾고
			int numEnd = numStart;
			while (true) {
				if (numEnd >= file.length()) {
					break;
				}
				if (numEnd - numStart >= 5) {
					break;
				}
				if (!(file.charAt(numEnd) >= '0' && file.charAt(numEnd) <= '9')) {
					break;
				}
				numEnd++;
			}
			String head = file.substring(0, numStart); // head
			int number = Integer.parseInt(file.substring(numStart, numEnd)); // number
			String tail = file.substring(numEnd); // tail
			fileList.add(new File(head, number, tail, files[i]));
		}
		Collections.sort(fileList);
		String[] answer = new String[fileList.size()];
		for (int i = 0; i < fileList.size(); i++) {
			answer[i] = fileList.get(i).fileName;
		}
		return answer;
	}

	public static void main(String[] args) {
		// System.out.println(Arrays.toString(
		// 	solution(new String[] {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
		// System.out.println(Arrays.toString(
		// 	solution(new String[] {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
		// System.out.println(Arrays.toString(
		// 	solution(new String[] {"foo9.txt", "foo01bar020.zip", "F-15"})));
		System.out.println(Arrays.toString(
			solution(new String[] {"img000012345", "img1.png", "img2", "IMG02"})));

	}
}
