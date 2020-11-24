package JunHo;

import java.util.HashMap;
import java.util.Map;

/**
 * jhChoi - 201122
 * 프로그래머스 위장
 */
public class Pro_Camouflage {
    /**
     * 참고 코드
     * https://velog.io/@giraffelim/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%9C%84%EC%9E%A5
     * */
    public static int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> clothesMap = new HashMap<>(); // 종류 : 갯수

        for (String[] clothe : clothes) {
            clothesMap.put(clothe[1], clothesMap.getOrDefault(clothe[1], 0) + 1);
        }

        // 경우의 수 체크 answer *= (옷 가지수 + 안 입을 경우) -> ? 흠...
        for (int val : clothesMap.values()){
            answer *= (val+1);
        }

        // 모두 다 안입는 경우는 존재하지 않으므로 -1
        return answer-1;
    }
}
