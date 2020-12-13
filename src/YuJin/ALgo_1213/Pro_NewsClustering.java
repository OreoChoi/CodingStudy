package YuJin.Algo_1213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Pro_NewsClustering {
    public static int solution(String str1, String str2) {
        int answer = 0;
        HashMap<String, Integer> mapOne = getStringMap(str1.toUpperCase());
        HashMap<String, Integer> mapTwo = getStringMap(str2.toUpperCase());
        HashMap<String, Integer> unionMap = mapOne;

        int intercnt = 0;
        int unioncnt = 0;
        if (mapOne.size() != 0 || mapTwo.size() != 0) {
            for (String s : mapOne.keySet()) {
                if (mapTwo.containsKey(s)) intercnt += Math.min(mapOne.get(s), mapTwo.get(s));
            }

            for (String s : mapTwo.keySet()) {
                if (unionMap.containsKey(s)) unionMap.put(s, Math.max(unionMap.get(s), mapTwo.get(s)));
                else unionMap.put(s, mapTwo.get(s));
            }
            for (int i : unionMap.values()) {
                unioncnt += i;
            }


            double d = (double) intercnt / unioncnt * 65536;
            answer = (int) d;
        } else answer = 65536;

        return answer;
    }

    public static HashMap<String, Integer> getStringMap(String str) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length() - 1; i++) {
            char cone = str.charAt(i);
            char ctwo = str.charAt(i + 1);

            if (cone == '_' || ctwo == '_') continue;
            if (cone < 'A' || ctwo > 'Z') continue;
            if (ctwo < 'A' || ctwo > 'Z') {
                i++;
                continue;
            }

            String s = Character.toString(cone) + Character.toString(ctwo);
            if (hashMap.containsKey(s)) hashMap.put(s, hashMap.get(s) + 1);
            else hashMap.put(s, 1);
        }
        System.out.println();
        return hashMap;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = "abba";
        String str2 = "ab_ba";
        System.out.print(solution(str1, str2));
    }
}

