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
     *
     * 예) 모자 2 , 옷 1의 경우
     * 1. 각 의상부위에 맞게 경우의 수를 산출
     * 쓸 수 있는 모자 2개 + 못 쓰는 경우 1개 = 3개의 경우의 수
     * 입을수 있는 옷 1개 + 못 입는 경우 1개 = 2개의 경우의 수
     *
     * 2. 총 경우의 수를 산출
     * (3가지의 모자 패턴  * 2가지의 옷 패턴) = 6가지 패턴
     *   1. 아무것도 안 입음
     *   2. 모자1
     *   3. 모자2
     *   4. 옷 1
     *   5. 모자1 + 옷1
     *   6. 모자2 + 옷1
     *
     * 3. 아무것도 안 입은 경우를 제외하고 나머지 수를 리턴
     *    6-1 = 5
     * */
    public static int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> clothesMap = new HashMap<>(); // 종류 : 갯수

        for (String[] clothe : clothes) {
            clothesMap.put(clothe[1], clothesMap.getOrDefault(clothe[1], 0) + 1);
        }

        // 경우의 수 체크 answer *= (옷 가지수 + 안 입을 경우)
        for (int val : clothesMap.values()){
            answer *= (val+1);
        }

        // 모두 다 안입는 경우는 존재하지 않으므로 -1
        return answer-1;
    }
}
