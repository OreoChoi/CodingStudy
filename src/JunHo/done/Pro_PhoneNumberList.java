package JunHo.done;

import java.util.Arrays;

/**
 * jhChoi - 201124
 * 프로그래머스 전화번호 목록
 */
public class Pro_PhoneNumberList {
    public static void main(String[] args) {
        String[] pb1 = {"119", "97674223", "1195524421"};
        String[] pb2 = {"123", "456", "789"};
        String[] pb3 = {"12", "123", "1235", "567", "88"};

        System.out.println(solution(pb1));
        System.out.println(solution(pb2));
        System.out.println(solution(pb3));
    }

    public static boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (o1, o2) -> Integer.compare(o1.length(), o2.length()));

        for (int cIdx = 0; cIdx < phone_book.length; cIdx++) {
            String checkNumber = phone_book[cIdx];

            for (int j = cIdx+1; j < phone_book.length; j++) {
                if(phone_book[j].startsWith(checkNumber)){
                    return false;
                }
            }
        }

        return true;
    }
}
