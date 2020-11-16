package JunHo;

/**
 * jhChoi - 201116
 * 괄호 변환
 */
public class ParenthesisConversion {
    public static void main(String[] args) {
        String p = "";
        String p1 = "(()())()";
        String p2 = ")(";
        String p3 = "()))((()";

        System.out.println(solution(p));
        System.out.println(solution(p1));
        System.out.println(solution(p2));
        System.out.println(solution(p3));
    }

    static StringBuilder sBuilder = new StringBuilder();

    public static String solution(String p) {
        while (!p.equals("")) {
            String[] q = divide(p);

            if (isCorrect(q[0])) {
                sBuilder.append(q[0]);
                p = q[1];
            } else {
                sBuilder.append("(");
                solution(q[1]);
                sBuilder.append(")");
                sBuilder.append(reverse(q[0]));
                break;
            }
        }

        return sBuilder.toString();
    }

    /**
     * 괄호 뒤집기
     */
    static String reverse(String u) {
        StringBuilder result = new StringBuilder();
        char[] uArr = u.toCharArray();

        for (int i = 1; i < uArr.length - 1; i++) {
            result.append(uArr[i] == '(' ? ')' : '(');
        }

        return result.toString();
    }

    static boolean isCorrect(String u) {
        boolean isCorrect = true;
        char[] arr = u.toCharArray();
        int lCount = 0;
        int rCount = 0;

        for (char c : arr) {
            if (c == '(') lCount++;
            else rCount++;

            if (lCount < rCount) {
                isCorrect = false;
                break;
            }
        }

        return isCorrect;
    }

    /**
     * 괄호를 분리합니다.
     */
    static String[] divide(String parent) {
        String[] result = new String[2];
        char[] arr = parent.toCharArray();
        int lCount = 0;
        int rCount = 0;
        boolean isDivide = false;

        for (int i = 0; i < arr.length; i++) {
            isDivide = lCount == rCount && (lCount + rCount) > 0;

            if (isDivide) {
                result[0] = parent.substring(0, i);
                result[1] = parent.substring(i);
                break;
            } else {
                if (arr[i] == '(') lCount++;
                else rCount++;
            }
        }

        isDivide = lCount == rCount && (lCount + rCount) > 0;
        if (isDivide && result[0] == null && result[1] == null) {
            result[0] = parent;
            result[1] = "";
        }

        return result;
    }
}
