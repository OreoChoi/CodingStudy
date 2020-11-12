package Doyeon.p_20201110;

import java.util.Stack;

/**
 * 스택을 이용해서 처리한 풀이
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 */
public class BigNumber2 {
    public static String solution(String number, int k) {
        int length = number.length() - k;
        StringBuffer sb = new StringBuffer();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            // 스택에 값이 있으면서
            // 스택의 top값이 c보다 작은 경우
            // 아직 k개만큼 다 안 뺀 경우
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i = 0; i < length; i++) {
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
    }
}
