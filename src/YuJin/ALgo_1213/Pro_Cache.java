package YuJin.Algo_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Pro_Cache {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cacheSize = 3;
        String[] cities = {"jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };

        int answer = 0;
        LinkedList<String> cache = new LinkedList<String>();

        if(cacheSize==0) {
            answer=cities.length*5;
        } else {
            for (String s : cities) {
                s=s.toUpperCase();
                if (cache.contains(s)) {
                    cache.remove(s);
                    cache.add(s);
                    answer += 1;
                } else {
                    if (cache.size() >= cacheSize) {
                        cache.removeFirst();
                    }
                    cache.add(s);
                    answer += 5;
                }
            }
        }
        System.out.print(answer);
    }
}
