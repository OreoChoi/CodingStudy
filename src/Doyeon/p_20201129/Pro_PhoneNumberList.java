package Doyeon.p_20201129;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 전화번호 목록
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */
public class Pro_PhoneNumberList {
    public static boolean solution(String[] phone_book) {
        // 길이순으로 sorting
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));
        // 짧은 것부터 순서대로 자신으로 시작하는 String이 있는지 체크
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i+1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
            }
        }
        // 없으면 true 반환
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"119", "97674223", "1195524421"}));
    }
}
