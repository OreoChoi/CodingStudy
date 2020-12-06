package JunHo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * jhChoi - 201206
 * 프로그래머스 - 캐시
 *
 * 예) 제주가 Cache Hit 인 경우
 *  1.  cache(Seoul,Jeju,Pangyo) -> cache(Seoul,Pangyo,Jeju)
 */
public class Pro_Cache {
    public static void main(String[] args) {
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] cities4 = {"Seoul", "Seoul", "Seoul"};
        //System.out.println(solution(0, cities));
        //System.out.println(solution(3,cities2));
        System.out.println(solution(2,cities3));
        //System.out.println(solution(1, cities4));
    }

    private static final int CACHE_HIT = 1;
    private static final int CACHE_MISS = 5;

    public static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * CACHE_MISS;
        Queue<String> cache = new LinkedList<>();   //cache를 담을 queue
        int runningTime = 0;

        for (String s : cities) {
            String city = s.toLowerCase();  //대소문자 구분을 없이 처리를 위해 소문자 통일

            if (cache.contains(city)) {     //CACHE_HIT 인 경우
                runningTime += CACHE_HIT;
                int queueSize = cache.size();
                for (int i = 0; i < queueSize; i++) {   //큐를 순회하며 cache된 city를 큐의 최신위치(마지막)로 재배치
                    String curCache = cache.poll();
                    if (!city.equals(curCache)) cache.add(curCache);
                }
            } else {    //CACHE_MISS인 경우
                runningTime += CACHE_MISS;
                if (cache.size() == cacheSize) cache.poll();
            }
            cache.add(city);
        }
        return runningTime;
    }
}
