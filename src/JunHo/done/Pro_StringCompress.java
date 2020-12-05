package JunHo.done;

import java.util.ArrayList;
import java.util.List;

/**
 * jhChoi - 201124
 * 프로그래머스 - 문자열 압축
 */
public class Pro_StringCompress {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
        System.out.println(solution("a"));
    }

    public static int solution(String s) {
        List<String[]> checkList = createCutList(s);
        List<String> compList = new ArrayList<>();

        for (String[] cutStr : checkList) { //문자열을 compress합니다.
            String prev = cutStr[0];
            int compCount = 1;
            StringBuilder compStr = new StringBuilder();

            for (int i = 1; i < cutStr.length; i++) {
                if (prev.equals(cutStr[i])) {
                    compCount++;
                } else {
                    compStr.append(compCount == 1 ? prev : compCount + prev);
                    compCount = 1;
                }
                prev = cutStr[i];
            }

            compStr.append(compCount == 1 ? prev : compCount + prev);
            compList.add(compStr.toString());
        }

        int min = compList.size() == 0 ? 1 : Integer.MAX_VALUE;
        for (String comp : compList) {  //compress한 문자열중 가장 작은 길이를 찾습니다.
            min = Math.min(comp.length(), min);
        }

        return min;
    }

    /**
     * 1 ~ s.length/2 까지의 단위로 문자열을 잘라 List형태로 반환합니다.
     * <p>
     * 예시) aabbccdd
     * cutList.get(0) = {"a","a","b","b","c","c","d","d"}
     * cutList.get(1) = {"aa","bb","cc","dd"}
     * cutList.get(2) = {"aab","bcc","dd"}
     * cutList.get(3) = {"aabb","ccdd"}
     * <p>
     * [s.length/2를 하는 이유]
     * 1. 문자열을 잘라 압축 해야 하는데 절반을 넘어 압축 할 수 없다.
     */
    static List<String[]> createCutList(String s) {
        List<String[]> cutList = new ArrayList<>();
        int cutLength = 1;

        for (int i = 0; i < s.length() / 2; i++) {
            String[] cutStr = new String[s.length() / cutLength + 1];
            int index = 0;

            for (int j = 0; j < cutStr.length; j++) {
                if (index + cutLength <= s.length()) {
                    cutStr[j] = s.substring(index, index + cutLength);
                    index = index + cutLength;
                } else {
                    cutStr[j] = s.substring(index);
                }
            }

            cutLength++;
            cutList.add(cutStr);
        }

        return cutList;
    }
}
