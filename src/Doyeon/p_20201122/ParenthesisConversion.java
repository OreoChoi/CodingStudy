package Doyeon.p_20201122;

import java.util.Stack;

/**
 * 괄호 변환
 * https://programmers.co.kr/learn/courses/30/lessons/60058
 */
public class ParenthesisConversion {
    /**
     * 균형잡힌 괄호 문자열 위치 return
     */
    private static int isBalanced(String p) {
        int result = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                result = i + 1;
                break;
            }
        }
        return result;
    }

    /**
     * 올바른 괄호 문자열 여부 체크
     * Stack을 이용해서 해결
     */
    private static boolean isCorrect(String u) {
        boolean result = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                stack.push(u.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    result = false;
                    break;
                }
            }
        }
        if (!stack.isEmpty()) {
            result = false;
        }
        return result;
    }

    public static String solution(String p) {
        // 1.
        if (p.isEmpty()) {
            return p;
        }
        // 2.
        int index = isBalanced(p);
        String u = p.substring(0, index);
        String v = p.substring(index);
        // 3.
        if(isCorrect(u)) {
            return u + solution(v);
        }
        // 4.
        StringBuilder sb = new StringBuilder("(" + solution(v) + ")");
        // 첫번째, 마지막 제외하고 뒤집기
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("()))((()"));
    }
}
