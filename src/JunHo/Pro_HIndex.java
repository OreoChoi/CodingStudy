package JunHo;

import java.util.Arrays;

/**
 * jhChoi - 201122
 * 프로그래머스 H-Index
 * <p>
 * [문제 설명]
 * 과학자의 발표 논문 N편 중,
 * H번 이상 인용된 논문이 H번 이상이고 나머지 논문이 H번 이하인용되었다면
 * H의 최대값이 이 과학자의 H-Index입니다.
 */
public class Pro_HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 4, 6, 1, 5};
        System.out.println(solution(citations));
    }

    static int solution(int[] cit) {
        int H = 1;
        Arrays.sort(cit);

        if (cit[cit.length - 1] == 0) {
            return 0;
        }

        for (int hIndex = 1; hIndex <= cit.length; hIndex++) {
            int index = 0;
            boolean result = true;

            for (int i = index; i < cit.length; i++) {
                if (hIndex <= cit[i]) {  //현재 남은 논문 수가 hIndex 이상이면
                    for (int j = cit.length - hIndex - 1; j >= 0; j--) { //남은 논문들이 hIndex개 이상이 있는지 체크
                        if (cit[j] > hIndex) {
                            result = false;
                            break;
                        }
                    }

                    if (result) { //남은 논문들이 hIndex개 이상이 없으면 리턴
                        H = hIndex;
                        break;
                    }
                }
            }

            if (result) {
                break;
            }
        }

        return H;
    }

    /**
     * 제 코드가 아닌 깔끔한 코드를 인용하였습니다.
     * -------------------------------------------------
     * 정렬 전 [3,0,6,1,5]
     * 정렬 후 [0,1,3,5,6]
     *
     * 알고리즘 순서
     *  1. 논문 인용 횟수 array를 역순으로 순회합니다.
     *  2. h-index 후보 = Math.min (현재 논문 인용 횟수, 확인한 논문 수)
     *  3. max와 비교해 h-index후보가 더 크다면 max에 대입한다.
     *
     *  실제 순서
     *  1. min = Math.min(6,1)
     *     max = 1
     *  2. min = Math.min(5,2)
     *     max = 2
     *  3. min = Math.min(3,3)
     *     max = 3
     *  4. min = Math.min(1,4)
     *     max = max
     *  5. min = Math.min(0,5)
     *     max = max
     * */
    public static int bestSolution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for (int i = citations.length-1; i > -1; i--) {
            int min = Math.min(citations[i],citations.length-i);
            if(max<min) max = min;
        }

        return max;
    }
}
