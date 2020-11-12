package Doyeon.p_20201110;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 재귀 이용해서 완전 탐색
 * 시간 초과 발생
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 */
public class BigNumber1 {
    public static List<String> list = new ArrayList<>();
    public static void go(char[] chars, int length, int index, String num) {
        if (num.length() == length) {
            list.add(num);
            return;
        }
        if (index+1 >= chars.length) {
            return;
        }
        go(chars, length, index+1, num+chars[index+1]);
        go(chars, length, index+1, num);
    }
    public static String solution(String number, int k) {
        char[] chars = number.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            go(chars, chars.length-k, i, String.valueOf(chars[i]));
        }
        Collections.sort(list);
        return list.get(list.size()-1);
//        int length = number.length() - k;
//        StringBuffer sb = new StringBuffer();
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < number.length(); i++) {
//            char c = number.charAt(i);
//            // 스택에 값이 있으면서
//            // 스택의 top값이 c보다 작은 경우
//            // 아직 k개만큼 다 안 뺀 경우
//            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
//                stack.pop();
//            }
//            stack.push(c);
//        }
//        for (int i = 0; i < length; i++) {
//            sb.append(stack.get(i));
//        }
//        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
    }
}
