package JunHo;

import java.util.*;

public class NumberOneBigNumber {
    static String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] strNumbers = new String[numbers.length];

        for (int i = 0; i < strNumbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (strNumbers[0].startsWith("0")) {
            answer.append("0");
        } else {
            for (String strNumber : strNumbers) {
                answer.append(strNumber);
            }
        }

        return answer.toString();
    }
}
