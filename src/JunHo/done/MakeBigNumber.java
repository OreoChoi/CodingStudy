package JunHo;

import java.util.Stack;

/**
 * jhChoi - 20201102
 * 프로그래머스 - 큰수 만들기
 * */
public class MakeBigNumber {
    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
        System.out.println(solution("9192391234", 4));
        System.out.println(perfectSolution("111119111", 4));
    }

    static String solution(String strNum, int removeSize) {
        StringBuilder number = new StringBuilder(strNum);
        int removeCount = 0;
        int max = -1;

        for (int i = 0; i <= removeSize; i++) {  //가장 큰 수를 골라 내며 9인 경우는 for 문을 바로 탈출 합니다.
            int num = number.charAt(i) - '0';

            if (max < num) {
                max = num;
                removeCount = i;
            }

            if (max == 9) {
                break;
            }
        }

        number = new StringBuilder(number.substring(removeCount));   //(max 숫자 ~ 마지막 숫자) 잘라 number를 생성
        for (int i = 0; i < number.length() - 1; i++) {
            if (number.charAt(i) < number.charAt(i + 1) && removeCount < removeSize) {        //현재 숫자보다 다음 숫자가 크면서, 삭제된 횟수가 삭제 제한 횟수 보다 작은 경우
                number.deleteCharAt(i);
                removeCount++;
                i -= 2;
            }
        }

        if (removeCount < removeSize) {
            number.deleteCharAt(number.length() - 1);
        }

        return number.toString();
    }

    /**
     * 제가 짠 코드가 아닌 타인이 짠 코드 입니다.
     *
     * */
    public static String perfectSolution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
