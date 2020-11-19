package Doyeon.p_20201122;

import java.util.PriorityQueue;

/**
 * 더 맵게
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */
public class Spicier {
	public static int solution(int[] scoville, int K) {
		int answer = -1;
		// 우선순위큐 사용
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int j : scoville) {
			queue.add(j);
		}
		int count = 0;
		while (queue.size() > 1) {
			count++;
			int first = queue.poll();
			int second = queue.poll();
			queue.add(first + (second * 2));
			int minVal = queue.peek();
			if (minVal >= K) {
				answer = count;
				break;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
	}
}
