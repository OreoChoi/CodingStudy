package Doyeon.p_20201129;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 위장
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 * 맵을 이용해서 처리
 */
public class Pro_Camouflage {
    public static int solution(String[][] clothes) {
        int result = 1;
        // 종류별로 List를 갖도록 선언
        Map<String, List<String>> clothMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            // 맵에 해당 종류리스트가 이미 있으면 리스트에 넣어주고
            if (clothMap.get(clothes[i][1]) != null) {
                clothMap.get(clothes[i][1]).add(clothes[i][0]);
            } else { // 없으면 리스트를 만들고 맵에 담아주기
                List<String> list = new ArrayList<>();
                list.add(clothes[i][0]);
                clothMap.put(clothes[i][1], list);
            }
        }
        // 종류별로 가능한 가짓수를 곱하기
        // headgear는 3가지 -> yellow_hat, green_turban, X
        // eyewear는 2가지 -> blue_sunglasses, X
        // 3 * 2
        for (Map.Entry<String, List<String>> entry : clothMap.entrySet()) {
            result *= (entry.getValue().size() + 1);
        }
        // 모두 안 입는 케이스 빼주기
        return result - 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }
}
